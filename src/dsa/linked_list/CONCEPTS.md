# Linked List

## What Is a Linked List?

A linked list is a linear data structure where elements (nodes) are stored in
non-contiguous memory locations. Each node holds a value and one or more pointers
to adjacent nodes. Unlike arrays, there is no index-based O(1) access, but
insertions and deletions at a known position are O(1) because no shifting occurs.

---

## Node Structure

```java
// Singly linked node
class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}

// Doubly linked node
class DNode {
    int data;
    DNode prev, next;
    DNode(int data) { this.data = data; }
}
```

---

## 1. Singly Linked List

Each node points only to the next node. Traversal is one-directional (head to tail).

```
head
 |
[1] -> [2] -> [3] -> [4] -> null
```

### Core Operations

| Operation | Time | Notes |
|-----------|------|-------|
| Insert at head | O(1) | Update head pointer |
| Insert at tail | O(n) | Must traverse to find tail |
| Insert at tail (with tail pointer) | O(1) | Keep a tail reference |
| Delete by value | O(n) | Must find predecessor |
| Search | O(n) | Sequential scan |
| Access by index | O(n) | No random access |

### Key Operations Illustrated

**Insert at head:**
```java
Node newNode = new Node(val);
newNode.next = head;
head = newNode;
size++;
```

**Insert at tail:**
```java
Node newNode = new Node(val);
if (head == null) { head = tail = newNode; }
else { tail.next = newNode; tail = newNode; }
size++;
```

**Delete a node (given predecessor):**
```java
predecessor.next = predecessor.next.next;
size--;
```

**Iterative traversal:**
```java
Node curr = head;
while (curr != null) {
    process(curr.data);
    curr = curr.next;
}
```

---

## 2. Doubly Linked List

Each node has a `next` pointer AND a `prev` pointer, enabling traversal in
both directions. This makes deletion of a known node O(1) without needing
the predecessor reference.

```
null <- [1] <-> [2] <-> [3] <-> [4] -> null
         ^                        ^
        head                     tail
```

### Advantages over Singly

- Backward traversal in O(n)
- Delete a node in O(1) given only the node (no predecessor needed)
- Insert before a node in O(1)

### Key Operations Illustrated

**Insert after a given node:**
```java
Node newNode = new Node(val);
newNode.next = node.next;
newNode.prev = node;
if (node.next != null) node.next.prev = newNode;
node.next = newNode;
if (newNode.next == null) tail = newNode;
```

**Delete a known node:**
```java
if (node.prev != null) node.prev.next = node.next;
else head = node.next;          // deleting head

if (node.next != null) node.next.prev = node.prev;
else tail = node.prev;          // deleting tail
```

### Use Cases

- LRU Cache (HashMap + doubly linked list for O(1) eviction)
- Browser history (forward/back navigation)
- Undo/redo in text editors

---

## 3. Circular Singly Linked List

The tail node's `next` pointer points back to the head instead of null.
There is no null terminator — traversal must detect the return to head.

```
     head
      |
[1] -> [2] -> [3] -> [4]
 ^_________________________|
```

### Key Difference in Traversal

```java
if (head == null) return;
Node curr = head;
do {
    process(curr.data);
    curr = curr.next;
} while (curr != head);
```

### Use Cases

- Round-robin scheduling (CPU time slices)
- Circular buffers
- Multiplayer games (turn rotation)

### Insert at Tail

```java
Node newNode = new Node(val);
if (head == null) { head = newNode; newNode.next = head; }
else {
    Node tail = head;
    while (tail.next != head) tail = tail.next;
    tail.next = newNode;
    newNode.next = head;
}
```

---

## 4. Circular Doubly Linked List

Combines doubly linked list with circular structure. The tail's `next` points
to head, and head's `prev` points to tail. This gives O(1) access to both
ends and O(1) insertion/deletion at either end.

```
     head                    tail
      |                        |
[1] <-> [2] <-> [3] <-> [4] <-> (wraps back to [1])
```

### Use Cases

- Deque (double-ended queue) implementation
- Fibonacci heap internals
- Operating system ready queues

---

## 5. Comparison Table

| Property | Singly | Doubly | Circular Singly | Circular Doubly |
|----------|--------|--------|-----------------|-----------------|
| Memory per node | 1 pointer | 2 pointers | 1 pointer | 2 pointers |
| Backward traversal | No | Yes | No | Yes |
| Delete known node | O(n) predecessor needed | O(1) | O(n) | O(1) |
| End detection | null check | null check | compare to head | compare to head |
| Insert at tail (no tail ptr) | O(n) | O(1) via head.prev | O(n) | O(1) via head.prev |

---

## 6. Key Algorithmic Patterns

### Fast and Slow Pointers (Floyd's Algorithm)

Slow advances one step, fast advances two. If a cycle exists, they will meet.
Used for: cycle detection, finding the middle, finding the start of a cycle.

```java
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
    if (slow == fast) { /* cycle detected */ }
}
// If loop exits normally, no cycle. If slow == fast inside, cycle exists.
```

**Finding the middle:**
When fast reaches the end, slow is at the middle.
```java
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
// slow is now the middle node
```

### Iterative Reversal

Maintain three pointers: `prev`, `curr`, `next`.
```java
Node prev = null, curr = head;
while (curr != null) {
    Node next = curr.next;
    curr.next = prev;
    prev = curr;
    curr = next;
}
head = prev;
```

### Dummy Head

Prepend a sentinel node before `head` to eliminate special-casing for
operations that may affect the first real node.

```java
Node dummy = new Node(0);
dummy.next = head;
Node curr = dummy;
// ... operate using curr
return dummy.next; // the (potentially new) head
```

---

## 7. Linked List vs Array

| | Array | Linked List |
|--|-------|------------|
| Access by index | O(1) | O(n) |
| Insert/Delete at head | O(n) | O(1) |
| Insert/Delete at tail | O(1) amortized | O(1) with tail ptr |
| Insert/Delete in middle | O(n) | O(n) search + O(1) operation |
| Memory | Contiguous | Non-contiguous |
| Cache performance | Excellent | Poor (pointer chasing) |
| Size flexibility | Resizing needed | Dynamic by nature |

---

## Common Mistakes

- Losing the rest of the list by overwriting `curr.next` before saving it.
- Off-by-one in fast/slow pointer gaps (advance fast n+1, not n, for remove-nth).
- Not updating the tail pointer when inserting or deleting at the tail.
- In circular lists, using `null` as the loop terminator instead of comparing
  back to `head`.
- Not handling the empty list and single-node edge cases.
