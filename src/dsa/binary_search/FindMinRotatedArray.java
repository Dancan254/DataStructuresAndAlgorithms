package dsa.binary_search;

/**
 * LeetCode 153 — Find Minimum in Rotated Sorted Array
 *
 * A sorted array was rotated at an unknown pivot. Find the minimum element.
 * All elements are unique.
 *
 * Pattern: Binary search — identify sorted half
 *
 * Compare nums[mid] to nums[hi]:
 *   - If nums[mid] > nums[hi], the minimum must be in the right half (lo = mid+1).
 *   - Otherwise the minimum is in the left half including mid (hi = mid).
 *
 * Time:  O(log n)
 * Space: O(1)
 */
public class FindMinRotatedArray {

    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                // mid is in the inflated left portion; minimum is to the right
                lo = mid + 1;
            } else {
                // mid is in the sorted right portion; minimum is at mid or left of it
                hi = mid;
            }
        }

        return nums[lo];
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        FindMinRotatedArray solution = new FindMinRotatedArray();

        System.out.println(solution.findMin(new int[]{3, 4, 5, 1, 2}));    // 1
        System.out.println(solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2})); // 0
        System.out.println(solution.findMin(new int[]{11, 13, 15, 17}));   // 11 (no rotation)
    }
}
