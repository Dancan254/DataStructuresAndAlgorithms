package dsa.arrays_hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1 — Two Sum
 *
 * Given an array of integers and a target, return indices of the two numbers
 * that add up to the target. Exactly one solution exists.
 *
 * Pattern: Complement Lookup
 *
 * Naive approach: check all pairs — O(n²) time.
 * Optimal: for each element, the complement (target - nums[i]) must exist
 * somewhere. Store visited values in a HashMap for O(1) lookup.
 *
 * Time:  O(n)
 * Space: O(n)
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // Maps each value to its index so we can look up the complement in O(1)
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }

            // Store current element AFTER the complement check to avoid using
            // the same index twice (e.g. target=6, nums[0]=3).
            seen.put(nums[i], i);
        }

        // Problem guarantees exactly one solution, so this is unreachable.
        throw new IllegalArgumentException("No two sum solution");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));  // [0, 1]
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 2, 4}, 6)));       // [1, 2]
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 3}, 6)));          // [0, 1]
    }
}
