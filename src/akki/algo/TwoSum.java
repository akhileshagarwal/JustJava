package akki.algo;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

    }

    public int[] twoSum1(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        throw new IllegalArgumentException("");
    }

    /**
     *
     * We reduce the look up time from O(n)O(n) to O(1)O(1) by trading space for speed. A hash table is built exactly for this purpose,
     * it supports fast look up in near constant time. I say "near" because if a collision occurred, a look up could degenerate to O(n)O(n) time.
     * But look up in hash table should be amortized O(1)O(1) time as long as the hash function was chosen carefully.
     *
     * A simple implementation uses two iterations. In the first iteration, we add each element's value and its index to the table.
     * Then, in the second iteration we check if each element's complement (target - nums[i]target−nums[i]) exists in the table. Beware that the complement must not be nums[i]nums[i] itself!
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * It turns out we can do it in one-pass. While we iterate and inserting elements into the table, we also look back to check if current element's complement already exists in the table.
     * If it exists, we have found a solution and return immediately.
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
