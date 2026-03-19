package dsa.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * LeetCode 739 — Daily Temperatures
 *
 * For each day, return how many days until a warmer temperature.
 * Return 0 if no such future day exists.
 *
 * Pattern: Monotonic decreasing stack (stores indices)
 *
 * Maintain a stack of indices whose temperatures have not yet been resolved.
 * When a warmer day i arrives, pop all indices whose temperature is lower —
 * the answer for each popped index is (i - popped_index).
 *
 * Each index is pushed and popped at most once, so the total work is O(n).
 *
 * Time:  O(n)
 * Space: O(n)
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n]; // default 0 means no warmer day found
        Deque<Integer> stack = new ArrayDeque<>(); // indices of unresolved days

        for (int i = 0; i < n; i++) {
            // Current temperature resolves all cooler waiting days
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                result[prevDay] = i - prevDay;
            }
            stack.push(i);
        }

        return result;
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();

        System.out.println(Arrays.toString(
                solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})
        )); // [1, 1, 4, 2, 1, 1, 0, 0]

        System.out.println(Arrays.toString(
                solution.dailyTemperatures(new int[]{30, 40, 50, 60})
        )); // [1, 1, 1, 0]
    }
}
