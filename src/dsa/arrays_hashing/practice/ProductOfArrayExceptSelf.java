package dsa.arrays_hashing.practice;

import java.util.Arrays;

/**
 * LeetCode 238 — Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * Given an integer array, return an array where output[i] is the product of
 * all elements except nums[i]. You must not use the division operator.
 * Must run in O(n) time.
 *
 * Example:
 *   Input:  [1, 2, 3, 4]
 *   Output: [24, 12, 8, 6]
 *
 * Constraints:
 *   - 2 <= nums.length <= 10^5
 *   - -30 <= nums[i] <= 30
 *   - The product of any prefix or suffix fits in a 32-bit integer
 *
 * Hint: For each position i, the answer is:
 *         (product of everything to the LEFT of i)
 *       * (product of everything to the RIGHT of i)
 *       Can you compute both in a single result array using two passes?
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();

        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{1, 2, 3, 4})));       // [24, 12, 8, 6]
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{-1, 1, 0, -3, 3}))); // [0, 0, 9, 0, 0]
    }
}
