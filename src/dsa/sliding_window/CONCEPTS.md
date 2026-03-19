# Sliding Window

## Overview

A sliding window maintains a contiguous subarray or substring that satisfies some
constraint. As the window moves across the input, elements enter from the right and
leave from the left, allowing you to update an answer in O(1) per step rather than
recomputing from scratch — reducing O(n²) or O(n³) solutions to O(n).

---

## When to Use Sliding Window

- The problem asks for a subarray or substring (contiguous elements).
- You need the longest, shortest, or maximum/minimum over all valid windows.
- The constraint on the window (sum, count of distinct elements, character
  frequencies) can be maintained incrementally.

If the constraint becomes invalid when you shrink, the window is variable-size.
If the window always stays at a fixed length k, it is fixed-size.

---

## Pattern 1: Fixed-Size Window

The window always contains exactly k elements. Slide it one step at a time:
add the incoming element, subtract the outgoing element.

**Template:**
```java
int windowSum = 0;
for (int i = 0; i < k; i++) windowSum += nums[i];     // initialise first window
int maxSum = windowSum;

for (int i = k; i < nums.length; i++) {
    windowSum += nums[i] - nums[i - k];                // slide
    maxSum = Math.max(maxSum, windowSum);
}
```

---

## Pattern 2: Variable-Size Window (Expand / Contract)

Expand the right boundary every iteration. When the window violates the
constraint, contract the left boundary until it is valid again.

**Template:**
```java
int lo = 0;
// maintain window state (sum, counts, etc.)
int best = 0;

for (int hi = 0; hi < n; hi++) {
    // add nums[hi] to window state

    while (/* window invalid */) {
        // remove nums[lo] from window state
        lo++;
    }

    // window is valid — update answer
    best = Math.max(best, hi - lo + 1);
}
```

---

## Pattern 3: Variable Window with Character Frequency Map

Used when the constraint involves character counts (e.g., at most k distinct
characters, all characters of a target string covered).

**Example — Longest Substring Without Repeating Characters (LeetCode 3):**

```java
// O(n) time, O(1) space (bounded alphabet)
public int lengthOfLongestSubstring(String s) {
    int[] count = new int[128];  // ASCII frequency
    int lo = 0, maxLen = 0;

    for (int hi = 0; hi < s.length(); hi++) {
        count[s.charAt(hi)]++;

        // Contract until the duplicate is gone
        while (count[s.charAt(hi)] > 1) {
            count[s.charAt(lo)]--;
            lo++;
        }

        maxLen = Math.max(maxLen, hi - lo + 1);
    }
    return maxLen;
}
```

**Example — Longest Repeating Character Replacement (LeetCode 424):**
You may replace at most k characters. The window is valid when
`(window size) - (count of most frequent char) <= k`.

```java
// O(n) time, O(1) space
public int characterReplacement(String s, int k) {
    int[] count = new int[26];
    int lo = 0, maxFreq = 0, maxLen = 0;

    for (int hi = 0; hi < s.length(); hi++) {
        count[s.charAt(hi) - 'A']++;
        maxFreq = Math.max(maxFreq, count[s.charAt(hi) - 'A']);

        // Replacements needed = window size - most frequent char count
        while ((hi - lo + 1) - maxFreq > k) {
            count[s.charAt(lo) - 'A']--;
            lo++;
        }

        maxLen = Math.max(maxLen, hi - lo + 1);
    }
    return maxLen;
}
```

**Note:** `maxFreq` is never decremented even when the window shrinks because a
smaller `maxFreq` would never produce a longer valid window — we only care about
beating the current best length.

---

## Pattern 4: Minimum Window (Covering All Required Elements)

**Example — Minimum Window Substring (LeetCode 76):**
Find the shortest substring of `s` containing all characters of `t`.

```java
// O(n + m) time, O(1) space (bounded alphabet)
public String minWindow(String s, String t) {
    int[] need = new int[128];
    for (char c : t.toCharArray()) need[c]++;

    int lo = 0, formed = 0, required = t.length();
    int minLen = Integer.MAX_VALUE, minStart = 0;

    for (int hi = 0; hi < s.length(); hi++) {
        char c = s.charAt(hi);
        // A character contributes to "formed" only if it is still needed
        if (need[c] > 0) formed++;
        need[c]--;

        // Contract while all required characters are covered
        while (formed == required) {
            if (hi - lo + 1 < minLen) {
                minLen = hi - lo + 1;
                minStart = lo;
            }
            char left = s.charAt(lo);
            need[left]++;
            // Losing this character breaks the coverage
            if (need[left] > 0) formed--;
            lo++;
        }
    }

    return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
}
```

---

## Pattern 5: Single-Pass Maximum Profit

**Example — Best Time to Buy and Sell Stock (LeetCode 121):**
Track the minimum price seen so far and the maximum profit achievable at each day.

```java
// O(n) time, O(1) space
public int maxProfit(int[] prices) {
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;

    for (int price : prices) {
        if (price < minPrice) {
            minPrice = price;           // found a better buy day
        } else {
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
    }
    return maxProfit;
}
```

This is conceptually a window where the left boundary is the minimum-price day
and the right boundary advances through all future days.

---

## Complexity Summary

| Pattern | Time | Space |
|---------|------|-------|
| Fixed-size window | O(n) | O(1) |
| Variable-size window | O(n) | O(1) or O(k) |
| Minimum covering window | O(n + m) | O(1) |
| Single-pass min/max tracking | O(n) | O(1) |

---

## Common Mistakes

- Shrinking the window from the right instead of the left.
- Updating the answer inside the shrink loop rather than after it.
- Off-by-one in window length: `hi - lo + 1` not `hi - lo`.
- In character frequency problems, decrementing `maxFreq` when it is not necessary.
- Forgetting to handle the case where `t` contains duplicate characters
  (need[c]-- goes negative for excess characters — that is intentional).
