package akki.algo.arr;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {

    static int findLongestConseqSubseq(int arr[], int n)
    {
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;

        // Hash all the array elements
        for (int i = 0; i < n; ++i)
            set.add(arr[i]);

        // check each possible sequence from the start
        // then update optimal length
        for (int i = 0; i < n; ++i) {
            // if current element is the starting
            // element of a sequence
            if (!set.contains(arr[i] - 1)) {
                // Then check for next elements
                // in the sequence
                int j = arr[i];
                while (set.contains(j))
                    j++;

                // update  optimal length if this
                // length is more
                if (ans < j - arr[i])
                    ans = j - arr[i];
            }
        }
        return ans;
    }

    // Testing program
    public static void main(String args[])
    {
        int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
        int n = arr.length;
        System.out.println(
                "Length of the Longest consecutive subsequence is "
                        + findLongestConseqSubseq(arr, n));
    }
}
