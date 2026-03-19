package dsa.arrays_hashing.practice;

import java.util.Arrays;

/**
 * LeetCode 1 — Two Sum
 * https://leetcode.com/problems/two-sum/
 *
 * Given an array of integers and a target, return the indices of the two
 * numbers that add up to the target. Exactly one solution exists.
 * You may not use the same element twice.
 *
 * Example 1:
 *   Input:  nums = [2, 7, 11, 15], target = 9
 *   Output: [0, 1]
 *
 * Example 2:
 *   Input:  nums = [3, 2, 4], target = 6
 *   Output: [1, 2]
 *
 * Example 3:
 *   Input:  nums = [3, 3], target = 6
 *   Output: [0, 1]
 *
 * Constraints:
 *   - 2 <= nums.length <= 10^4
 *   - Only one valid answer exists
 *
 * Hint: For each element, what value do you need to find to complete the pair?
 *       Can you store what you have already seen to avoid a second loop?
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9))); // [0, 1]
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 2, 4}, 6)));      // [1, 2]
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 3}, 6)));         // [0, 1]
    }
}
