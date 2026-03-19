# Heap / Priority Queue

## What Is a Heap?

A heap is a **complete binary tree** that satisfies the **heap property**:

- **Min-Heap:** every parent is less than or equal to its children.
  The minimum element is always at the root.
- **Max-Heap:** every parent is greater than or equal to its children.
  The maximum element is always at the root.

A heap is **not** a sorted structure — only the root is guaranteed to be the
global minimum (or maximum). It is optimised for repeatedly extracting the
min/max element.

---

## Storage as an Array

A complete binary tree can be stored compactly in an array without pointers.
For a node at index i (0-based):

```
Parent:       (i - 1) / 2
Left child:   2 * i + 1
Right child:  2 * i + 2
```

```
Min-Heap array:  [1, 3, 2, 7, 6, 5, 4]

Visualised:
           1          index 0
         /   \
        3     2       index 1, 2
       / \   / \
      7   6 5   4     index 3, 4, 5, 6
```

---

## Core Operations

| Operation | Time | Description |
|-----------|------|-------------|
| peek() | O(1) | View min/max (root) |
| offer() / insert | O(log n) | Add element, sift up |
| poll() / extractMin | O(log n) | Remove root, sift down |
| heapify (build from array) | O(n) | Floyd's algorithm |
| heapSort | O(n log n) | Build heap + n extractions |

---

## Sift Up (After Insert)

Insert at the last position (end of array), then repeatedly swap with the
parent as long as the heap property is violated.

```java
void siftUp(int i) {
    while (i > 0) {
        int parent = (i - 1) / 2;
        if (heap[i] < heap[parent]) {   // min-heap condition
            swap(i, parent);
            i = parent;
        } else break;
    }
}
```

---

## Sift Down (After Extract Min)

Replace the root with the last element (remove the last to maintain completeness),
then repeatedly swap with the smaller child until the heap property is restored.

```java
void siftDown(int i, int size) {
    while (true) {
        int smallest = i;
        int left  = 2 * i + 1;
        int right = 2 * i + 2;
        if (left  < size && heap[left]  < heap[smallest]) smallest = left;
        if (right < size && heap[right] < heap[smallest]) smallest = right;
        if (smallest == i) break;
        swap(i, smallest);
        i = smallest;
    }
}
```

---

## Building a Heap in O(n) — Floyd's Algorithm

Naively inserting n elements costs O(n log n). Floyd's algorithm builds a heap
in O(n) by calling siftDown on all internal nodes from bottom to top.

```java
void buildHeap(int[] arr) {
    int n = arr.length;
    // Start from the last non-leaf node and sift down each
    for (int i = n / 2 - 1; i >= 0; i--) {
        siftDown(i, n);
    }
}
```

Why O(n)? Most nodes are near the bottom and need very little sifting.
The mathematical sum converges to O(n).

---

## Heap Sort

1. Build a max-heap from the array: O(n)
2. Repeatedly extract the max (swap root with last, reduce heap size, sift down): O(n log n)
3. Result: sorted array in ascending order.

```java
void heapSort(int[] arr) {
    int n = arr.length;

    // Step 1: build max-heap
    for (int i = n / 2 - 1; i >= 0; i--)
        siftDownMax(arr, i, n);

    // Step 2: extract elements one by one
    for (int i = n - 1; i > 0; i--) {
        swap(arr, 0, i);          // move current max to end
        siftDownMax(arr, 0, i);   // restore heap property for reduced size
    }
}
```

---

## Priority Queue in Java

Java's `PriorityQueue<T>` is a min-heap by default.

```java
// Min-heap (default)
PriorityQueue<Integer> minHeap = new PriorityQueue<>();

// Max-heap
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

// Custom comparator (e.g., sort by second element of int[])
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

// Operations
pq.offer(x);    // insert — O(log n)
pq.poll();      // remove and return min — O(log n)
pq.peek();      // view min — O(1)
pq.size();      // O(1)
pq.isEmpty();   // O(1)
```

---

## Key Interview Patterns

### Top-K Largest — Min-Heap of Size K

Maintain a min-heap of size k. If size exceeds k, evict the minimum (too small
to be in the top k). After processing all n elements, the heap contains the
k largest, with the k-th largest at the heap's root.

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
for (int num : nums) {
    minHeap.offer(num);
    if (minHeap.size() > k) minHeap.poll();
}
// minHeap.peek() is the k-th largest
```

### Two-Heap Running Median

- **Lower half**: max-heap (so the largest of the lower half is at root)
- **Upper half**: min-heap (so the smallest of the upper half is at root)
- Invariant: `lower.size() == upper.size()` or `lower.size() == upper.size() + 1`
- Median: `lower.peek()` when sizes differ, otherwise `(lower.peek() + upper.peek()) / 2.0`

### Merge K Sorted Lists

Use a min-heap containing one node from each list. Poll the min, advance that
list's pointer, insert the next node. O(n log k) total.

---

## Complexity Summary

| Operation | Time | Notes |
|-----------|------|-------|
| peek | O(1) | Root access |
| insert (offer) | O(log n) | Sift up |
| extractMin (poll) | O(log n) | Sift down |
| buildHeap from array | O(n) | Floyd's algorithm |
| heapSort | O(n log n) | Build + n extractions |
| Top-K from n elements | O(n log k) | Min-heap of size k |

---

## Common Mistakes

- Using a max-heap for top-K largest when you need a min-heap (and vice versa).
- Calling `peek()` or `poll()` on an empty queue — check `isEmpty()` first.
- Custom comparators for `int[]` that subtract values: `a[0] - b[0]` can overflow
  for large values. Use `Integer.compare(a[0], b[0])` to be safe.
- Assuming `PriorityQueue` iterates in sorted order — it does not. Only `poll()`
  gives elements in order.
