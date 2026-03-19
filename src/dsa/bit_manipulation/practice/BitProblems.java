package dsa.bit_manipulation.practice;

import java.util.Arrays;

/**
 * Core bit manipulation problems from the Blind 75.
 * Implement each method below, then run main() to verify your solutions.
 *
 * Problems:
 *   - LeetCode 268 — Missing Number
 *   - LeetCode 191 — Number of 1 Bits
 *   - LeetCode 338 — Counting Bits
 *   - LeetCode 190 — Reverse Bits
 *   - LeetCode 371 — Sum of Two Integers
 */
public class BitProblems {

    // -----------------------------------------------------------------------
    // LeetCode 268 — Missing Number
    // https://leetcode.com/problems/missing-number/
    //
    // Given an array containing n distinct numbers in range [0, n],
    // return the one number that is missing.
    //
    // Example: [3,0,1] → 2
    //
    // Hint: XOR every index 0..n with every value in the array.
    //       Each present number XOR's with its matching index → cancels to 0.
    //       Only the missing number has no matching value to cancel it.
    // -----------------------------------------------------------------------
    public int missingNumber(int[] nums) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -----------------------------------------------------------------------
    // LeetCode 191 — Number of 1 Bits
    // https://leetcode.com/problems/number-of-1-bits/
    //
    // Return the number of set bits (1s) in the binary representation of n.
    //
    // Example: n = 11 (binary 1011) → 3
    //
    // Hint: n & (n-1) clears the lowest set bit. Count how many times you
    //       can apply this before n reaches 0.
    // -----------------------------------------------------------------------
    public int hammingWeight(int n) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -----------------------------------------------------------------------
    // LeetCode 338 — Counting Bits
    // https://leetcode.com/problems/counting-bits/
    //
    // Return an array where ans[i] = number of 1s in binary representation of i,
    // for every i in [0, n].
    //
    // Example: n = 5 → [0,1,1,2,1,2]
    //
    // Hint: dp[i] = dp[i & (i-1)] + 1.
    //       i & (i-1) gives i with its lowest set bit cleared — a smaller number
    //       whose bit count you have already computed.
    // -----------------------------------------------------------------------
    public int[] countBits(int n) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -----------------------------------------------------------------------
    // LeetCode 190 — Reverse Bits
    // https://leetcode.com/problems/reverse-bits/
    //
    // Reverse the bits of a 32-bit unsigned integer.
    //
    // Example: 00000010100101000001111010011100 → 964176192
    //
    // Hint: Build the result bit by bit over 32 iterations.
    //       Each iteration: left-shift result by 1, OR in the last bit of n,
    //       then right-shift n by 1 (use >>> for unsigned shift).
    // -----------------------------------------------------------------------
    public int reverseBits(int n) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -----------------------------------------------------------------------
    // LeetCode 371 — Sum of Two Integers
    // https://leetcode.com/problems/sum-of-two-integers/
    //
    // Calculate the sum of two integers without using + or -.
    //
    // Example: a = 2, b = 3 → 5
    //
    // Hint: XOR gives the sum without carry. AND followed by left-shift gives
    //       the carry bits. Repeat until there is no carry (b == 0).
    // -----------------------------------------------------------------------
    public int getSum(int a, int b) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        BitProblems solution = new BitProblems();

        // Missing Number
        System.out.println(solution.missingNumber(new int[]{3, 0, 1}));       // 2
        System.out.println(solution.missingNumber(new int[]{0, 1}));           // 2
        System.out.println(solution.missingNumber(new int[]{9,6,4,2,3,5,7,0,1})); // 8

        // Number of 1 Bits
        System.out.println(solution.hammingWeight(11));  // 3  (1011)
        System.out.println(solution.hammingWeight(128)); // 1  (10000000)

        // Counting Bits
        System.out.println(Arrays.toString(solution.countBits(5)));  // [0,1,1,2,1,2]
        System.out.println(Arrays.toString(solution.countBits(2)));  // [0,1,1]

        // Reverse Bits
        System.out.println(solution.reverseBits(0b00000010100101000001111010011100)); // 964176192
        System.out.println(solution.reverseBits(0b11111111111111111111111111111101)); // 2147483647 ... (unsigned)

        // Sum of Two Integers
        System.out.println(solution.getSum(1, 2));  // 3
        System.out.println(solution.getSum(2, 3));  // 5
        System.out.println(solution.getSum(-1, 1)); // 0
    }
}
