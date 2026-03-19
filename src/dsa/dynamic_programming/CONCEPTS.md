# Dynamic Programming

## Overview

Dynamic programming (DP) solves problems by breaking them into overlapping
subproblems, solving each subproblem once, and storing the result to avoid
redundant computation. It applies when a problem has two properties:

1. **Optimal substructure:** the optimal solution to the problem contains
   optimal solutions to its subproblems.
2. **Overlapping subproblems:** the same subproblems are solved multiple times
   in a naive recursive approach.

---

## Two Implementations

**Top-down (memoisation):** Write the natural recursion, then cache results.

```java
int[] memo = new int[n + 1];
Arrays.fill(memo, -1);

int dp(int i) {
    if (i == base_case) return base_value;
    if (memo[i] != -1) return memo[i];
    return memo[i] = dp(i - 1) + dp(i - 2); // example recurrence
}
```

**Bottom-up (tabulation):** Fill a table iteratively from the smallest subproblem.

```java
int[] dp = new int[n + 1];
dp[0] = base_value_0;
dp[1] = base_value_1;
for (int i = 2; i <= n; i++) {
    dp[i] = dp[i - 1] + dp[i - 2]; // example recurrence
}
return dp[n];
```

Most bottom-up solutions can be further space-optimised by keeping only the
last few values instead of the full array.

---

## Pattern 1: Linear DP (1D)

**Example — Climbing Stairs (LeetCode 70):**
To reach step n, you came from step n-1 or n-2. `dp[n] = dp[n-1] + dp[n-2]`.

```java
// O(n) time, O(1) space
public int climbStairs(int n) {
    if (n <= 2) return n;
    int prev2 = 1, prev1 = 2;
    for (int i = 3; i <= n; i++) {
        int curr = prev1 + prev2;
        prev2 = prev1;
        prev1 = curr;
    }
    return prev1;
}
```

**Example — House Robber (LeetCode 198):**
At each house, either rob it (can't rob the previous) or skip it.
`dp[i] = max(dp[i-1], dp[i-2] + nums[i])`

```java
// O(n) time, O(1) space
public int rob(int[] nums) {
    int prev2 = 0, prev1 = 0;
    for (int num : nums) {
        int curr = Math.max(prev1, prev2 + num);
        prev2 = prev1;
        prev1 = curr;
    }
    return prev1;
}
```

**Example — House Robber II (LeetCode 213):**
Houses are arranged in a circle — first and last cannot both be robbed.
Run House Robber on `nums[0..n-2]` and `nums[1..n-1]`, return the maximum.

---

## Pattern 2: Unbounded Knapsack

Each item can be used unlimited times.

**Example — Coin Change (LeetCode 322):**
Find the minimum number of coins to make amount. `dp[i]` = min coins to make i.

```java
// O(amount * coins) time, O(amount) space
public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1); // sentinel: larger than any valid answer
    dp[0] = 0;

    for (int i = 1; i <= amount; i++) {
        for (int coin : coins) {
            if (coin <= i) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
    }
    return dp[amount] > amount ? -1 : dp[amount];
}
```

---

## Pattern 3: Subsequence DP

**Example — Longest Increasing Subsequence (LeetCode 300):**
`dp[i]` = length of LIS ending at index i.

```java
// O(n²) time, O(n) space
public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 1); // every element is an LIS of length 1

    int max = 1;
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        max = Math.max(max, dp[i]);
    }
    return max;
}
```

**Example — Word Break (LeetCode 139):**
`dp[i]` = true if `s[0..i-1]` can be segmented using words in the dictionary.

```java
// O(n² * m) time, O(n) space — m = average word length
public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> words = new HashSet<>(wordDict);
    int n = s.length();
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;

    for (int i = 1; i <= n; i++) {
        for (int j = 0; j < i; j++) {
            if (dp[j] && words.contains(s.substring(j, i))) {
                dp[i] = true;
                break;
            }
        }
    }
    return dp[n];
}
```

---

## Pattern 4: 2D DP (Grid / String Alignment)

**Example — Unique Paths (LeetCode 62):**
`dp[r][c]` = number of paths to reach (r, c).
`dp[r][c] = dp[r-1][c] + dp[r][c-1]`

```java
// O(m * n) time, O(n) space (rolling row)
public int uniquePaths(int m, int n) {
    int[] dp = new int[n];
    Arrays.fill(dp, 1); // top row: only one way (go right)

    for (int r = 1; r < m; r++) {
        for (int c = 1; c < n; c++) {
            dp[c] += dp[c - 1]; // dp[c] = from above, dp[c-1] = from left
        }
    }
    return dp[n - 1];
}
```

---

## Pattern 5: String DP

**Example — Longest Palindromic Substring (LeetCode 5):**
Expand around each centre (character or gap between characters).

```java
// O(n²) time, O(1) space
public String longestPalindrome(String s) {
    int start = 0, maxLen = 1;

    for (int i = 0; i < s.length(); i++) {
        // Odd length
        int len1 = expand(s, i, i);
        // Even length
        int len2 = expand(s, i, i + 1);
        int len = Math.max(len1, len2);

        if (len > maxLen) {
            maxLen = len;
            start = i - (len - 1) / 2;
        }
    }
    return s.substring(start, start + maxLen);
}

private int expand(String s, int lo, int hi) {
    while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
        lo--; hi++;
    }
    return hi - lo - 1; // length of the palindrome
}
```

---

## Complexity Summary

| Pattern | Time | Space |
|---------|------|-------|
| 1D linear DP | O(n) | O(1) optimised |
| Unbounded knapsack | O(n * amount) | O(amount) |
| Subsequence DP | O(n²) | O(n) |
| 2D grid DP | O(m * n) | O(n) rolling row |

---

## Common Mistakes

- Not initialising the base cases correctly — off-by-one errors here cascade.
- Filling the `dp` array with 0 when the sentinel should be infinity
  (e.g., Coin Change where 0 is a valid answer).
- In 2D DP, trying to access `dp[r-1][c]` or `dp[r][c-1]` when r=0 or c=0
  without boundary checks or separate initialisation.
- Using the recurrence in the wrong direction (building on future states
  instead of past states).
- Forgetting that `dp[i]` may represent "ending at i" vs "using first i elements"
  — define clearly before writing the recurrence.
