import re
import operator
import sys
import getopt
import time

ClassToChangedInstanceCountMap={}
ClassToChangedSizeCountMap={}
#slNumCol=0
noOfInstancesCol=1 #for noOfInstancesCol difference
sizeOfInstancesCol=2 #for memeory difference
classNameCol=3 #Class name column number in histogram record
mapofObjects={}
content=[]
afterGCRecords=[]
againGCRecords=[]
secondClassNameToHistosMap={}
firstClassNameToHistosMap={}
packageFilterRegex=[]#['com\.nokia.*'] # enable this based on need
packagesToIgnoreRegex=[]
topNsuspects=20

def loadRecordToMap(line, map):
    if (':' in line):
        splitedLine = line.split()
        if (len(splitedLine) > 1):
            tempNumOfInstAndSizeList=[]
            tempNumOfInstAndSizeList.append(splitedLine[noOfInstancesCol])
            tempNumOfInstAndSizeList.append(splitedLine[sizeOfInstancesCol])
            map[splitedLine[classNameCol]] = tempNumOfInstAndSizeList

def parseFiles(firstRunGCHistoFile, secondRunGCHistoFile):
    with open(secondRunGCHistoFile) as agFile:
        agFileLine = agFile.readline()
        while agFileLine:
            agFileLine.strip()
            agFileLine = agFile.readline()
            loadRecordToMap(agFileLine, secondClassNameToHistosMap)

    with open(firstRunGCHistoFile) as afFile:
        afFileLine = afFile.readline()
        while afFileLine:
            afFileLine.strip()
            afFileLine = afFile.readline()
            loadRecordToMap(afFileLine, firstClassNameToHistosMap)

def sortDescOrderByValue(map):
    return sorted(map.items(), key=operator.itemgetter(1), reverse=True)

def getSizeDiff(secondList, firstList):
    return int(secondList[1]) - int(firstList[1])

def getInstanceDiff(secondList, firstList):
    return int(secondList[0]) - int(firstList[0]) #againNoOfInstance-afterNoOfInstances



def getVarience(increase, firstList):
    percentageIncrease = (increase / int(firstList[0])) * 100
    return round(percentageIncrease, 2)


def getAnalysisDetails(secondList, firstList):
    analysisList=[]
    increase =getInstanceDiff(secondList, firstList)
    analysisList.append(increase)
    analysisList.append(getVarience(increase,firstList))
    return analysisList


def process():
    for className in firstClassNameToHistosMap:
        firstList=firstClassNameToHistosMap[className]
        secondList = secondClassNameToHistosMap[className]

        if len(secondList)>0:
            ClassToChangedInstanceCountMap[className] =getAnalysisDetails(secondList, firstList)
            ClassToChangedSizeCountMap[className]=getSizeDiff(secondList, firstList)

def generateReports():
    file_created_on = time.strftime("%Y%m%d-%H%M%S")
    sortedInstanceDiffMap = sortDescOrderByValue(ClassToChangedInstanceCountMap)
    sortedSizeDiffMap = sortDescOrderByValue(ClassToChangedSizeCountMap)

    report_file = open("MemLeakSuspectReport_"+file_created_on+".txt", "w")
    #write report for top N
    writeWithNewLine(report_file, '--------Suspects by Instance count Report START----------')
    writeWithNewLine(report_file, 'Object Name,Non reclaimed Instances count,Variance in percentage')
    count=0
    for (className, analysisDetails) in sortedInstanceDiffMap:

        if count<topNsuspects:
            if len(packageFilterRegex)>0:
                for regex in packageFilterRegex:
                    isMatch=re.match(regex,className, re.IGNORECASE)
                if isMatch:
                    count += 1
                    writeWithNewLine(report_file, className + "," + str(analysisDetails[0]) + "," + str(analysisDetails[1]))
            else:
                count += 1
                writeWithNewLine(report_file, className + "," + str(analysisDetails[0]) + "," + str(analysisDetails[1]))

    writeWithNewLine(report_file, '--------Suspects by Instance count Report END----------')

    writeWithNewLine(report_file, '--------Suspects by Size Report START----------')
    writeWithNewLine(report_file, 'Object Name,Non reclaimed Size')
    count = 0
    for (className, instanceCount) in sortedSizeDiffMap:

        if count < topNsuspects:
            if len(packageFilterRegex) > 0:
                for regex in packageFilterRegex:
                    isMatch = re.match(regex, className, re.IGNORECASE)
                if isMatch:
                    count += 1
                    writeWithNewLine(report_file, className + "," + str(instanceCount))
            else:
                count += 1
                writeWithNewLine(report_file, className + "," + str(instanceCount))
    writeWithNewLine(report_file, '--------Suspects by Size Report END----------')
    report_file.close()

def writeWithNewLine(file, line):
    file.write(line + '\n')

def main(argv):
    print("A Python Script to parse the Jcmd generated Histograms")
    print("Usage- histogramparser.py  -f firstRunGCHistoFile.txt -s secondRunGCHistoFile.txt -n 20")
    print("Reference https://gist.github.com/alexcpn/a68761c94c85f0210413")

    print(argv)
    firstRunGCHistoFile = ''
    secondRunGCHistoFile = ''

    try:
        opts, args = getopt.getopt(argv, "hf:s:n", ["ffile=", "sfile=", "ntop="])
    except getopt.GetoptError:
        print
        'histogramparser.py -f <firstRunGCHistoFile> -s <secondRunGCHistoFile> -n <topNsuspects>'
        sys.exit(2)
    for opt, arg in opts:
        #print(opt, ':', arg)
        if opt == '-h':
            print
            'histogramparser.py -f <firstRunGCHistoFile> -s <secondRunGCHistoFile> -n <topNsuspects>'
            sys.exit()
        elif opt in ("-f", "--ffile"):
            firstRunGCHistoFile = arg
        elif opt in ("-s", "--sfile"):
            secondRunGCHistoFile = arg
        elif opt in ("-n", "--ntop"):
            topNsuspects = arg

    #print('First Input file is "', firstRunGCHistoFile)
    #print('Second Input file is "', secondRunGCHistoFile)
    print('TopN suspects', topNsuspects)


    parseFiles(firstRunGCHistoFile, secondRunGCHistoFile)
    process()
    generateReports()


if __name__ == "__main__":
   main(sys.argv[1:])