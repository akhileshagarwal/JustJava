package akki.algo.arr;

import java.util.HashSet;
import java.util.Scanner;

public class CountDisctinct {

    public static int count(int[] num) {
        int n = num.length;
        int i = 0;
        int j = n - 1;
        int count = n;
        while (i < j) {
            while (i != j && num[i] == num[i + 1]) {
                count--;
                i++;
            }
            while (i != j && num[j] == num[j - 1]) {
                count--;
                j--;
            }

            int sum = num[i] + num[j];
            if (sum == 0) {
                count--;
                i++;
                j--;
            } else if (sum > 0) {
                j--;
            } else {
                i++;
            }
        }
        return count;
    }



    public static void main(String[] args) {
        System.out.println(countDistinct(new int[]{-1, 0, 2, 3}));
    }

    static int countDistinct(int[] arr) {
        if (arr.length == 0 || arr.length == 1) return arr.length;

        int count = 0;
        HashSet<Integer> integers = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!integers.contains(Math.abs(arr[i]))) {
                count++;
                integers.add(Math.abs(arr[i]));
            }
        }
        return count;
    }


}
