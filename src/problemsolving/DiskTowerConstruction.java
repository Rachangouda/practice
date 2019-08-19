package problemsolving;


import java.io.*;
import java.util.*;


class DiskTowerConstruction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        String[] arr_arr = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i_arr = 0; i_arr < arr_arr.length; i_arr++) {
            arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
        }

        ArrayList<Integer>[] out_ = Solve(arr);
        for (int i_out_ = 0; i_out_ < out_.length; i_out_++) {

            for (int j_out_ = 0; j_out_ < out_[i_out_].size(); j_out_++) {
                System.out.print(out_[i_out_].get(j_out_) + " ");
            }
            System.out.println("");
        }

        wr.close();
        br.close();
    }

    static ArrayList<Integer>[] Solve(int[] arr) {
        int totaldays= arr.length;
        ArrayList<Integer>[] printorder = new ArrayList[totaldays];

        Set<Integer> usedDisk = new HashSet<>();
        SortedSet<Integer> unusedDisk = new TreeSet<>();
        int previousDisk= totaldays;



        for (int i = 0; i < totaldays ; i++) {
            ArrayList<Integer> ithdaylist = new ArrayList<>();

            //int uptoithdayarr[] = new int[i+1];
            //System.arraycopy(arr,0,uptoithdayarr,0,i+1);

            //int useddisksize= usedDisk.size();

            LinkedList<Integer> removelist = new LinkedList<>();
            LinkedList<Integer> addlist = new LinkedList<>();

            unusedDisk.add(arr[i]);
            for (Integer ele :
                    removelist) {
                unusedDisk.remove(ele);
            }
            for (Integer ele :
                    addlist) {
                unusedDisk.add(ele);
            }


            Iterator<Integer> descitr = ((TreeSet<Integer>) unusedDisk).descendingIterator();
            while (descitr.hasNext()) {

                int ithdaydisk = descitr.next();

                if(ithdaydisk == previousDisk){
                    usedDisk.add(ithdaydisk);
                    previousDisk--;
                    ithdaylist.add(ithdaydisk);
                    removelist.add(ithdaydisk);
                }
                /*if(usedDisk.contains(ithdaydisk)) {
                    continue;
                }*/
                else
                {
                    addlist.add(ithdaydisk);
                }
            }

            printorder[i] = ithdaylist;
        }
        return printorder;
    }
}

/*

package problemsolving;


        import java.io.*;
        import java.util.*;


class DiskTowerConstruction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        String[] arr_arr = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i_arr = 0; i_arr < arr_arr.length; i_arr++) {
            arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
        }

        ArrayList<Integer>[] out_ = Solve(arr);
        for (int i_out_ = 0; i_out_ < out_.length; i_out_++) {

            for (int j_out_ = 0; j_out_ < out_[i_out_].size(); j_out_++) {
                System.out.print(out_[i_out_].get(j_out_) + " ");
            }
            System.out.println("");
        }

        wr.close();
        br.close();
    }

    static ArrayList<Integer>[] Solve(int[] arr) {
        int totaldays= arr.length;
        ArrayList<Integer>[] printorder = new ArrayList[totaldays];

        Set<Integer> usedDisk = new HashSet<>();

        int previousDisk= totaldays;

        for (int i = 0; i < totaldays ; i++) {
            ArrayList<Integer> ithdaylist = new ArrayList<>();

            int uptoithdayarr[] = new int[i+1];
            System.arraycopy(arr,0,uptoithdayarr,0,i+1);

            Arrays.parallelSort(uptoithdayarr);
            System.out.println(Arrays.toString(uptoithdayarr));

            for (int ithday = i; ithday >= 0 ; ithday--) {

                int ithdaydisk = uptoithdayarr[ithday];
                if(usedDisk.contains(ithdaydisk)){
                    continue;
                }
                else if(ithdaydisk == previousDisk){
                    usedDisk.add(ithdaydisk);
                    previousDisk--;
                    ithdaylist.add(ithdaydisk);
                }
            }

            printorder[i] = ithdaylist;
        }
        return printorder;
    }
}




import java.io.*;
        import java.util.*;


class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        String[] arr_arr = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i_arr = 0; i_arr < arr_arr.length; i_arr++) {
            arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
        }

        ArrayList<Integer>[] out_ = Solve(arr);
        for (int i_out_ = 0; i_out_ < out_.length; i_out_++) {

            for (int j_out_ = 0; j_out_ < out_[i_out_].size(); j_out_++) {
                System.out.print(out_[i_out_].get(j_out_) + " ");
            }
            System.out.println("");
        }

        wr.close();
        br.close();
    }

    static ArrayList<Integer>[] Solve(int[] arr) {

        int totaldays=arr.length;
        ArrayList<Integer>[] printorder = new ArrayList[totaldays];

        Set<Integer> usedDisk = new HashSet<>();

        int previousDisk = totaldays;

        for(int i=0; i< totaldays; i++){

            ArrayList<Integer> ithdaylist = new ArrayList<>();
            //int uptoithdayarr[] = new int[i+1];
            //System.arraycopy(arr,0, uptoithdayarr,0,i+1);

            //int [] intmarr = new int[];

            Arrays.parallelSort(arr, 0, i+1);
            for(int ithday=i-usedDisk.size(); ithday>=0; ithday--){

                int ithdaydisk = arr[ithday];

                if(usedDisk.contains(ithdaydisk)){

                    continue;
                }
                else if(ithdaydisk == previousDisk){
                    usedDisk.add(ithdaydisk);
                    previousDisk--;
                    ithdaylist.add(ithdaydisk);
                }
                else{
                    break;
                }

            }

            printorder[i] = ithdaylist;
        }

        return printorder;
    }
}

package problemsolving;


        import java.io.*;
        import java.util.*;


class DiskTowerConstruction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        String[] arr_arr = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i_arr = 0; i_arr < arr_arr.length; i_arr++) {
            arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
        }

        ArrayList<Integer>[] out_ = Solve(arr);
        for (int i_out_ = 0; i_out_ < out_.length; i_out_++) {

            for (int j_out_ = 0; j_out_ < out_[i_out_].size(); j_out_++) {
                System.out.print(out_[i_out_].get(j_out_) + " ");
            }
            System.out.println("");
        }

        wr.close();
        br.close();
    }

    static ArrayList<Integer>[] Solve(int[] arr) {
        int totaldays= arr.length;
        ArrayList<Integer>[] printorder = new ArrayList[totaldays];

        Set<Integer> usedDisk = new HashSet<>();
        SortedSet<Integer> unusedDisk = new TreeSet<>();
        int previousDisk= totaldays;



        for (int i = 0; i < totaldays ; i++) {
            ArrayList<Integer> ithdaylist = new ArrayList<>();

            //int uptoithdayarr[] = new int[i+1];
            //System.arraycopy(arr,0,uptoithdayarr,0,i+1);

            //int useddisksize= usedDisk.size();

            LinkedList<Integer> removelist = new LinkedList<>();
            LinkedList<Integer> addlist = new LinkedList<>();

            unusedDisk.add(arr[i]);
            for (Integer ele :
                    removelist) {
                unusedDisk.remove(ele);
            }
            for (Integer ele :
                    addlist) {
                unusedDisk.add(ele);
            }


            Iterator<Integer> descitr = ((TreeSet<Integer>) unusedDisk).descendingIterator();
            while (descitr.hasNext()) {

                int ithdaydisk = descitr.next();

                if(ithdaydisk == previousDisk){
                    usedDisk.add(ithdaydisk);
                    previousDisk--;
                    ithdaylist.add(ithdaydisk);
                    removelist.add(ithdaydisk);
                }
                /*if(usedDisk.contains(ithdaydisk)) {
                    continue;
                }*/
                /*else
                {
                    addlist.add(ithdaydisk);
                }
            }

            printorder[i] = ithdaylist;
        }
        return printorder;
    }
}*/