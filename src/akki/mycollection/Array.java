package akki.mycollection;

import java.util.Arrays;
import java.util.stream.Stream;

public class Array {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = {1,2};
        int[] num3 = new int[5];
        Arrays.fill(num3,0, 3, -50);
        for (int i = 0; i<num3.length;i++
             ) {
            System.out.println(num3[i]);
        }

    }
}
