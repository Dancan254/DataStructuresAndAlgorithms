# Binary Search — Exercises

---

## Easy

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 1 | Binary Search | [704](https://leetcode.com/problems/binary-search/) | No | Classic closed-interval template |
| 2 | Guess Number Higher or Lower | [374](https://leetcode.com/problems/guess-number-higher-or-lower/) | No | Classic template |

## Medium

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 3 | Find Minimum in Rotated Sorted Array | [153](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) | Yes | Compare mid to hi to find unsorted half |
| 4 | Search in Rotated Sorted Array | [33](https://leetcode.com/problems/search-in-rotated-sorted-array/) | Yes | Identify sorted half, check target range |
| 5 | Search a 2D Matrix | [74](https://leetcode.com/problems/search-a-2d-matrix/) | No | Treat matrix as flat sorted array |
| 6 | Koko Eating Bananas | [875](https://leetcode.com/problems/koko-eating-bananas/) | No | Binary search on answer space |
| 7 | Time Based Key-Value Store | [981](https://leetcode.com/problems/time-based-key-value-store/) | No | Binary search on stored timestamps |

## Hard

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 8 | Median of Two Sorted Arrays | [4](https://leetcode.com/problems/median-of-two-sorted-arrays/) | No | Binary search on partition position |

---

## Reflection Questions

1. Why is `lo + (hi - lo) / 2` safer than `(lo + hi) / 2`?
2. In the rotated array search, what breaks if you use `nums[lo] < nums[mid]`
   (strict inequality) instead of `<=`?
3. How do you identify that a problem is solvable with binary search on the answer
   space? What two properties must hold?
