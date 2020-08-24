package akki.algo.string;

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG12 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            String[] inputArr = bf.readLine().split(" ");
            String b1 = inputArr[0];
            String b2 = inputArr[1];
            System.out.println(binaryToDecimal(b1, b1.length(), 0) * binaryToDecimal(b2, b2.length(), 0));
        }
        bf.close();
    }

    static int binaryToDecimal(String binaryNumber, int length, int indexToEval) {
        if (length < 1) {
            return 0;
        }
        return (int) Math.pow(2, length - 1) * Character.getNumericValue(binaryNumber.charAt(indexToEval)) + binaryToDecimal(binaryNumber, length - 1, ++indexToEval);
    }
}
