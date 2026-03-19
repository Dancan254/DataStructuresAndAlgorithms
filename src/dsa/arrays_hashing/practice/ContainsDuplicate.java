package dsa.arrays_hashing.practice;

/**
 * LeetCode 217 — Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 *
 * Given an integer array, return true if any value appears at least twice,
 * and false if every element is distinct.
 *
 * Example 1:
 *   Input:  [1, 2, 3, 1]
 *   Output: true
 *
 * Example 2:
 *   Input:  [1, 2, 3, 4]
 *   Output: false
 *
 * Constraints:
 *   - 1 <= nums.length <= 10^5
 *   - -10^9 <= nums[i] <= 10^9
 *
 * Hint: You need to answer "have I seen this value before?" in O(1).
 *       Which data structure gives you that?
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();

        System.out.println(solution.containsDuplicate(new int[]{1, 2, 3, 1}));    // true
        System.out.println(solution.containsDuplicate(new int[]{1, 2, 3, 4}));    // false
        System.out.println(solution.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2})); // true
    }
}
