package akki.algo.string;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class AnagramStrings {

    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);
        int i = 0, j = 0, ch = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1Arr[i] == s2Arr[j]) {
                i++;
                j++;
            } else if (s1Arr[i] > s2Arr[j]) {
                j++;
                ch++;
            } else {
                i++;
                ch++;
            }
        }
        int result = (s1.length() - i) + (s2.length() - j) + ch;
        return result;

    }

    static int makingAnagramsEfficiently(String s1, String s2){
        int cArr[]=new int[26];
        for(int i=0;i<s1.length();i++)cArr[s1.charAt(i)-97]++;
        for(int i=0;i<s2.length();i++)cArr[s2.charAt(i)-97]--;
        int count=0;
        for(int i=0;i<26;i++)count+=Math.abs(cArr[i]);
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        int result2 = makingAnagramsEfficiently(s1,s2);
        System.out.println(result);
        System.out.println(result2);

        scanner.close();
    }
}
