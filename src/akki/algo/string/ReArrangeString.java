package akki.algo.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class ReArrangeString {
    public static void main (String[] args) throws IOException {


            String str = "DORWBL4A16H1";
            System.out.println(sort(str).trim());

    }

    static String sort(String str){
        char[] chArr = str.toCharArray();
        Arrays.sort(chArr);
        int sum = 0;
        int i = 1;
        for (; i < chArr.length; i++) {
            if(chArr[i]>'9'){
                break;
            }
            int digitsAdd = Character.getNumericValue(chArr[i-1]) + Character.getNumericValue(chArr[i]);
            String digitAddStr = String.valueOf(digitsAdd);
            int length = digitAddStr.length();
            int x = i, y =0;
            while (length>0) {
                chArr[x - 1] = ' ';
                chArr[x] = digitAddStr.charAt(length-1);
                length--;
               x--;
            }
        }
        char temp = chArr[i-1];
        chArr[i-1] = chArr[str.length()-1];
        chArr[str.length()-1] = temp;
        return String.valueOf(chArr);
    }
}

/*package whatever //do not write package name here */

