package problemsolving;
/*
Average Product

1.Given an array of N integers. Now, you can perform the following operation on this array:
Remove exactly k integers from the front of the array or back of the array and take the average of these integers.

2.Insert the floor value of this average value obtained in the above step to the respective side of the array from where you removed the integers.

3.Repeat the above operations in that order as many times as you want or till the time there are at least k integers in the array.
Now, you have to find the maximum product of the floor of average values that you have obtained in each operation. Since the number could be very large output it modulo 10^9 + 7.

Note: Once you have decided a side (front-side or back-side of the array), you cannot switch it during all the performed operations.

Input Format:
The first line of the input contains two space-separated integers N and k, the total number of elements in the array and the number of elements to remove from the array in each operation. The next line contains N space-separated integers representing the elements of the array.

Output Format:
In the single line of output print the maximum product of the floor of average values modulo 10^9 + 7.

Constraints
1≤N≤10^5
1≤k≤N
0≤|Ai|≤10^9

Sample Input
6 3
5 4 -2 7 3 -1

Sample Output
8

Explanation:
Note that, it is optimal to pick the elements from the front of the array.
Operation 1: [5,4,−2]=7/3=2
Array becomes, [2,7,3,−1]
Operation 2: [2,7,3]=12/3=4
Array becomes, [4,−1]
Now, you cannot perform operations further.

Maximum product = 2*4=8


*/
public class AverageProductOfNumbers {

    static int startindex = 0;
    static int groupSize = 2;
    static int endindex = groupSize - 1;
    private static boolean isFirstRun = true;
    private static int preavg = 0;
    private static int preProduct = 1;

    public static void main(String[] args) {
        Integer[] array = new Integer[]{5, 4, -2, 7, 3, -1};


        while (endindex < array.length || preProduct == 0) {

            int sum = sum(array, startindex, endindex);
            int avg = avg(sum, preavg);
            System.out.format("before start=%d end=%d preavg=%d avg=%d%n", startindex, endindex, preavg, avg);
            preavg = avg;
            preProduct *= preavg;
            startindex = endindex + 1;
            endindex = endindex + groupSize - 1;
            System.out.format("after start=%d end=%d preavg=%d avg=%d product=%d%n", startindex, endindex, preavg, avg,preProduct);
        }

        System.out.format("Prduct is:%d", preProduct);
    }


    public static int avg(int sum, int prevAvg) {
        if (isFirstIteration()) {
            isFirstRun = false;
            return sum / groupSize;
        }
        return (sum + prevAvg) / groupSize;
    }

    private static boolean isFirstIteration() {
        return isFirstRun;
    }

    public static Integer sum(Integer[] array, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += array[i];
        }
        return sum;
    }

}

/* while ( endindex < array.length ) {
            //Arrays.stream(array)
            System.out.format("index val start:%d End:%d%n" ,startindex, endindex );
            OptionalDouble averageVal =  Arrays.asList(array)
                    .subList(startindex, endindex)
                    .stream()
                    .limit(k)
                    .mapToInt(value -> value)
                    .average();

            if(averageVal.isPresent()){
                averageProduct *= Math.floor(averageVal.getAsDouble());
            }
            System.out.println("averageVal:" + averageVal.toString());
            startindex += k;
            endindex += k;
            System.out.println("Endindex:" + endindex);
        }


        System.out.println(averageProduct);*/


