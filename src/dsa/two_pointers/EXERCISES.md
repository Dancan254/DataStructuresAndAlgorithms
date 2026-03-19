# Two Pointers — Exercises

---

## Easy

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 1 | Valid Palindrome | [125](https://leetcode.com/problems/valid-palindrome/) | Yes | Opposite-end, skip non-alphanumeric |
| 2 | Squares of a Sorted Array | [977](https://leetcode.com/problems/squares-of-a-sorted-array/) | No | Opposite-end, fill result from back |

## Medium

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 3 | Two Sum II — Input Array Is Sorted | [167](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | No | Opposite-end, sorted guarantee |
| 4 | 3Sum | [15](https://leetcode.com/problems/3sum/) | Yes | Fix i, opposite-end on suffix, skip duplicates |
| 5 | Container With Most Water | [11](https://leetcode.com/problems/container-with-most-water/) | Yes | Move shorter line inward |
| 6 | Trapping Rain Water | [42](https://leetcode.com/problems/trapping-rain-water/) | No | Track max-left and max-right at each pointer |

---

## Reflection Questions

1. Why must the array be sorted for the opposite-end pattern to be correct?
2. In 3Sum, what exactly causes duplicate triplets, and at which three positions must you skip?
3. In Container With Most Water, prove why moving the taller line is always suboptimal.
