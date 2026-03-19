# Intervals — Exercises

---

## Easy

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 1 | Meeting Rooms | [252](https://leetcode.com/problems/meeting-rooms/) | Yes | Sort by start; any adjacent overlap → false |

## Medium

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 2 | Insert Interval | [57](https://leetcode.com/problems/insert-interval/) | Yes | Three-phase: before, merge overlap, after |
| 3 | Merge Intervals | [56](https://leetcode.com/problems/merge-intervals/) | Yes | Sort by start; extend last if overlap |
| 4 | Non-overlapping Intervals | [435](https://leetcode.com/problems/non-overlapping-intervals/) | Yes | Sort by end; greedy keep earliest-ending |
| 5 | Meeting Rooms II | [253](https://leetcode.com/problems/meeting-rooms-ii/) | Yes | Min-heap of end times; reuse if top <= start |
| 6 | Minimum Interval to Include Each Query | [1851](https://leetcode.com/problems/minimum-interval-to-include-each-query/) | No | Sort intervals and queries; min-heap of active intervals |

---

## Reflection Questions

1. Why do we sort by end time for Non-overlapping Intervals but by start time for Merge Intervals?
2. In Meeting Rooms II, what does the heap size represent at any point during the iteration?
3. In Insert Interval, what is the overlap condition between an existing interval and the new one?
