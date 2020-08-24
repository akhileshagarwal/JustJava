package akki.algo.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CasespecificSorting {

    public static String caseSort(String str) {
        char[] lowerCase = new char[str.length()];
        char[] upperCase = new char[str.length()];
        Arrays.fill(lowerCase, Character.MAX_VALUE);
        Arrays.fill(upperCase, Character.MAX_VALUE);
        StringBuffer stringBuffer = new StringBuffer();
        char[] strArr = str.toCharArray();
        for (int i = 0, li = 0, ui = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                lowerCase[li] = ch;
                li++;
            } else {
                upperCase[ui] = ch;
                ui++;
            }
        }

        Arrays.sort(lowerCase);
        Arrays.sort(upperCase);

        for (int i = 0, li = 0, ui = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                stringBuffer.append(lowerCase[li]);
                li++;
            } else {
                stringBuffer.append(upperCase[ui]);
                ui++;
            }
        }

        return stringBuffer.toString();
    }

    // Driver program
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            int len = Integer.parseInt(bf.readLine());

            String num = caseSort(bf.readLine());
            // Collections.sort(arr, Collections.reverseOrder());
            System.out.println(num);
        }
    }
}


