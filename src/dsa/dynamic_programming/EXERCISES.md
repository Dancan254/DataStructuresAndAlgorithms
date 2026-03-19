# Dynamic Programming — Exercises

Work through these in order. Earlier problems establish patterns used by later ones.

---

## Easy

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 1 | Climbing Stairs | [70](https://leetcode.com/problems/climbing-stairs/) | Yes | dp[n] = dp[n-1] + dp[n-2]; Fibonacci recurrence |
| 2 | Min Cost Climbing Stairs | [746](https://leetcode.com/problems/min-cost-climbing-stairs/) | No | Same recurrence + cost at each step |

## Medium

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 3 | House Robber | [198](https://leetcode.com/problems/house-robber/) | Yes | max(skip, rob + prev-prev) |
| 4 | House Robber II | [213](https://leetcode.com/problems/house-robber-ii/) | Yes | Run House Robber on two ranges; take max |
| 5 | Longest Palindromic Substring | [5](https://leetcode.com/problems/longest-palindromic-substring/) | Yes | Expand around each center |
| 6 | Palindromic Substrings | [647](https://leetcode.com/problems/palindromic-substrings/) | Yes | Count every expansion that succeeds |
| 7 | Decode Ways | [91](https://leetcode.com/problems/decode-ways/) | Yes | dp[i] += dp[i-1] if valid 1-digit; dp[i] += dp[i-2] if valid 2-digit |
| 8 | Coin Change | [322](https://leetcode.com/problems/coin-change/) | Yes | Unbounded knapsack; dp[i] = min over coins |
| 9 | Maximum Product Subarray | [152](https://leetcode.com/problems/maximum-product-subarray/) | Yes | Track both max and min (negatives flip sign) |
| 10 | Word Break | [139](https://leetcode.com/problems/word-break/) | Yes | dp[i] = true if any split dp[j] && word[j..i] |
| 11 | Longest Increasing Subsequence | [300](https://leetcode.com/problems/longest-increasing-subsequence/) | Yes | dp[i] = max dp[j]+1 where j<i and nums[j]<nums[i] |
| 12 | Unique Paths | [62](https://leetcode.com/problems/unique-paths/) | Yes | dp[r][c] = dp[r-1][c] + dp[r][c-1] |
| 13 | Jump Game | [55](https://leetcode.com/problems/jump-game/) | Yes | Track max reachable index |
| 14 | Partition Equal Subset Sum | [416](https://leetcode.com/problems/partition-equal-subset-sum/) | No | 0/1 knapsack: can we reach sum/2? |

---

## Reflection Questions

1. What is the difference between memoisation and tabulation? When would you prefer each?
2. In Coin Change, why is initialising `dp` with `amount + 1` (not `Integer.MAX_VALUE`) safer?
3. In Maximum Product Subarray, why must you track both the current maximum AND minimum?
4. House Robber II splits the problem into two linear sub-problems. Why is taking the max
   of both guaranteed to give the correct answer?
5. What property must a problem have for DP to apply? Name both required properties.
