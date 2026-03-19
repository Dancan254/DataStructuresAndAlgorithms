# Sliding Window — Exercises

---

## Easy

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 1 | Best Time to Buy and Sell Stock | [121](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | Yes | Single-pass min tracking |
| 2 | Maximum Average Subarray I | [643](https://leetcode.com/problems/maximum-average-subarray-i/) | No | Fixed-size window |

## Medium

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 3 | Longest Substring Without Repeating Characters | [3](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | Yes | Variable window, character count |
| 4 | Longest Repeating Character Replacement | [424](https://leetcode.com/problems/longest-repeating-character-replacement/) | Yes | Variable window, max-frequency invariant |
| 5 | Permutation in String | [567](https://leetcode.com/problems/permutation-in-string/) | No | Fixed window of size |t|, frequency match |
| 6 | Fruit Into Baskets | [904](https://leetcode.com/problems/fruit-into-baskets/) | No | At most 2 distinct values in window |

## Hard

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 7 | Minimum Window Substring | [76](https://leetcode.com/problems/minimum-window-substring/) | Yes | Minimum covering window |
| 8 | Sliding Window Maximum | [239](https://leetcode.com/problems/sliding-window-maximum/) | No | Fixed window + monotonic deque |

---

## Reflection Questions

1. How do you decide between a fixed-size and variable-size window?
2. In Minimum Window Substring, why is the `need[c]--` going negative not a problem?
3. Why does LongestRepeatingCharReplacement never need to decrement `maxFreq`?
