package dsa.two_pointers.practice;

import java.util.List;

/**
 * LeetCode 15 — 3Sum
 * https://leetcode.com/problems/3sum/
 *
 * Find all unique triplets in the array that sum to zero.
 * The solution set must not contain duplicate triplets.
 *
 * Example 1:
 *   Input:  [-1, 0, 1, 2, -1, -4]
 *   Output: [[-1, -1, 2], [-1, 0, 1]]
 *
 * Example 2:
 *   Input:  [0, 1, 1]
 *   Output: []
 *
 * Example 3:
 *   Input:  [0, 0, 0]
 *   Output: [[0, 0, 0]]
 *
 * Constraints:
 *   - 3 <= nums.length <= 3000
 *   - -10^5 <= nums[i] <= 10^5
 *
 * Hint: Sort the array first. Fix one element with index i, then use two
 *       pointers (lo = i+1, hi = end) to find pairs summing to -nums[i].
 *       Carefully skip duplicate values at all three pointer positions.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();

        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4})); // [[-1,-1,2],[-1,0,1]]
        System.out.println(solution.threeSum(new int[]{0, 1, 1}));              // []
        System.out.println(solution.threeSum(new int[]{0, 0, 0}));              // [[0,0,0]]
    }
}
