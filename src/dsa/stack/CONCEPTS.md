# Stack

## What Is a Stack?

A stack is a linear data structure that follows the **Last-In First-Out (LIFO)**
principle. The element inserted last is the first one removed. Think of a stack
of plates — you add to the top and remove from the top.

A stack is an **Abstract Data Type (ADT)** that can be implemented using arrays,
linked lists, or the Java `Deque` interface.

---

## Core Operations

| Operation | Description | Time |
|-----------|-------------|------|
| push(x) | Add element to the top | O(1) |
| pop() | Remove and return the top element | O(1) |
| peek() / top() | View the top element without removing | O(1) |
| isEmpty() | Check if the stack has no elements | O(1) |
| size() | Number of elements | O(1) |

---

## 1. Array-Based Stack

Uses a fixed-size or dynamic array. The top of the stack is tracked by an index.

```
push(1): [1, _, _, _]  top=0
push(2): [1, 2, _, _]  top=1
push(3): [1, 2, 3, _]  top=2
pop():   [1, 2, _, _]  top=1  returns 3
peek():  returns 2, top unchanged
```

**Advantages:** Cache-friendly (contiguous memory), O(1) access by index.
**Disadvantages:** Fixed capacity (unless dynamic array); unused space.

```java
class ArrayStack {
    private int[] data;
    private int top = -1;

    ArrayStack(int capacity) { data = new int[capacity]; }

    void push(int x) {
        if (top == data.length - 1) throw new StackOverflowError();
        data[++top] = x;
    }

    int pop() {
        if (isEmpty()) throw new EmptyStackException();
        return data[top--];
    }

    int peek()      { if (isEmpty()) throw new EmptyStackException(); return data[top]; }
    boolean isEmpty() { return top == -1; }
    int size()      { return top + 1; }
}
```

---

## 2. Linked List–Based Stack

Each push creates a new node at the front (head) of the list. Pop removes
the head. No capacity limit.

```
push(1) → [1] -> null
push(2) → [2] -> [1] -> null   (2 is the new top/head)
push(3) → [3] -> [2] -> [1] -> null
pop()   → [2] -> [1] -> null   returns 3
```

**Advantages:** Dynamic size, no wasted space.
**Disadvantages:** Extra memory per node (pointer overhead), poor cache locality.

```java
class LinkedStack {
    private Node top;
    private int size;

    static class Node { int data; Node next; Node(int d) { data = d; } }

    void push(int x) {
        Node node = new Node(x);
        node.next = top;
        top = node;
        size++;
    }

    int pop() {
        if (isEmpty()) throw new EmptyStackException();
        int val = top.data;
        top = top.next;
        size--;
        return val;
    }

    int peek()        { if (isEmpty()) throw new EmptyStackException(); return top.data; }
    boolean isEmpty() { return top == null; }
    int size()        { return size; }
}
```

---

## 3. Java's Built-In Stack Options

**`ArrayDeque` (preferred):**
```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(x);   // pushes to front (addFirst)
stack.pop();     // removes from front (removeFirst)
stack.peek();    // views front (peekFirst)
```

**Avoid `Stack<T>`** — it extends `Vector`, which is synchronized on every
operation. Use `ArrayDeque` for single-threaded code.

---

## 4. Monotonic Stack

A monotonic stack maintains elements in either strictly increasing or decreasing
order. When a new element violates the order, pop until it doesn't.

**Total time is O(n)** — each element is pushed and popped at most once.

```
Monotonic decreasing stack for input [3, 1, 4, 1, 5, 9, 2, 6]:

Process 3: stack [3]
Process 1: 1 < 3, push. stack [3, 1]
Process 4: 4 > 1, pop 1. 4 > 3, pop 3. push 4. stack [4]
Process 1: 1 < 4, push. stack [4, 1]
Process 5: 5 > 1, pop. 5 > 4, pop. push 5. stack [5]
...
```

**When to use:**
- Next Greater Element (to the right or left)
- Previous Greater/Smaller Element
- Largest Rectangle in Histogram
- Trapping Rain Water
- Daily Temperatures

**Monotonic Increasing template (Next Greater Element):**
```java
int[] result = new int[n];
Arrays.fill(result, -1);
Deque<Integer> stack = new ArrayDeque<>(); // stores indices

for (int i = 0; i < n; i++) {
    while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
        result[stack.pop()] = nums[i]; // i is the next greater for stack.peek()
    }
    stack.push(i);
}
```

---

## 5. Call Stack and Recursion

Every function call occupies a stack frame containing local variables, parameters,
and a return address. Deep recursion consumes O(h) stack space.
Converting recursion to an explicit stack avoids stack overflow for deep inputs.

**DFS with explicit stack (replacing recursion):**
```java
Deque<TreeNode> stack = new ArrayDeque<>();
stack.push(root);
while (!stack.isEmpty()) {
    TreeNode node = stack.pop();
    process(node);
    if (node.right != null) stack.push(node.right); // push right first
    if (node.left  != null) stack.push(node.left);  // left processed first (LIFO)
}
```

---

## 6. Stack Applications

| Application | Pattern |
|-------------|---------|
| Bracket matching | Push openers, match closers |
| Undo/Redo | Two stacks |
| Expression evaluation (RPN) | Operand stack |
| Browser history | Two stacks (back/forward) |
| Function call management | OS call stack |
| DFS traversal | Explicit node stack |
| Min/Max stack | Parallel tracking stack |

---

## 7. Complexity Summary

| Implementation | push | pop | peek | Space |
|----------------|------|-----|------|-------|
| Array-based | O(1) amortized | O(1) | O(1) | O(n) |
| Linked list–based | O(1) | O(1) | O(1) | O(n) |
| Monotonic (n elements total) | O(n) total | O(n) total | — | O(n) |

---

## Common Mistakes

- Calling `peek()` or `pop()` without checking `isEmpty()`.
- Using `Stack<T>` — use `ArrayDeque` instead.
- In RPN evaluation, popping operands in the wrong order for `-` and `/`.
- In monotonic stacks, using values when you should store indices (you need the
  index to compute distances in problems like Daily Temperatures).
- Forgetting the final `stack.isEmpty()` check after bracket matching.
