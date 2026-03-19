# Heap / Priority Queue — Exercises

---

## Easy

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 1 | Last Stone Weight | [1046](https://leetcode.com/problems/last-stone-weight/) | No | Max-heap, smash two heaviest each round |
| 2 | Kth Largest Element in a Stream | [703](https://leetcode.com/problems/kth-largest-element-in-a-stream/) | No | Min-heap of size k |

## Medium

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 3 | Top K Frequent Elements | [347](https://leetcode.com/problems/top-k-frequent-elements/) | Yes | Frequency map + min-heap of size k |
| 4 | Kth Largest Element in an Array | [215](https://leetcode.com/problems/kth-largest-element-in-an-array/) | No | Min-heap of size k |
| 5 | K Closest Points to Origin | [973](https://leetcode.com/problems/k-closest-points-to-origin/) | No | Max-heap of size k by distance |
| 6 | Task Scheduler | [621](https://leetcode.com/problems/task-scheduler/) | No | Max-heap of frequencies + cooldown queue |
| 7 | Design Twitter | [355](https://leetcode.com/problems/design-twitter/) | No | Min-heap to merge k sorted tweet streams |

## Hard

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 8 | Find Median from Data Stream | [295](https://leetcode.com/problems/find-median-from-data-stream/) | Yes | Two-heap: max-heap lower half, min-heap upper half |
| 9 | Merge K Sorted Lists | [23](https://leetcode.com/problems/merge-k-sorted-lists/) | Yes | Min-heap with one node per list |

---

## Reflection Questions

1. For top-K largest, you use a min-heap. For top-K smallest, which heap do you use and why?
2. In the two-heap median approach, what invariant must hold after every insertion?
3. What is the time complexity of `PriorityQueue.contains()`? When does that matter?
