# Arrays and Hashing

## Overview

Arrays and hash-based data structures are the foundation of most interview problems.
Arrays provide O(1) indexed access to contiguous memory. Hash maps and hash sets
trade memory for constant-time lookups, insertions, and deletions on average.

Mastering these two structures — and the patterns built on top of them — unlocks
solutions to a large proportion of LeetCode Easy and Medium problems.

---

## Core Data Structures

### Array

An array stores elements in contiguous memory locations accessible by index.

| Operation | Time Complexity |
|-----------|----------------|
| Access by index | O(1) |
| Search (unsorted) | O(n) |
| Search (sorted) | O(log n) with binary search |
| Insert at end (dynamic) | O(1) amortized |
| Insert at middle | O(n) |
| Delete at middle | O(n) |

**Key insight:** When order does not matter, consider sorting the array first.
Sorting costs O(n log n) but can reduce a subsequent operation from O(n²) to O(n).

### HashMap

A hash map (Java: `HashMap<K, V>`) stores key-value pairs. The hash function maps
keys to bucket indices, enabling average O(1) operations.

```java
Map<Integer, Integer> map = new HashMap<>();
map.put(key, value);         // O(1) average
map.get(key);                // O(1) average
map.containsKey(key);        // O(1) average
map.getOrDefault(key, 0);    // O(1) average — returns 0 if key absent
```

### HashSet

A hash set (Java: `HashSet<T>`) stores unique elements with O(1) average operations.
Use it when you only need to answer "have I seen this before?"

```java
Set<Integer> seen = new HashSet<>();
seen.add(x);         // returns false if x was already present
seen.contains(x);    // O(1) average
```

---

## Patterns

### Pattern 1: Frequency Counting

Count how many times each element appears. Use a `HashMap<element, count>`.

**Canonical form:**
```java
Map<Character, Integer> freq = new HashMap<>();
for (char c : s.toCharArray()) {
    freq.put(c, freq.getOrDefault(c, 0) + 1);
}
```

**When to use:** Anagram detection, top-K frequent elements, majority element,
finding duplicates, grouping by character signature.

**Example — Valid Anagram (LeetCode 242):**
Two strings are anagrams if and only if their character frequency maps are identical.

```java
// O(n) time, O(1) space (bounded alphabet)
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] count = new int[26];
    for (int i = 0; i < s.length(); i++) {
        count[s.charAt(i) - 'a']++;
        count[t.charAt(i) - 'a']--;
    }
    for (int c : count) {
        if (c != 0) return false;
    }
    return true;
}
```

---

### Pattern 2: Complement Lookup (Two Sum Pattern)

Instead of checking all pairs O(n²), store what you have seen so far and look up
the complement in O(1).

**Canonical form:**
```java
Map<Integer, Integer> seen = new HashMap<>();  // value -> index
for (int i = 0; i < nums.length; i++) {
    int complement = target - nums[i];
    if (seen.containsKey(complement)) {
        return new int[]{seen.get(complement), i};
    }
    seen.put(nums[i], i);
}
```

**When to use:** Any problem asking for a pair (or triplet) summing to a target.

---

### Pattern 3: Prefix Sums

A prefix sum array allows computing the sum of any subarray in O(1) after O(n)
preprocessing.

```
prefix[0] = 0
prefix[i] = prefix[i-1] + nums[i-1]

Sum of nums[l..r] = prefix[r+1] - prefix[l]
```

**When to use:** Subarray sum queries, counting subarrays with a given sum (often
combined with a hash map), product of array except self.

**Example — Product of Array Except Self (LeetCode 238):**
Without division, use a left prefix product and a right suffix product.

```java
// O(n) time, O(1) extra space (output array excluded)
public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];

    // Left pass: result[i] = product of all elements to the left of i
    result[0] = 1;
    for (int i = 1; i < n; i++) {
        result[i] = result[i - 1] * nums[i - 1];
    }

    // Right pass: multiply in the product of all elements to the right of i
    int rightProduct = 1;
    for (int i = n - 1; i >= 0; i--) {
        result[i] *= rightProduct;
        rightProduct *= nums[i];
    }
    return result;
}
```

---

### Pattern 4: Set-Based Lookups

Convert an array to a `HashSet` to answer membership queries in O(1).

**Example — Longest Consecutive Sequence (LeetCode 128):**
Without sorting. For each number that is the start of a sequence (no predecessor
exists in the set), count how long the sequence extends.

```java
// O(n) time, O(n) space
public int longestConsecutive(int[] nums) {
    Set<Integer> numSet = new HashSet<>();
    for (int n : nums) numSet.add(n);

    int longest = 0;
    for (int n : numSet) {
        // Only start counting from the beginning of a sequence
        if (!numSet.contains(n - 1)) {
            int length = 1;
            while (numSet.contains(n + length)) length++;
            longest = Math.max(longest, length);
        }
    }
    return longest;
}
```

---

### Pattern 5: Grouping by Signature

Group elements that share a computed key (their "signature"). Use a
`HashMap<String, List<...>>`.

**Example — Group Anagrams (LeetCode 49):**
The signature of a word is its sorted character sequence.

```java
// O(n * k log k) time where k = max string length
public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String key = new String(chars);
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
    }
    return new ArrayList<>(map.values());
}
```

**Alternative signature:** A frequency tuple `"1#0#2#..."` avoids sorting and
runs in O(n * k) time.

---

### Pattern 6: Matrix Traversal

For in-place matrix problems (rotate, spiral, zero-fill), identify the geometric
transformation and simulate it.

**Rotate Image 90 degrees clockwise (LeetCode 48):**
Step 1 — transpose (swap `matrix[i][j]` with `matrix[j][i]`)
Step 2 — reverse each row

```java
// O(n²) time, O(1) space
public void rotate(int[][] matrix) {
    int n = matrix.length;
    // Transpose
    for (int i = 0; i < n; i++)
        for (int j = i + 1; j < n; j++) {
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = tmp;
        }
    // Reverse rows
    for (int[] row : matrix) {
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int tmp = row[lo]; row[lo] = row[hi]; row[hi] = tmp;
            lo++; hi--;
        }
    }
}
```

---

## Complexity Summary

| Pattern | Time | Space |
|---------|------|-------|
| Frequency counting | O(n) | O(k) — k distinct elements |
| Complement lookup | O(n) | O(n) |
| Prefix sums | O(n) build, O(1) query | O(n) |
| Set membership | O(n) build, O(1) query | O(n) |
| Group by signature (sorted) | O(n k log k) | O(n) |
| Matrix in-place transforms | O(n²) | O(1) |

---

## Common Mistakes

- Using `==` to compare strings or Integer objects — use `.equals()`.
- Forgetting that `HashMap.get()` returns `null` for absent keys — use `getOrDefault`.
- Not handling empty input or single-element arrays.
- Assuming a hash map guarantees insertion order — use `LinkedHashMap` if order matters.
- Sorting when a hash-based O(n) solution exists.
