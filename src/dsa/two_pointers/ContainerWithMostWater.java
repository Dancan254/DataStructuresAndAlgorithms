package dsa.two_pointers;

/**
 * LeetCode 11 — Container With Most Water
 *
 * Given heights of n vertical lines, find two lines that together with the
 * x-axis form a container holding the most water.
 *
 * Pattern: Opposite-end pointers
 *
 * Key invariant: area = min(height[lo], height[hi]) * (hi - lo).
 * Moving the taller line inward can never increase the min-height factor,
 * so we always move the shorter line to search for something better.
 *
 * Time:  O(n)
 * Space: O(1)
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int lo = 0, hi = height.length - 1;
        int maxWater = 0;

        while (lo < hi) {
            int h = Math.min(height[lo], height[hi]);
            maxWater = Math.max(maxWater, h * (hi - lo));

            // Move the shorter boundary — it is the limiting factor
            if (height[lo] < height[hi]) lo++;
            else hi--;
        }

        return maxWater;
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();

        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        System.out.println(solution.maxArea(new int[]{1, 1}));                        // 1
    }
}
