# Arrays and Hashing — Exercises

Attempt each problem before looking at any solution. Identify which pattern from
`CONCEPTS.md` applies before writing any code.

---

## Easy

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 1 | Contains Duplicate | [242](https://leetcode.com/problems/contains-duplicate/) | Yes | HashSet membership |
| 2 | Valid Anagram | [242](https://leetcode.com/problems/valid-anagram/) | Yes | Frequency counting |
| 3 | Two Sum | [1](https://leetcode.com/problems/two-sum/) | Yes | Complement lookup |

## Medium

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 4 | Group Anagrams | [49](https://leetcode.com/problems/group-anagrams/) | Yes | Group by signature |
| 5 | Top K Frequent Elements | [347](https://leetcode.com/problems/top-k-frequent-elements/) | Yes | Frequency count + bucket sort |
| 6 | Product of Array Except Self | [238](https://leetcode.com/problems/product-of-array-except-self/) | Yes | Prefix/suffix products |
| 7 | Longest Consecutive Sequence | [128](https://leetcode.com/problems/longest-consecutive-sequence/) | Yes | Set-based lookup |
| 8 | Encode and Decode Strings | [271](https://leetcode.com/problems/encode-and-decode-strings/) | Yes | Length-prefixed encoding |
| 9 | Valid Sudoku | [36](https://leetcode.com/problems/valid-sudoku/) | No | HashSet per row/col/box |
| 10 | Rotate Image | [48](https://leetcode.com/problems/rotate-image/) | Yes | Transpose + reverse rows |
| 11 | Spiral Matrix | [54](https://leetcode.com/problems/spiral-matrix/) | Yes | Boundary simulation |
| 12 | Set Matrix Zeroes | [73](https://leetcode.com/problems/set-matrix-zeroes/) | Yes | In-place state tracking |

---

## Reflection Questions

After solving each problem, answer these before moving on:

1. What is the time and space complexity of your solution?
2. Is there a more space-efficient approach?
3. Would sorting the input first enable a simpler solution? At what cost?
4. Does a prefix sum or suffix product apply here?
