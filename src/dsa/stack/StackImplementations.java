package dsa.stack;

import java.util.EmptyStackException;

/**
 * Two stack implementations side by side:
 *   1. ArrayStack  — backed by a resizable array
 *   2. LinkedStack — backed by a singly linked list
 *
 * Both implement the same StackADT interface.
 */
public class StackImplementations {

    // -------------------------------------------------------------------------
    // ADT interface
    // -------------------------------------------------------------------------

    interface StackADT {
        void push(int x);
        int  pop();
        int  peek();
        boolean isEmpty();
        int  size();
    }

    // =========================================================================
    // 1. Array-Based Stack
    // =========================================================================

    /**
     * Uses a dynamic array that doubles when capacity is reached.
     * push/pop/peek are O(1) amortized.
     */
    static class ArrayStack implements StackADT {
        private int[] data;
        private int top = -1;

        ArrayStack() { this(16); }
        ArrayStack(int initialCapacity) { data = new int[initialCapacity]; }

        @Override
        public void push(int x) {
            if (top == data.length - 1) resize();
            data[++top] = x;
        }

        @Override
        public int pop() {
            if (isEmpty()) throw new EmptyStackException();
            return data[top--];
        }

        @Override
        public int peek() {
            if (isEmpty()) throw new EmptyStackException();
            return data[top];
        }

        @Override public boolean isEmpty() { return top == -1; }
        @Override public int size()        { return top + 1; }

        private void resize() {
            int[] bigger = new int[data.length * 2];
            System.arraycopy(data, 0, bigger, 0, data.length);
            data = bigger;
        }
    }

    // =========================================================================
    // 2. Linked List–Based Stack
    // =========================================================================

    /**
     * Each push prepends a new node; each pop removes the head.
     * No capacity limit. O(1) push/pop/peek.
     */
    static class LinkedStack implements StackADT {

        private static class Node {
            int data;
            Node next;
            Node(int data) { this.data = data; }
        }

        private Node top;
        private int size;

        @Override
        public void push(int x) {
            Node node = new Node(x);
            node.next = top;
            top = node;
            size++;
        }

        @Override
        public int pop() {
            if (isEmpty()) throw new EmptyStackException();
            int val = top.data;
            top = top.next;
            size--;
            return val;
        }

        @Override
        public int peek() {
            if (isEmpty()) throw new EmptyStackException();
            return top.data;
        }

        @Override public boolean isEmpty() { return top == null; }
        @Override public int size()        { return size; }
    }

    // =========================================================================
    // 3. Min Stack (O(1) getMin at all times)
    // =========================================================================

    /**
     * Maintains a parallel stack tracking the minimum at every depth.
     * getMin() is O(1) because minStack.peek() is always the current minimum.
     */
    static class MinStack {
        private final ArrayStack main = new ArrayStack();
        private final ArrayStack mins = new ArrayStack();

        public void push(int val) {
            main.push(val);
            int currentMin = mins.isEmpty() ? val : Math.min(val, mins.peek());
            mins.push(currentMin);
        }

        public void pop() {
            main.pop();
            mins.pop();
        }

        public int top()    { return main.peek(); }
        public int getMin() { return mins.peek(); }
    }

    // -------------------------------------------------------------------------
    // Demo
    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println("=== ArrayStack ===");
        ArrayStack as = new ArrayStack(4);
        as.push(1); as.push(2); as.push(3);
        System.out.println("Peek: " + as.peek()); // 3
        System.out.println("Pop: "  + as.pop());  // 3
        System.out.println("Pop: "  + as.pop());  // 2
        System.out.println("Size: " + as.size());  // 1

        System.out.println("\n=== LinkedStack ===");
        LinkedStack ls = new LinkedStack();
        ls.push(10); ls.push(20); ls.push(30);
        System.out.println("Peek: " + ls.peek()); // 30
        System.out.println("Pop: "  + ls.pop());  // 30
        System.out.println("Empty: " + ls.isEmpty()); // false

        System.out.println("\n=== MinStack ===");
        MinStack ms = new MinStack();
        ms.push(5); ms.push(3); ms.push(7); ms.push(1);
        System.out.println("Min: " + ms.getMin()); // 1
        ms.pop();
        System.out.println("Min: " + ms.getMin()); // 3
        ms.pop();
        System.out.println("Min: " + ms.getMin()); // 3
        ms.pop();
        System.out.println("Min: " + ms.getMin()); // 5
    }
}
