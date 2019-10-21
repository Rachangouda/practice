package problemsolving;


import java.io.*;
import java.util.*;
import java.util.stream.Stream;


public class DigitOrLetter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String str = br.readLine().trim();

        int out_ = CountDIGIT(str);
        wr.println(out_);
        int out1_ = CountLETTER(str);
        wr.println(out1_);

        wr.close();
        br.close();
    }

    static int CountDIGIT(String str) {
        // Write your code here
        //str.chars().forEach(ch -> System.out.println(ch));

        return (int)str.chars().filter(ch -> ch>= 48 && ch<=57).count();
    }

    static int CountLETTER(String str) {
        // Write your code here
        return (int)str.chars().filter(ch -> (ch>= 65 && ch<=90) || (ch>= 97 && ch<=122) ).count();
    }
}