# Bit Manipulation

## Overview

Bit manipulation operates directly on the binary representation of integers.
These techniques are often O(1) or O(log n) and appear in problems that seem
to require clever tricks — once you know the patterns they are straightforward.

---

## Bitwise Operators in Java

| Operator | Symbol | Example (4-bit) | Description |
|----------|--------|-----------------|-------------|
| AND | `&` | `1010 & 1100 = 1000` | 1 only when both bits are 1 |
| OR | `\|` | `1010 \| 1100 = 1110` | 1 when either bit is 1 |
| XOR | `^` | `1010 ^ 1100 = 0110` | 1 when bits differ |
| NOT | `~` | `~1010 = 0101` | Flip all bits |
| Left shift | `<<` | `0001 << 2 = 0100` | Multiply by 2^n |
| Right shift | `>>` | `1000 >> 2 = 0010` | Divide by 2^n (arithmetic) |
| Unsigned right shift | `>>>` | Fills with 0 regardless of sign | |

---

## Core Tricks

**Check if bit i is set:**
```java
(n >> i) & 1  // returns 1 if bit i is set, 0 otherwise
```

**Set bit i:**
```java
n | (1 << i)
```

**Clear bit i:**
```java
n & ~(1 << i)
```

**Check if n is a power of 2:**
```java
n > 0 && (n & (n - 1)) == 0
// n & (n-1) clears the lowest set bit — result is 0 only for powers of 2
```

**Isolate the lowest set bit:**
```java
n & (-n)  // -n is the two's complement
```

**Count set bits (Kernighan's algorithm):**
```java
int count = 0;
while (n != 0) {
    n &= (n - 1); // clear the lowest set bit
    count++;
}
```

---

## Pattern 1: XOR Properties

XOR is the most useful operation for these problems.

Key properties:
- `a ^ a = 0` (any number XOR itself is 0)
- `a ^ 0 = a` (any number XOR 0 is itself)
- XOR is commutative and associative

**Example — Missing Number (LeetCode 268):**
XOR all indices 0..n with all values in the array. Every number that appears
cancels out. The one that doesn't cancel is the missing number.

```java
// O(n) time, O(1) space
public int missingNumber(int[] nums) {
    int result = nums.length; // start with n
    for (int i = 0; i < nums.length; i++) {
        result ^= i ^ nums[i]; // XOR with index and value
    }
    return result;
}
```

**Example — Single Number (LeetCode 136):**
Every element appears twice except one. XOR all elements — pairs cancel.

```java
public int singleNumber(int[] nums) {
    int result = 0;
    for (int n : nums) result ^= n;
    return result;
}
```

---

## Pattern 2: Counting Bits

**Number of 1 Bits (LeetCode 191):**
Use Kernighan's algorithm: `n &= (n-1)` clears the lowest set bit.

```java
// O(number of set bits) time
public int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
        n &= (n - 1);
        count++;
    }
    return count;
}
```

**Counting Bits (LeetCode 338):**
For each i, `i & (i-1)` clears the last set bit, giving us a smaller number
whose bit count we already know.

```java
// O(n) time, O(n) space
public int[] countBits(int n) {
    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        dp[i] = dp[i & (i - 1)] + 1; // dp[i with last bit cleared] + 1
    }
    return dp;
}
```

---

## Pattern 3: Reverse Bits

**Example — Reverse Bits (LeetCode 190):**
Build the reversed number bit by bit: extract the last bit of n, shift it
into the result.

```java
// O(32) = O(1) time
public int reverseBits(int n) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
        result = (result << 1) | (n & 1); // append last bit of n to result
        n >>= 1;                           // move to next bit of n
    }
    return result;
}
```

---

## Pattern 4: Sum Without Arithmetic Operators

**Example — Sum of Two Integers (LeetCode 371):**
Use XOR for the sum without carry, AND followed by left-shift for the carry.
Repeat until no carry remains.

```java
// O(1) time — at most 32 iterations
public int getSum(int a, int b) {
    while (b != 0) {
        int carry = (a & b) << 1;  // carry bits
        a = a ^ b;                  // sum without carry
        b = carry;
    }
    return a;
}
```

---

## Complexity Summary

| Operation | Time |
|-----------|------|
| Check/set/clear a bit | O(1) |
| Count set bits (Kernighan) | O(k) — k = number of set bits |
| Reverse bits (32-bit int) | O(32) = O(1) |
| Counting bits for 0..n | O(n) using DP |
| Sum without operators | O(32) = O(1) |

---

## Common Mistakes

- Using `>>` (arithmetic right shift) instead of `>>>` (logical right shift) when
  handling negative numbers in `reverseBits`.
- Forgetting that Java integers are 32-bit signed — `1 << 31` is `Integer.MIN_VALUE`.
- Using `==` to compare with 0 after an `&` operation — use `(n & mask) != 0`
  not `(n & mask) == 1`, since the result could be any non-zero value.
- In `getSum`, the loop condition should be `b != 0`, not `carry != 0`.
