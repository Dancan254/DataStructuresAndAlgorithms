# Backtracking

## Overview

Backtracking is a systematic method for exploring all candidates in a search space
by building solutions incrementally and abandoning ("pruning") a partial solution
the moment it is determined that it cannot lead to a valid complete solution.

Backtracking is essentially DFS on an implicit decision tree. Each node represents
a partial solution; each edge represents a choice; leaves represent complete
solutions or dead ends.

---

## The Universal Template

```java
void backtrack(/* state */, List<Integer> current, List<List<Integer>> result) {
    if (/* base case — solution is complete */) {
        result.add(new ArrayList<>(current)); // copy — do NOT add current directly
        return;
    }

    for (/* each candidate choice */) {
        if (/* choice is invalid — prune */) continue;

        current.add(choice);        // make choice
        backtrack(...);             // explore further
        current.remove(...);        // undo choice (backtrack)
    }
}
```

**Critical:** always add a copy of `current` to `result`, not `current` itself.
After backtracking, `current` is mutated and the reference you stored would reflect
the final empty state.

---

## Pattern 1: Subsets / Combinations

**Example — Subsets (LeetCode 78):**
Every index position has two choices: include or exclude.

```java
// O(n * 2^n) time, O(n) space (recursion depth)
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums, 0, new ArrayList<>(), result);
    return result;
}

private void backtrack(int[] nums, int start, List<Integer> current,
                        List<List<Integer>> result) {
    result.add(new ArrayList<>(current));  // every state is a valid subset

    for (int i = start; i < nums.length; i++) {
        current.add(nums[i]);
        backtrack(nums, i + 1, current, result); // i+1: no reuse of elements
        current.remove(current.size() - 1);
    }
}
```

**Example — Combination Sum (LeetCode 39):**
Elements can be reused, so the recursive call passes `i` not `i+1`.

```java
// O(n^(t/m)) time where t = target, m = min candidate
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(candidates, 0, target, new ArrayList<>(), result);
    return result;
}

private void backtrack(int[] candidates, int start, int remaining,
                        List<Integer> current, List<List<Integer>> result) {
    if (remaining == 0) {
        result.add(new ArrayList<>(current));
        return;
    }
    for (int i = start; i < candidates.length; i++) {
        if (candidates[i] > remaining) continue; // prune — candidate too large
        current.add(candidates[i]);
        backtrack(candidates, i, remaining - candidates[i], current, result); // i: allow reuse
        current.remove(current.size() - 1);
    }
}
```

---

## Pattern 2: Permutations

All orderings of a set. Each level picks one unused element.

```java
// O(n * n!) time
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums, new boolean[nums.length], new ArrayList<>(), result);
    return result;
}

private void backtrack(int[] nums, boolean[] used, List<Integer> current,
                        List<List<Integer>> result) {
    if (current.size() == nums.length) {
        result.add(new ArrayList<>(current));
        return;
    }
    for (int i = 0; i < nums.length; i++) {
        if (used[i]) continue;
        used[i] = true;
        current.add(nums[i]);
        backtrack(nums, used, current, result);
        current.remove(current.size() - 1);
        used[i] = false;
    }
}
```

---

## Pattern 3: Grid Search (Word Search)

Perform DFS on a 2D grid, marking cells as visited to prevent reuse within
the current path. Restore the cell on backtrack.

**Example — Word Search (LeetCode 79):**

```java
// O(m * n * 4^L) time where L = word length
public boolean exist(char[][] board, String word) {
    int m = board.length, n = board[0].length;
    for (int r = 0; r < m; r++)
        for (int c = 0; c < n; c++)
            if (dfs(board, word, r, c, 0)) return true;
    return false;
}

private boolean dfs(char[][] board, String word, int r, int c, int idx) {
    if (idx == word.length()) return true;
    if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return false;
    if (board[r][c] != word.charAt(idx)) return false;

    char tmp = board[r][c];
    board[r][c] = '#';           // mark as visited

    boolean found = dfs(board, word, r+1, c, idx+1)
                 || dfs(board, word, r-1, c, idx+1)
                 || dfs(board, word, r, c+1, idx+1)
                 || dfs(board, word, r, c-1, idx+1);

    board[r][c] = tmp;           // restore (backtrack)
    return found;
}
```

---

## Pattern 4: Pruning with Sorting

Sorting the input before backtracking enables two optimisations:
1. Skip duplicate elements to avoid duplicate results.
2. Break early when the current candidate exceeds the remaining target.

**Example — Combination Sum II (with duplicates, LeetCode 40):**
```java
Arrays.sort(candidates);
for (int i = start; i < candidates.length; i++) {
    if (i > start && candidates[i] == candidates[i-1]) continue; // skip duplicate at same level
    if (candidates[i] > remaining) break;                         // all further are larger — prune
    // ... recurse with i+1 (no reuse)
}
```

---

## Complexity Summary

| Problem Type | Time | Space (recursion stack) |
|---|---|---|
| Subsets (n elements) | O(n * 2^n) | O(n) |
| Permutations (n elements) | O(n * n!) | O(n) |
| Combination sum | O(n^(t/m)) | O(t/m) |
| Word search (m×n grid, L-length word) | O(m * n * 4^L) | O(L) |

---

## Common Mistakes

- Adding `current` directly to `result` — `current` is mutated later, so all
  recorded entries will reflect the final empty state.
- Not undoing the choice after the recursive call — the `used[i] = false` or
  `current.remove(...)` line is the backtracking step and must not be omitted.
- Not marking grid cells as visited before recursing in grid search problems.
- Skipping duplicates at the wrong condition: use `i > start` (not `i > 0`)
  to only skip duplicates at the same recursion level.
