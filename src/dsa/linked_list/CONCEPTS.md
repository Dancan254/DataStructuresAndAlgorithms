# Linked List

## Overview

A linked list is a sequence of nodes where each node holds a value and a pointer
to the next node. Unlike arrays, nodes are not stored contiguously in memory —
there is no O(1) index access, but insertions and deletions at a known position
are O(1).

```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}
```

| Operation | Singly Linked List | Notes |
|-----------|--------------------|-------|
| Access by index | O(n) | Must traverse from head |
| Insert at head | O(1) | |
| Insert at tail | O(n) or O(1) with tail pointer | |
| Delete by value | O(n) | Must find predecessor |
| Delete at known node | O(1) | |

---

## Pattern 1: Iterative Reversal

Traverse the list once, redirecting each `next` pointer to the previous node.
Maintain three pointers: `prev`, `curr`, `next`.

```java
// O(n) time, O(1) space
public ListNode reverseList(ListNode head) {
    ListNode prev = null, curr = head;
    while (curr != null) {
        ListNode next = curr.next; // save before overwriting
        curr.next = prev;          // reverse the link
        prev = curr;
        curr = next;
    }
    return prev; // prev is the new head
}
```

---

## Pattern 2: Merge Two Sorted Lists

Use a dummy head to simplify the logic — avoids special-casing the first node.
At each step pick the smaller of the two current nodes.

```java
// O(n + m) time, O(1) space
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) { curr.next = l1; l1 = l1.next; }
        else                   { curr.next = l2; l2 = l2.next; }
        curr = curr.next;
    }
    curr.next = (l1 != null) ? l1 : l2; // attach remaining nodes
    return dummy.next;
}
```

The dummy head pattern avoids an `if (head == null)` check at every insertion.

---

## Pattern 3: Fast and Slow Pointers

Two pointers traverse the list at different speeds. When fast reaches the end,
slow is at a useful position (middle, cycle entry, etc.).

**Detect cycle (LeetCode 141):**
```java
public boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) return true; // they meet inside the cycle
    }
    return false;
}
```

**Find middle of list:**
When fast reaches the end, slow is at the middle. For even-length lists this
returns the second of the two middle nodes.

```java
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
// slow is the middle node
```

---

## Pattern 4: Remove Nth Node From End

Use two pointers separated by a gap of n. When fast reaches the end, slow is
just before the target node.

```java
// O(n) time, O(1) space — single pass
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode slow = dummy, fast = dummy;

    // Advance fast n+1 steps so gap between slow and fast is n
    for (int i = 0; i <= n; i++) fast = fast.next;

    while (fast != null) {
        slow = slow.next;
        fast = fast.next;
    }
    slow.next = slow.next.next; // skip the target node
    return dummy.next;
}
```

---

## Pattern 5: Reorder List

Reorder `L0 -> L1 -> ... -> Ln` into `L0 -> Ln -> L1 -> Ln-1 -> ...`

Three steps:
1. Find the middle with fast/slow pointers.
2. Reverse the second half.
3. Merge the two halves by alternating nodes.

```java
// O(n) time, O(1) space
public void reorderList(ListNode head) {
    // 1. Find middle
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // 2. Reverse second half
    ListNode second = slow.next;
    slow.next = null;   // cut the list in half
    ListNode prev = null;
    while (second != null) {
        ListNode tmp = second.next;
        second.next = prev;
        prev = second;
        second = tmp;
    }

    // 3. Merge two halves
    ListNode first = head;
    second = prev;
    while (second != null) {
        ListNode tmp1 = first.next, tmp2 = second.next;
        first.next = second;
        second.next = tmp1;
        first = tmp1;
        second = tmp2;
    }
}
```

---

## Complexity Summary

| Pattern | Time | Space |
|---------|------|-------|
| Iterative reversal | O(n) | O(1) |
| Merge two sorted lists | O(n + m) | O(1) |
| Fast/slow — cycle detection | O(n) | O(1) |
| Remove Nth from end | O(n) | O(1) |
| Reorder list | O(n) | O(1) |

---

## Common Mistakes

- Not saving `curr.next` before redirecting `curr.next = prev` in reversal.
- Forgetting to set `slow.next = null` when splitting a list in half.
- Not using a dummy head when the returned head could change (e.g., deletion,
  merge), causing conditional logic for the first node.
- Accessing `fast.next.next` without checking `fast.next != null` first — causes
  a NullPointerException.
