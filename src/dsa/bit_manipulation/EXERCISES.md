# Bit Manipulation — Exercises

---

## Easy

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 1 | Number of 1 Bits | [191](https://leetcode.com/problems/number-of-1-bits/) | Yes | n &= (n-1) clears lowest set bit |
| 2 | Counting Bits | [338](https://leetcode.com/problems/counting-bits/) | Yes | dp[i] = dp[i & (i-1)] + 1 |
| 3 | Reverse Bits | [190](https://leetcode.com/problems/reverse-bits/) | Yes | Extract last bit, shift into result |
| 4 | Missing Number | [268](https://leetcode.com/problems/missing-number/) | Yes | XOR indices with values — pairs cancel |
| 5 | Single Number | [136](https://leetcode.com/problems/single-number/) | No | XOR all elements — duplicates cancel |

## Medium

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 6 | Sum of Two Integers | [371](https://leetcode.com/problems/sum-of-two-integers/) | Yes | XOR for sum, AND<<1 for carry, repeat |
| 7 | Reverse Integer | [7](https://leetcode.com/problems/reverse-integer/) | No | Modulo + divide; overflow check with INT bounds |

---

## Bit Trick Reference

| Goal | Expression |
|------|-----------|
| Check bit i | `(n >> i) & 1` |
| Set bit i | `n \| (1 << i)` |
| Clear bit i | `n & ~(1 << i)` |
| Is power of 2 | `n > 0 && (n & (n-1)) == 0` |
| Clear lowest set bit | `n & (n-1)` |
| Isolate lowest set bit | `n & (-n)` |
| XOR swap (no temp) | `a ^= b; b ^= a; a ^= b;` |

---

## Reflection Questions

1. Why does `n & (n-1)` clear exactly the lowest set bit?
2. In Missing Number, trace through `[3,0,1]` step by step to see how XOR produces 2.
3. In Sum of Two Integers, why does the loop terminate? What guarantees the carry eventually reaches 0?
