# Linked List — Exercises

---

## Easy

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 1 | Reverse Linked List | [206](https://leetcode.com/problems/reverse-linked-list/) | Yes | Iterative: prev/curr/next triple |
| 2 | Merge Two Sorted Lists | [21](https://leetcode.com/problems/merge-two-sorted-lists/) | Yes | Dummy head + pick smaller |
| 3 | Linked List Cycle | [141](https://leetcode.com/problems/linked-list-cycle/) | Yes | Fast/slow — do they ever meet? |

## Medium

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 4 | Reorder List | [143](https://leetcode.com/problems/reorder-list/) | Yes | Find middle, reverse second half, interleave |
| 5 | Remove Nth Node From End of List | [19](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) | Yes | Two pointers with n-step gap |
| 6 | Copy List with Random Pointer | [138](https://leetcode.com/problems/copy-list-with-random-pointer/) | No | HashMap: original node -> clone |
| 7 | Add Two Numbers | [2](https://leetcode.com/problems/add-two-numbers/) | No | Simulate digit-by-digit addition with carry |
| 8 | Find the Duplicate Number | [287](https://leetcode.com/problems/find-the-duplicate-number/) | No | Floyd's cycle detection |
| 9 | LRU Cache | [146](https://leetcode.com/problems/lru-cache/) | No | HashMap + doubly linked list |

## Hard

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 10 | Merge K Sorted Lists | [23](https://leetcode.com/problems/merge-k-sorted-lists/) | Yes | Min-heap of size k (covered in heap topic) |
| 11 | Reverse Nodes in K-Group | [25](https://leetcode.com/problems/reverse-nodes-in-k-group/) | No | Iterative group reversal with look-ahead |

---

## Reflection Questions

1. In iterative reversal, what would happen if you advanced `curr` before saving `curr.next`?
2. Why does the dummy head pattern simplify merge and deletion problems?
3. In fast/slow pointer cycle detection, prove that they must meet inside the cycle (not miss each other).
4. In Remove Nth From End, why advance `fast` by `n+1` steps rather than `n`?
