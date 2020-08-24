package akki.algo.arr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LengthofLongestSubarray {

    static int lengthOfLongestSubArr(int[] arr) {
        int count = 0;
        int finalCOunt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                count++;

            } else if (count > finalCOunt) {
                finalCOunt = count;

                count = 0;
            } else {
                count = 0;
            }
            if (count > finalCOunt) {
                finalCOunt = count;
            }
        }
        return finalCOunt;
    }

    public static void main1(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            int len = Integer.parseInt(bf.readLine());
            int[] arr = Arrays.stream(bf.readLine().split(" ")).map(Integer::parseInt).mapToInt(num -> (num == null ? 0 : num))
                    .toArray();

            int num = lengthOfLongestSubArr(arr);

            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubArr(new int[]{12, -1, -7, 8, -15, 30, 16, 28}));
    }
}
