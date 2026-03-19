# Two Pointers

## Overview

The two pointer technique uses two index variables that move through a data
structure — typically an array or string — to reduce an O(n²) brute-force search
to O(n). The two pointers either start at opposite ends and converge, or start at
the same end and move at different speeds.

---

## When to Use Two Pointers

- The input is a sorted array (or can be sorted) and you need pairs/triplets.
- You need to find a subarray or substring satisfying a condition.
- You need to partition or rearrange elements in-place.
- The problem involves detecting a cycle in a linked structure (fast/slow).

---

## Pattern 1: Opposite-End Pointers

Place one pointer at index 0 and one at index n-1. Move them toward each other
based on a comparison. Stop when they meet or cross.

**Template:**
```java
int lo = 0, hi = array.length - 1;
while (lo < hi) {
    if (/* condition satisfied */) {
        // record result
        lo++;
        hi--;
    } else if (/* need larger sum */) {
        lo++;
    } else {
        hi--;
    }
}
```

**Example — Valid Palindrome (LeetCode 125):**
A string is a palindrome if it reads the same after removing non-alphanumeric
characters and ignoring case.

```java
// O(n) time, O(1) space
public boolean isPalindrome(String s) {
    int lo = 0, hi = s.length() - 1;
    while (lo < hi) {
        while (lo < hi && !Character.isLetterOrDigit(s.charAt(lo))) lo++;
        while (lo < hi && !Character.isLetterOrDigit(s.charAt(hi))) hi--;
        if (Character.toLowerCase(s.charAt(lo)) != Character.toLowerCase(s.charAt(hi))) {
            return false;
        }
        lo++;
        hi--;
    }
    return true;
}
```

**Example — Container With Most Water (LeetCode 11):**
The area between indices i and j is `min(height[i], height[j]) * (j - i)`.
Always move the pointer pointing to the shorter line — moving the taller one
can only decrease or maintain the height constraint, never improve it.

```java
// O(n) time, O(1) space
public int maxArea(int[] height) {
    int lo = 0, hi = height.length - 1;
    int maxWater = 0;
    while (lo < hi) {
        int water = Math.min(height[lo], height[hi]) * (hi - lo);
        maxWater = Math.max(maxWater, water);
        if (height[lo] < height[hi]) lo++;
        else hi--;
    }
    return maxWater;
}
```

---

## Pattern 2: Three Pointers (Extension of Opposite-End)

Fix one element with an outer loop, then use two pointers on the remaining
sub-array. This reduces O(n³) brute-force to O(n²).

**Example — 3Sum (LeetCode 15):**
Sort the array. For each element at index i, run two pointers on i+1..n-1.
Skip duplicates carefully to avoid duplicate triplets in the output.

```java
// O(n²) time, O(1) extra space (sorting in-place)
public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < nums.length - 2; i++) {
        // Skip duplicate values for the fixed element
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        // Early exit: smallest possible sum already positive
        if (nums[i] > 0) break;

        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum == 0) {
                result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                // Skip duplicates for both inner pointers
                while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                lo++;
                hi--;
            } else if (sum < 0) {
                lo++;
            } else {
                hi--;
            }
        }
    }
    return result;
}
```

---

## Pattern 3: Same-Direction Pointers (Fast / Slow)

Both pointers start at the same end. The fast pointer advances every iteration;
the slow pointer advances only when a condition is met. This partitions the array
in-place without extra space.

**Example — Move Zeroes:**
Slow pointer marks the position of the next non-zero placement.

```java
// O(n) time, O(1) space
public void moveZeroes(int[] nums) {
    int slow = 0;
    for (int fast = 0; fast < nums.length; fast++) {
        if (nums[fast] != 0) {
            nums[slow++] = nums[fast];
        }
    }
    while (slow < nums.length) nums[slow++] = 0;
}
```

**Cycle Detection (Floyd's Algorithm):**
Used for linked lists and the "find duplicate number" problem.
Slow moves one step, fast moves two. If a cycle exists, they will meet.

```java
int slow = nums[0], fast = nums[0];
do {
    slow = nums[slow];
    fast = nums[nums[fast]];
} while (slow != fast);

// Find entry point of cycle
slow = nums[0];
while (slow != fast) {
    slow = nums[slow];
    fast = nums[fast];
}
return slow; // duplicate number
```

---

## Complexity Summary

| Pattern | Time | Space |
|---------|------|-------|
| Opposite-end (pair sum) | O(n) | O(1) |
| Three-pointer (triplet sum) | O(n²) | O(1) |
| Same-direction (partition) | O(n) | O(1) |
| Fast/slow (cycle detection) | O(n) | O(1) |

---

## Common Mistakes

- Running two pointers on an unsorted array when the algorithm requires order.
- Not skipping duplicates in problems like 3Sum, causing repeated triplets.
- Moving the wrong pointer — always reason about what invariant each move maintains.
- Using `lo <= hi` instead of `lo < hi` when the pair must be two distinct elements.
