# Binary Search

## Overview

Binary search finds a target in a sorted search space by repeatedly halving the
range of candidates. Each comparison eliminates half the remaining elements,
giving O(log n) time. The key challenge is writing a correct loop without
off-by-one errors and recognising when binary search applies to problems that
are not obviously about searching a sorted array.

---

## The Core Template

There are two common framings. Choose one and use it consistently.

### Framing A — Closed interval [lo, hi]

```java
int lo = 0, hi = nums.length - 1;
while (lo <= hi) {
    int mid = lo + (hi - lo) / 2;  // avoids integer overflow vs (lo+hi)/2
    if (nums[mid] == target) {
        return mid;
    } else if (nums[mid] < target) {
        lo = mid + 1;
    } else {
        hi = mid - 1;
    }
}
return -1; // not found
```

- Loop condition: `lo <= hi` (terminates when lo > hi).
- Both boundaries move past mid: `lo = mid + 1`, `hi = mid - 1`.

### Framing B — Left-closed, right-open [lo, hi)

```java
int lo = 0, hi = nums.length;  // hi is one past the last valid index
while (lo < hi) {
    int mid = lo + (hi - lo) / 2;
    if (nums[mid] < target) {
        lo = mid + 1;
    } else {
        hi = mid;         // mid may still be the answer
    }
}
return lo; // leftmost position where target could be inserted
```

This form is useful for finding the **leftmost** position satisfying a condition
(lower bound).

---

## Pattern 1: Classic Search in Sorted Array

Directly apply the template. Works on any sorted array.

**LeetCode 704 — Binary Search:**
```java
public int search(int[] nums, int target) {
    int lo = 0, hi = nums.length - 1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if      (nums[mid] == target) return mid;
        else if (nums[mid] < target)  lo = mid + 1;
        else                          hi = mid - 1;
    }
    return -1;
}
```

---

## Pattern 2: Search in a Rotated Sorted Array

A rotated sorted array like `[4,5,6,7,0,1,2]` has one sorted half at all times.
Determine which half is sorted using `nums[lo]` vs `nums[mid]`, then decide which
half the target can reside in.

**Example — Search in Rotated Sorted Array (LeetCode 33):**

```java
// O(log n) time, O(1) space
public int search(int[] nums, int target) {
    int lo = 0, hi = nums.length - 1;

    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] == target) return mid;

        // Left half is sorted
        if (nums[lo] <= nums[mid]) {
            if (target >= nums[lo] && target < nums[mid]) hi = mid - 1;
            else                                          lo = mid + 1;
        }
        // Right half is sorted
        else {
            if (target > nums[mid] && target <= nums[hi]) lo = mid + 1;
            else                                          hi = mid - 1;
        }
    }
    return -1;
}
```

**Example — Find Minimum in Rotated Sorted Array (LeetCode 153):**
The minimum is always in the unsorted half. The minimum is where the array
transitions from large to small values.

```java
// O(log n) time, O(1) space
public int findMin(int[] nums) {
    int lo = 0, hi = nums.length - 1;

    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        // mid is in the right (rotated) portion — minimum is to the left of mid
        if (nums[mid] > nums[hi]) lo = mid + 1;
        // mid is in the left (sorted) portion — minimum is at mid or to its left
        else                      hi = mid;
    }
    return nums[lo];
}
```

---

## Pattern 3: Binary Search on the Answer Space

Apply binary search to the answer itself when:
- The answer is a value in a range [min, max].
- You can verify in O(n) whether a candidate answer is feasible.
- Feasibility is monotone: if answer x is feasible, every answer > x is also
  feasible (or vice versa).

**Template:**
```java
int lo = minPossibleAnswer, hi = maxPossibleAnswer;
while (lo < hi) {
    int mid = lo + (hi - lo) / 2;
    if (isFeasible(mid)) hi = mid;   // try smaller
    else                 lo = mid + 1;
}
return lo;
```

**Example — Koko Eating Bananas (LeetCode 875):**
Find the minimum eating speed k such that all piles can be finished in h hours.
Speed k is feasible if `sum(ceil(pile / k)) <= h`.

```java
public int minEatingSpeed(int[] piles, int h) {
    int lo = 1, hi = Arrays.stream(piles).max().getAsInt();

    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if (canFinish(piles, mid, h)) hi = mid;
        else                          lo = mid + 1;
    }
    return lo;
}

private boolean canFinish(int[] piles, int speed, int h) {
    int hours = 0;
    for (int pile : piles) hours += (pile + speed - 1) / speed; // ceil division
    return hours <= h;
}
```

---

## Pattern 4: Search in a 2D Matrix

Treat an m×n matrix as a flattened sorted array of m*n elements.

```java
// O(log(m*n)) time, O(1) space
public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length, n = matrix[0].length;
    int lo = 0, hi = m * n - 1;

    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        int val = matrix[mid / n][mid % n];   // convert 1D index to 2D
        if      (val == target) return true;
        else if (val < target)  lo = mid + 1;
        else                    hi = mid - 1;
    }
    return false;
}
```

---

## Complexity Summary

| Pattern | Time | Space |
|---------|------|-------|
| Classic sorted array | O(log n) | O(1) |
| Rotated sorted array | O(log n) | O(1) |
| Search on answer space | O(n log(range)) | O(1) |
| 2D matrix | O(log(m*n)) | O(1) |

---

## Common Mistakes

- Using `(lo + hi) / 2` — can overflow for large indices. Use `lo + (hi - lo) / 2`.
- Incorrect loop condition: `lo <= hi` vs `lo < hi` — choose based on whether
  you need to check the single remaining element.
- Setting `hi = mid` vs `hi = mid - 1` — incorrect boundary updates cause
  infinite loops or skipped answers.
- Not recognising that a problem has a monotone feasibility property and can
  therefore be solved with binary search on the answer.
