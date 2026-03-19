package dsa.linked_list;

/**
 * Circular Singly Linked List implementation.
 *
 * The tail node's `next` pointer points back to the head instead of null.
 * The list holds only a `tail` reference — from tail you can reach head in O(1)
 * via tail.next, which makes insertAtHead and insertAtTail both O(1).
 *
 * Covers: insertAtHead, insertAtTail, deleteHead, deleteTail,
 *         deleteByValue, contains, size, print (do-while loop required).
 *
 * Key property: there is no null anywhere in the list once it has one element.
 * All traversal must use a do-while or compare against the starting node.
 */
public class CircularLinkedList {

    private Node tail; // keeping tail (not head) gives O(1) access to both ends
    private int size;

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    // -------------------------------------------------------------------------
    // Insertion
    // -------------------------------------------------------------------------

    /** Insert at the front (before head). O(1) */
    public void insertAtHead(int data) {
        Node node = new Node(data);
        if (tail == null) {
            tail = node;
            node.next = node; // points to itself
        } else {
            node.next = tail.next; // new node points to old head
            tail.next = node;      // tail points to new head
        }
        size++;
    }

    /** Insert at the back (new tail). O(1) */
    public void insertAtTail(int data) {
        Node node = new Node(data);
        if (tail == null) {
            tail = node;
            node.next = node;
        } else {
            node.next = tail.next; // new tail points to head
            tail.next = node;      // old tail points to new tail
            tail = node;           // update tail reference
        }
        size++;
    }

    // -------------------------------------------------------------------------
    // Deletion
    // -------------------------------------------------------------------------

    /** Remove the head node (tail.next). O(1) */
    public int deleteHead() {
        if (tail == null) throw new IllegalStateException("List is empty");
        Node head = tail.next;
        int val = head.data;
        if (tail == head) {
            tail = null; // only one element
        } else {
            tail.next = head.next;
        }
        size--;
        return val;
    }

    /** Remove the tail node. O(n) — must find the new tail */
    public int deleteTail() {
        if (tail == null) throw new IllegalStateException("List is empty");
        int val = tail.data;
        if (tail.next == tail) {
            tail = null; // only one element
            size--;
            return val;
        }
        Node curr = tail.next; // start at head
        while (curr.next != tail) curr = curr.next;
        curr.next = tail.next; // new tail points to head
        tail = curr;
        size--;
        return val;
    }

    /** Remove the first node with the given value. O(n) */
    public boolean deleteByValue(int data) {
        if (tail == null) return false;

        Node head = tail.next;
        if (head.data == data) { deleteHead(); return true; }
        if (tail.data == data) { deleteTail(); return true; }

        Node curr = head;
        do {
            if (curr.next.data == data) {
                curr.next = curr.next.next;
                size--;
                return true;
            }
            curr = curr.next;
        } while (curr != tail);
        return false;
    }

    // -------------------------------------------------------------------------
    // Search
    // -------------------------------------------------------------------------

    /** Return true if the list contains the given value. O(n) */
    public boolean contains(int data) {
        if (tail == null) return false;
        Node curr = tail.next; // start at head
        do {
            if (curr.data == data) return true;
            curr = curr.next;
        } while (curr != tail.next); // stop when we return to head
        return false;
    }

    // -------------------------------------------------------------------------
    // Utility
    // -------------------------------------------------------------------------

    public int size()        { return size; }
    public boolean isEmpty() { return size == 0; }

    /** Print all nodes. Uses do-while to handle the circular structure. */
    public void print() {
        if (tail == null) { System.out.println("(empty)"); return; }
        Node curr = tail.next; // start at head
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(curr.data).append(" -> ");
            curr = curr.next;
        } while (curr != tail.next);
        sb.append("(back to head: ").append(tail.next.data).append(")");
        System.out.println(sb);
    }

    // -------------------------------------------------------------------------
    // Demo
    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtHead(0);
        list.print(); // 0 -> 1 -> 2 -> 3 -> (back to head: 0)

        System.out.println("Contains 2: " + list.contains(2)); // true
        System.out.println("Contains 9: " + list.contains(9)); // false

        list.deleteByValue(2);
        list.print(); // 0 -> 1 -> 3 -> (back to head: 0)

        list.deleteHead();
        list.print(); // 1 -> 3 -> (back to head: 1)

        list.deleteTail();
        list.print(); // 1 -> (back to head: 1)

        System.out.println("Size: " + list.size()); // 1
    }
}
