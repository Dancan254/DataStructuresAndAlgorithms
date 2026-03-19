# Backtracking — Exercises

---

## Medium

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 1 | Subsets | [78](https://leetcode.com/problems/subsets/) | No | Include/exclude at each index; every state is valid |
| 2 | Combination Sum | [39](https://leetcode.com/problems/combination-sum/) | Yes | Reuse allowed (pass i not i+1); prune if candidate > remaining |
| 3 | Combination Sum II | [40](https://leetcode.com/problems/combination-sum-ii/) | No | Sort + skip duplicates at same level (i > start) |
| 4 | Permutations | [46](https://leetcode.com/problems/permutations/) | No | `used[]` array; add when current.size() == n |
| 5 | Subsets II | [90](https://leetcode.com/problems/subsets-ii/) | No | Sort + skip duplicates at same level |
| 6 | Word Search | [79](https://leetcode.com/problems/word-search/) | Yes | DFS grid; mark cell '#', restore on backtrack |
| 7 | Palindrome Partitioning | [131](https://leetcode.com/problems/palindrome-partitioning/) | No | Backtrack substrings; check palindrome before recursing |
| 8 | Letter Combinations of a Phone Number | [17](https://leetcode.com/problems/letter-combinations-of-a-phone-number/) | No | Digit → letter mapping; recurse on next digit |

## Hard

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 9 | N-Queens | [51](https://leetcode.com/problems/n-queens/) | No | Track column, diagonal, anti-diagonal sets |
| 10 | Word Search II | [212](https://leetcode.com/problems/word-search-ii/) | Yes | Trie built from words + DFS grid backtracking |

---

## Reflection Questions

1. What is the difference between passing `i` vs `i+1` in the recursive call, and when does each apply?
2. Why must you add `new ArrayList<>(current)` and not `current` to the result list?
3. In problems with duplicates (Subsets II, Combination Sum II), the duplicate-skip condition is
   `i > start`. Why does `i > 0` produce wrong results?
4. Why is the time complexity of Word Search O(m * n * 4^L) — specifically, where does the 4^L come from?
