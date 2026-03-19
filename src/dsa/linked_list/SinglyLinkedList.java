package dsa.linked_list;

/**
 * Complete Singly Linked List implementation.
 *
 * Each node holds data and a pointer to the next node.
 * The list maintains head and tail references and a size counter.
 *
 * Covers: insertAtHead, insertAtTail, insertAt(index),
 *         deleteHead, deleteTail, deleteByValue, deleteAt(index),
 *         search, get, reverse, size, print.
 */
public class SinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    // -------------------------------------------------------------------------
    // Inner Node class
    // -------------------------------------------------------------------------

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    // -------------------------------------------------------------------------
    // Insertion
    // -------------------------------------------------------------------------

    /** Insert at the front of the list. O(1) */
    public void insertAtHead(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        if (tail == null) tail = head; // first element
        size++;
    }

    /** Insert at the end of the list. O(1) with tail pointer */
    public void insertAtTail(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    /** Insert at a given 0-based index. O(n) */
    public void insertAt(int index, int data) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException(index);
        if (index == 0)    { insertAtHead(data); return; }
        if (index == size) { insertAtTail(data); return; }

        Node prev = getNode(index - 1);
        Node node = new Node(data);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    // -------------------------------------------------------------------------
    // Deletion
    // -------------------------------------------------------------------------

    /** Remove and return the head value. O(1) */
    public int deleteHead() {
        if (head == null) throw new IllegalStateException("List is empty");
        int val = head.data;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return val;
    }

    /** Remove and return the tail value. O(n) — must find predecessor */
    public int deleteTail() {
        if (head == null) throw new IllegalStateException("List is empty");
        int val = tail.data;
        if (head == tail) { head = tail = null; size--; return val; }

        Node curr = head;
        while (curr.next != tail) curr = curr.next;
        curr.next = null;
        tail = curr;
        size--;
        return val;
    }

    /** Remove the first node with the given value. O(n) */
    public boolean deleteByValue(int data) {
        if (head == null) return false;
        if (head.data == data) { deleteHead(); return true; }

        Node curr = head;
        while (curr.next != null) {
            if (curr.next.data == data) {
                if (curr.next == tail) tail = curr;
                curr.next = curr.next.next;
                size--;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    /** Remove node at 0-based index. O(n) */
    public int deleteAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException(index);
        if (index == 0) return deleteHead();
        if (index == size - 1) return deleteTail();

        Node prev = getNode(index - 1);
        int val = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    // -------------------------------------------------------------------------
    // Access and Search
    // -------------------------------------------------------------------------

    /** Return the value at 0-based index. O(n) */
    public int get(int index) {
        return getNode(index).data;
    }

    /** Return true if the list contains the given value. O(n) */
    public boolean contains(int data) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == data) return true;
            curr = curr.next;
        }
        return false;
    }

    /** Return the 0-based index of the first occurrence, or -1. O(n) */
    public int indexOf(int data) {
        Node curr = head;
        int index = 0;
        while (curr != null) {
            if (curr.data == data) return index;
            curr = curr.next;
            index++;
        }
        return -1;
    }

    // -------------------------------------------------------------------------
    // Transformation
    // -------------------------------------------------------------------------

    /** Reverse the list in-place. O(n) */
    public void reverse() {
        Node prev = null, curr = head;
        tail = head; // current head becomes the new tail
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // -------------------------------------------------------------------------
    // Utility
    // -------------------------------------------------------------------------

    public int size()    { return size; }
    public boolean isEmpty() { return size == 0; }

    private Node getNode(int index) {
        Node curr = head;
        for (int i = 0; i < index; i++) curr = curr.next;
        return curr;
    }

    public void print() {
        Node curr = head;
        StringBuilder sb = new StringBuilder("HEAD -> ");
        while (curr != null) {
            sb.append(curr.data);
            if (curr.next != null) sb.append(" -> ");
            curr = curr.next;
        }
        sb.append(" -> NULL");
        System.out.println(sb);
    }

    // -------------------------------------------------------------------------
    // Demo
    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtHead(0);
        list.insertAt(2, 99);
        list.print(); // HEAD -> 0 -> 1 -> 99 -> 2 -> 3 -> NULL

        System.out.println("Size: " + list.size());          // 5
        System.out.println("Get index 2: " + list.get(2));   // 99
        System.out.println("Contains 3: " + list.contains(3)); // true

        list.deleteByValue(99);
        list.print(); // HEAD -> 0 -> 1 -> 2 -> 3 -> NULL

        list.reverse();
        list.print(); // HEAD -> 3 -> 2 -> 1 -> 0 -> NULL

        list.deleteHead();
        list.deleteTail();
        list.print(); // HEAD -> 2 -> 1 -> NULL
    }
}
