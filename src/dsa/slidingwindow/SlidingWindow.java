package dsa.slidingwindow;

import java.util.HashMap;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] arr = {4, 7, 8, 9, 0, 5};
        int k = 3;
        int result = fixedWindowPattern(arr, k);
        System.out.println("\n✅ Maximum sum of any subarray of size " + k + " is: " + result);
    }

    static int fixedWindowPattern(int[] arr, int k) {
        int windowSum = 0;
        int result = 0;
        int n = arr.length;

        // Build the initial window (first k elements)
        System.out.println("🔷 Building initial window (indices 0 to " + (k - 1) + "):");
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
            System.out.print(arr[i] + " ");
        }
        System.out.println("→ Sum = " + windowSum);
        result = windowSum;

        // Slide the window: from index k to end
        System.out.println("\n🔷 Sliding the window:");
        for (int i = k; i < n; i++) {
            int elementToRemove = arr[i - k];  // leftmost element of previous window
            int elementToAdd = arr[i];         // new rightmost element

            windowSum = windowSum - elementToRemove + elementToAdd;

            System.out.printf("Removed %d, Added %d → Current window sum = %d\n",
                    elementToRemove, elementToAdd, windowSum);

            if (windowSum > result) {
                result = windowSum;
            }
        }

        return result;
    }

    public int fib(int n) {
        return fibHelper(n, new HashMap<>());
    }

    private int fibHelper(int n, HashMap<Integer, Integer> memo) {
        // O(n) time, O(n) space
        if (n <= 1) return n;

        if (memo.containsKey(n)) {
            return memo.get(n); // Already calculated!
        }

        int result = fibHelper(n - 1, memo) + fibHelper(n - 2, memo);
        memo.put(n, result);
        return result;
    }

// Each fib(k) calculated ONCE
// fib(40) = only 41 calls!
}