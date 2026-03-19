package dsa.binary_search.practice;

/**
 * LeetCode 33 — Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * Given a rotated sorted array of unique integers, search for a target value.
 * Return its index, or -1 if not present. Must run in O(log n).
 *
 * Example 1:
 *   Input:  nums = [4, 5, 6, 7, 0, 1, 2], target = 0
 *   Output: 4
 *
 * Example 2:
 *   Input:  nums = [4, 5, 6, 7, 0, 1, 2], target = 3
 *   Output: -1
 *
 * Constraints:
 *   - 1 <= nums.length <= 5000
 *   - All values are unique
 *
 * Hint: At any mid point, at least one of the two halves [lo,mid] or [mid,hi]
 *       is guaranteed to be sorted.
 *       Determine which half is sorted, then check if the target falls within it.
 *       If yes — search that half. If no — search the other.
 */
public class SearchRotatedArray {

    public int search(int[] nums, int target) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        SearchRotatedArray solution = new SearchRotatedArray();

        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)); // 4
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)); // -1
        System.out.println(solution.search(new int[]{1}, 0));                    // -1
        System.out.println(solution.search(new int[]{1}, 1));                    // 0
        System.out.println(solution.search(new int[]{3, 1}, 1));                 // 1
    }
}
