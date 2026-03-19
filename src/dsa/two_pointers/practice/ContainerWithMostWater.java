package dsa.two_pointers.practice;

/**
 * LeetCode 11 — Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 *
 * Given n vertical lines where height[i] is the height of line i,
 * find two lines that together with the x-axis form a container that holds
 * the most water.
 *
 * Example 1:
 *   Input:  [1, 8, 6, 2, 5, 4, 8, 3, 7]
 *   Output: 49   (lines at index 1 and 8: min(8,7) * 7 = 49)
 *
 * Example 2:
 *   Input:  [1, 1]
 *   Output: 1
 *
 * Constraints:
 *   - 2 <= height.length <= 10^5
 *   - 0 <= height[i] <= 10^4
 *
 * Hint: Area = min(height[lo], height[hi]) * (hi - lo).
 *       Start with lo=0 and hi=n-1. Which pointer should you move inward?
 *       Moving the taller line can never increase the area — prove why.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();

        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        System.out.println(solution.maxArea(new int[]{1, 1}));                        // 1
        System.out.println(solution.maxArea(new int[]{4, 3, 2, 1, 4}));               // 16
    }
}
