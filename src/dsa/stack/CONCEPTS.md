# Stack

## Overview

A stack is a Last-In First-Out (LIFO) data structure. Elements are pushed onto
the top and popped from the top. Java provides `Deque<T>` (use `ArrayDeque`)
as the preferred stack implementation — avoid the legacy `Stack` class.

```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(x);     // push to top — O(1)
stack.pop();       // remove and return top — O(1)
stack.peek();      // view top without removing — O(1)
stack.isEmpty();   // O(1)
```

---

## When to Use a Stack

- You need to process elements in reverse order of their appearance.
- You need to match opening and closing delimiters (brackets, tags, operators).
- You need access to the nearest previous or next element satisfying a condition
  (monotonic stack).
- Evaluating or parsing expressions.
- Replacing recursion with explicit call simulation.

---

## Pattern 1: Matching / Validity (Bracket Problems)

Push opening characters onto the stack. When a closing character is encountered,
check that the top of the stack holds the matching opener.

**Example — Valid Parentheses (LeetCode 20):**

```java
// O(n) time, O(n) space
public boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();

    for (char c : s.toCharArray()) {
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
        } else {
            if (stack.isEmpty()) return false;
            char top = stack.pop();
            if (c == ')' && top != '(') return false;
            if (c == '}' && top != '{') return false;
            if (c == ']' && top != '[') return false;
        }
    }

    return stack.isEmpty();
}
```

**Why `stack.isEmpty()` at the end?** Unclosed openers like `"((("` would leave
elements on the stack without the loop catching them.

---

## Pattern 2: Min Stack (Auxiliary Stack for O(1) Queries)

Maintain a second stack that stores the current minimum alongside the main stack.
Every push records what the minimum was at that depth.

**Example — Min Stack (LeetCode 155):**

```java
class MinStack {
    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> minStack = new ArrayDeque<>();

    public void push(int val) {
        stack.push(val);
        int currentMin = minStack.isEmpty() ? val : Math.min(val, minStack.peek());
        minStack.push(currentMin);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top()    { return stack.peek(); }
    public int getMin() { return minStack.peek(); }
}
```

---

## Pattern 3: Monotonic Stack

A monotonic stack maintains elements in either strictly increasing or strictly
decreasing order. When a new element violates the order, pop until it no longer
does. This gives O(n) total time — each element is pushed and popped at most once.

**Use cases:**
- Next greater element / previous greater element.
- Daily temperatures.
- Largest rectangle in histogram.
- Trapping rain water (stack alternative to two-pointer).

**Template — Next Greater Element:**
```java
int[] result = new int[n];
Arrays.fill(result, -1);
Deque<Integer> stack = new ArrayDeque<>(); // stores indices

for (int i = 0; i < n; i++) {
    // Current element is greater than elements waiting on the stack
    while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
        result[stack.pop()] = nums[i];
    }
    stack.push(i);
}
```

**Example — Daily Temperatures (LeetCode 739):**
For each day, find how many days until a warmer temperature.

```java
// O(n) time, O(n) space
public int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] result = new int[n];
    Deque<Integer> stack = new ArrayDeque<>(); // indices of unresolved days

    for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
            int prevDay = stack.pop();
            result[prevDay] = i - prevDay;
        }
        stack.push(i);
    }
    return result;
}
```

---

## Pattern 4: Expression Evaluation (Reverse Polish Notation)

Operands are pushed; when an operator is encountered, pop two operands, apply
the operator, and push the result.

**Example — Evaluate Reverse Polish Notation (LeetCode 150):**

```java
// O(n) time, O(n) space
public int evalRPN(String[] tokens) {
    Deque<Integer> stack = new ArrayDeque<>();

    for (String token : tokens) {
        switch (token) {
            case "+" -> stack.push(stack.pop() + stack.pop());
            case "-" -> { int b = stack.pop(), a = stack.pop(); stack.push(a - b); }
            case "*" -> stack.push(stack.pop() * stack.pop());
            case "/" -> { int b = stack.pop(), a = stack.pop(); stack.push(a / b); }
            default  -> stack.push(Integer.parseInt(token));
        }
    }
    return stack.pop();
}
```

Note the order of pops for `-` and `/`: the second pop gives the left operand.

---

## Complexity Summary

| Operation | ArrayDeque | Notes |
|-----------|-----------|-------|
| push | O(1) amortized | |
| pop | O(1) | |
| peek | O(1) | |
| Monotonic stack processing (n elements) | O(n) total | Each element pushed/popped once |

---

## Common Mistakes

- Using `Stack<T>` from Java — it extends `Vector` and is thread-synchronized.
  Use `ArrayDeque` instead.
- Calling `peek()` or `pop()` on an empty stack without checking `isEmpty()`.
- In subtraction/division with RPN, popping in the wrong order.
- Forgetting the final `stack.isEmpty()` check in bracket matching.
