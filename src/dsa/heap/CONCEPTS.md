# Heap / Priority Queue

## Overview

A heap is a complete binary tree that satisfies the heap property: in a min-heap,
every parent is smaller than or equal to its children; in a max-heap, every parent
is larger. This guarantees that the minimum (or maximum) element is always at the
root and accessible in O(1), with insertions and removals costing O(log n).

Java provides `PriorityQueue<T>`, which is a min-heap by default. Pass a
`Comparator` to reverse the order for a max-heap.

```java
// Min-heap (default)
PriorityQueue<Integer> minHeap = new PriorityQueue<>();

// Max-heap
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

// Custom comparator (sort by frequency, then by value)
PriorityQueue<int[]> custom = new PriorityQueue<>(
    (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]
);

minHeap.offer(x);   // insert — O(log n)
minHeap.poll();     // remove and return min — O(log n)
minHeap.peek();     // view min without removing — O(1)
```

---

## When to Use a Heap

- You need repeated access to the minimum or maximum element.
- You need the top-K smallest or largest elements from a stream or array.
- You need to merge K sorted sequences.
- You need a running median as elements arrive.

---

## Pattern 1: Top-K Elements

Maintain a heap of size k. For top-K largest, use a min-heap — if the heap
exceeds size k, evict the current minimum. What remains are the k largest.

```java
// O(n log k) time, O(k) space
public int[] topKLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int num : nums) {
        minHeap.offer(num);
        if (minHeap.size() > k) minHeap.poll(); // remove smallest
    }
    int[] result = new int[k];
    for (int i = k - 1; i >= 0; i--) result[i] = minHeap.poll();
    return result;
}
```

**Why a min-heap for K largest?** The heap tracks the "threshold": if a new
element is smaller than the current k-th largest (heap top), discard it.

**Example — Kth Largest Element in an Array (LeetCode 215):**
Same pattern — return `minHeap.peek()` after processing all n elements.

```java
// O(n log k) time, O(k) space
public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int num : nums) {
        minHeap.offer(num);
        if (minHeap.size() > k) minHeap.poll();
    }
    return minHeap.peek();
}
```

---

## Pattern 2: K Closest Points to Origin

Use a max-heap of size k ordered by distance. Evict the farthest point when
the heap exceeds size k. What remains are the k closest.

```java
// O(n log k) time, O(k) space
public int[][] kClosest(int[][] points, int k) {
    // Max-heap by distance — evict farthest
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
        (a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
    );
    for (int[] p : points) {
        maxHeap.offer(p);
        if (maxHeap.size() > k) maxHeap.poll();
    }
    return maxHeap.toArray(new int[k][]);
}
```

---

## Pattern 3: Merge K Sorted Lists

Use a min-heap containing one node from each list. Always extract the minimum,
advance that list's pointer, and insert the next node.

```java
// O(n log k) time, n = total nodes, k = number of lists
public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
        Comparator.comparingInt(a -> a.val)
    );
    for (ListNode node : lists) {
        if (node != null) minHeap.offer(node);
    }

    ListNode dummy = new ListNode(0), curr = dummy;
    while (!minHeap.isEmpty()) {
        ListNode node = minHeap.poll();
        curr.next = node;
        curr = curr.next;
        if (node.next != null) minHeap.offer(node.next);
    }
    return dummy.next;
}
```

---

## Pattern 4: Two-Heap for Running Median

Maintain two heaps: a max-heap for the lower half and a min-heap for the upper
half. The median is the top of one or the average of both tops.

**Invariant:** `maxHeap.size()` is equal to or one greater than `minHeap.size()`.

```java
class MedianFinder {
    // Lower half — max-heap so we can access the largest in O(1)
    private PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
    // Upper half — min-heap so we can access the smallest in O(1)
    private PriorityQueue<Integer> upper = new PriorityQueue<>();

    public void addNum(int num) {
        lower.offer(num);                        // always push to lower first
        upper.offer(lower.poll());               // balance: push lower's max to upper
        if (upper.size() > lower.size()) {       // keep lower >= upper in size
            lower.offer(upper.poll());
        }
    }

    public double findMedian() {
        if (lower.size() > upper.size()) return lower.peek();
        return (lower.peek() + upper.peek()) / 2.0;
    }
}
```

---

## Complexity Summary

| Operation | PriorityQueue |
|-----------|--------------|
| Insert (offer) | O(log n) |
| Remove min/max (poll) | O(log n) |
| View min/max (peek) | O(1) |
| Top-K from n elements | O(n log k) |
| Merge K sorted lists | O(n log k) |
| Running median (per element) | O(log n) |

---

## Common Mistakes

- Using a max-heap when a min-heap is needed for top-K largest (and vice versa).
- Not importing `java.util.Collections` for `Collections.reverseOrder()`.
- Calling `peek()` or `poll()` on an empty queue — always check `isEmpty()`.
- Comparing `int[]` arrays by reference instead of value in a custom comparator.
- In the two-heap median problem, not rebalancing after insertion — the size
  invariant must hold after every `addNum` call.
