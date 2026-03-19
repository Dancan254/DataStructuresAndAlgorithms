package dsa.binary_search;

/**
 * LeetCode 33 — Search in Rotated Sorted Array
 *
 * Search for a target in a rotated sorted array. Return its index or -1.
 * All elements are unique.
 *
 * Pattern: Binary search — always one half is sorted
 *
 * At any mid point, exactly one of the two halves [lo,mid] or [mid,hi] is
 * sorted. Check if the target falls within the sorted half; if so, narrow to it.
 * Otherwise narrow to the other half.
 *
 * Time:  O(log n)
 * Space: O(1)
 */
public class SearchRotatedArray {

    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) return mid;

            // Left half [lo, mid] is sorted
            if (nums[lo] <= nums[mid]) {
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1; // target is in the sorted left half
                } else {
                    lo = mid + 1; // target must be in the right half
                }
            }
            // Right half [mid, hi] is sorted
            else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1; // target is in the sorted right half
                } else {
                    hi = mid - 1; // target must be in the left half
                }
            }
        }

        return -1;
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        SearchRotatedArray solution = new SearchRotatedArray();

        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)); // 4
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)); // -1
        System.out.println(solution.search(new int[]{1}, 0));                    // -1
    }
}
