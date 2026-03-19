package dsa.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 15 — 3Sum
 *
 * Find all unique triplets in the array that sum to zero.
 *
 * Pattern: Three-pointer (fix + opposite-end scan)
 *
 * Sort the array, then for each index i run two pointers on the suffix.
 * Duplicate skipping is critical: skip equal values for i, lo, and hi
 * after recording a valid triplet.
 *
 * Time:  O(n²)
 * Space: O(1) extra (output list not counted)
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Positive anchor means no zero-sum triplet is possible further right
            if (nums[i] > 0) break;
            // Skip duplicate anchors
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                    lo++;
                    hi--;
                } else if (sum < 0) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return result;
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();

        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        // [[-1, -1, 2], [-1, 0, 1]]

        System.out.println(solution.threeSum(new int[]{0, 0, 0}));
        // [[0, 0, 0]]

        System.out.println(solution.threeSum(new int[]{0, 1, 1}));
        // []
    }
}
