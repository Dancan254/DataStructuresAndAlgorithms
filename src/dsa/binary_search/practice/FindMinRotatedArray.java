package dsa.binary_search.practice;

/**
 * LeetCode 153 — Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * A sorted array of unique integers has been rotated at an unknown pivot.
 * Find the minimum element in O(log n).
 *
 * Example 1:
 *   Input:  [3, 4, 5, 1, 2]
 *   Output: 1
 *
 * Example 2:
 *   Input:  [4, 5, 6, 7, 0, 1, 2]
 *   Output: 0
 *
 * Example 3:
 *   Input:  [11, 13, 15, 17]
 *   Output: 11   (not rotated)
 *
 * Constraints:
 *   - 1 <= nums.length <= 5000
 *   - All integers are unique
 *
 * Hint: At any mid point, compare nums[mid] to nums[hi].
 *       If nums[mid] > nums[hi], the minimum must be in the right half.
 *       Otherwise the minimum is in the left half including mid.
 *       Loop terminates when lo == hi — that is your answer.
 */
public class FindMinRotatedArray {

    public int findMin(int[] nums) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        FindMinRotatedArray solution = new FindMinRotatedArray();

        System.out.println(solution.findMin(new int[]{3, 4, 5, 1, 2}));       // 1
        System.out.println(solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2})); // 0
        System.out.println(solution.findMin(new int[]{11, 13, 15, 17}));      // 11
        System.out.println(solution.findMin(new int[]{2, 1}));                 // 1
        System.out.println(solution.findMin(new int[]{1}));                    // 1
    }
}
