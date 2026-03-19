package dsa.bit_manipulation;

import java.util.Arrays;

/**
 * Core bit manipulation problems from the Blind 75.
 *
 * LeetCode 268 — Missing Number
 * LeetCode 191 — Number of 1 Bits
 * LeetCode 338 — Counting Bits
 * LeetCode 190 — Reverse Bits
 * LeetCode 371 — Sum of Two Integers
 */
public class BitProblems {

    // -----------------------------------------------------------------------
    // LeetCode 268 — Missing Number
    //
    // Pattern: XOR cancellation
    // XOR all indices 0..n and all values. Each present number cancels its index.
    // The missing number has no matching value to cancel it.
    //
    // Time O(n), Space O(1)
    // -----------------------------------------------------------------------
    public int missingNumber(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result ^= i ^ nums[i];
        }
        return result;
    }

    // -----------------------------------------------------------------------
    // LeetCode 191 — Number of 1 Bits
    //
    // Pattern: Kernighan — n &= (n-1) clears the lowest set bit
    //
    // Time O(k) where k = number of set bits, Space O(1)
    // -----------------------------------------------------------------------
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1); // clear lowest set bit
            count++;
        }
        return count;
    }

    // -----------------------------------------------------------------------
    // LeetCode 338 — Counting Bits
    //
    // Pattern: DP using i & (i-1) to reuse previously computed count
    // dp[i] = dp[i with lowest bit cleared] + 1
    //
    // Time O(n), Space O(n)
    // -----------------------------------------------------------------------
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i & (i - 1)] + 1;
        }
        return dp;
    }

    // -----------------------------------------------------------------------
    // LeetCode 190 — Reverse Bits
    //
    // Pattern: Extract last bit, shift into result, advance both
    //
    // Time O(32) = O(1), Space O(1)
    // -----------------------------------------------------------------------
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1);
            n >>>= 1; // unsigned right shift to handle negative numbers correctly
        }
        return result;
    }

    // -----------------------------------------------------------------------
    // LeetCode 371 — Sum of Two Integers (without + or -)
    //
    // Pattern: XOR for partial sum, AND<<1 for carry; repeat until no carry
    //
    // Time O(32) = O(1), Space O(1)
    // -----------------------------------------------------------------------
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        BitProblems solution = new BitProblems();

        System.out.println(solution.missingNumber(new int[]{3, 0, 1}));       // 2
        System.out.println(solution.hammingWeight(0b00000000000000000000000000001011)); // 3
        System.out.println(Arrays.toString(solution.countBits(5)));            // [0,1,1,2,1,2]
        System.out.println(solution.reverseBits(0b00000010100101000001111010011100));   // 964176192
        System.out.println(solution.getSum(2, 3));                             // 5
    }
}
