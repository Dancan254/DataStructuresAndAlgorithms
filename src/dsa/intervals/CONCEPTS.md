# Intervals

## Overview

Interval problems involve pairs `[start, end]` representing ranges on a number
line. The key operations are: merging overlapping intervals, inserting a new
interval, finding the minimum number of intervals to remove, and scheduling.

Two intervals `[a, b]` and `[c, d]` overlap if and only if `a <= d && c <= b`.
Equivalently, they do NOT overlap if `b < c` (first ends before second starts)
or `d < a` (second ends before first starts).

---

## Pattern 1: Sort by Start, Then Merge

Sort intervals by start time. Iterate through and merge any interval that
overlaps with the last interval in the output.

**Example — Merge Intervals (LeetCode 56):**

```java
// O(n log n) time, O(n) space
public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);  // sort by start

    List<int[]> merged = new ArrayList<>();
    merged.add(intervals[0]);

    for (int[] curr : intervals) {
        int[] last = merged.get(merged.size() - 1);
        if (curr[0] <= last[1]) {
            // Overlapping — extend the end of the last merged interval
            last[1] = Math.max(last[1], curr[1]);
        } else {
            merged.add(curr);
        }
    }
    return merged.toArray(new int[0][]);
}
```

---

## Pattern 2: Insert and Merge

Insert a new interval into a sorted list, merging as needed.

**Example — Insert Interval (LeetCode 57):**
Three phases:
1. Add all intervals that end before the new one starts.
2. Merge all overlapping intervals with the new one.
3. Add all remaining intervals.

```java
// O(n) time, O(n) space
public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> result = new ArrayList<>();
    int i = 0, n = intervals.length;

    // Phase 1: add all intervals ending before newInterval starts
    while (i < n && intervals[i][1] < newInterval[0]) {
        result.add(intervals[i++]);
    }

    // Phase 2: merge all overlapping intervals
    while (i < n && intervals[i][0] <= newInterval[1]) {
        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        i++;
    }
    result.add(newInterval);

    // Phase 3: add remaining intervals
    while (i < n) result.add(intervals[i++]);

    return result.toArray(new int[0][]);
}
```

---

## Pattern 3: Greedy — Minimum Removals

**Example — Non-overlapping Intervals (LeetCode 435):**
Find the minimum number of intervals to remove so that no two overlap.
Equivalently, find the maximum number of non-overlapping intervals to keep.

Greedy: sort by end time. Always keep the interval with the earliest end.
When an interval overlaps with the last kept interval, remove it (increment count).

```java
// O(n log n) time, O(1) space
public int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[1] - b[1]); // sort by end

    int removed = 0;
    int prevEnd = Integer.MIN_VALUE;

    for (int[] interval : intervals) {
        if (interval[0] >= prevEnd) {
            // No overlap — keep this interval
            prevEnd = interval[1];
        } else {
            // Overlap — remove this interval
            removed++;
        }
    }
    return removed;
}
```

---

## Pattern 4: Meeting Rooms (Scheduling)

**Meeting Rooms I (LeetCode 252):**
Can one person attend all meetings? Sort by start time and check for any overlap.

```java
// O(n log n) time
public boolean canAttendMeetings(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    for (int i = 1; i < intervals.length; i++) {
        if (intervals[i][0] < intervals[i-1][1]) return false;
    }
    return true;
}
```

**Meeting Rooms II (LeetCode 253):**
Minimum number of rooms required. Use a min-heap of end times.
Sort by start time. For each meeting, if the earliest-ending meeting has
finished, reuse its room; otherwise allocate a new room.

```java
// O(n log n) time, O(n) space
public int minMeetingRooms(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    PriorityQueue<Integer> endTimes = new PriorityQueue<>(); // min-heap of end times

    for (int[] interval : intervals) {
        if (!endTimes.isEmpty() && endTimes.peek() <= interval[0]) {
            endTimes.poll(); // reuse room — earliest meeting has ended
        }
        endTimes.offer(interval[1]);
    }
    return endTimes.size(); // number of rooms in use = heap size
}
```

---

## Complexity Summary

| Pattern | Time | Space |
|---------|------|-------|
| Merge overlapping | O(n log n) | O(n) |
| Insert interval | O(n) | O(n) |
| Min removals (greedy) | O(n log n) | O(1) |
| Meeting rooms II | O(n log n) | O(n) |

---

## Common Mistakes

- Sorting by end instead of start for Merge Intervals (causes incorrect merging).
- Forgetting that the merge condition is `curr[0] <= last[1]` (not strict `<`).
- In Meeting Rooms II, checking `endTimes.peek() <= interval[0]` — using `<`
  instead of `<=` would treat back-to-back meetings as overlapping.
- Modifying interval arrays in-place when the original is needed again.
