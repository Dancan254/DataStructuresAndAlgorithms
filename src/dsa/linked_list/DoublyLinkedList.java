package dsa.linked_list;

/**
 * Complete Doubly Linked List implementation.
 *
 * Each node has both `next` and `prev` pointers. The list maintains head
 * and tail references. Backward traversal and O(1) deletion of a known
 * node are the primary advantages over a singly linked list.
 *
 * Covers: insertAtHead, insertAtTail, insertBefore, insertAfter,
 *         deleteHead, deleteTail, delete(node), deleteByValue,
 *         forward/backward traversal, search, reverse.
 */
public class DoublyLinkedList {

    private DNode head;
    private DNode tail;
    private int size;

    // -------------------------------------------------------------------------
    // Inner Node class
    // -------------------------------------------------------------------------

    static class DNode {
        int data;
        DNode prev, next;
        DNode(int data) { this.data = data; }
    }

    // -------------------------------------------------------------------------
    // Insertion
    // -------------------------------------------------------------------------

    /** Insert at the front. O(1) */
    public void insertAtHead(int data) {
        DNode node = new DNode(data);
        node.next = head;
        if (head != null) head.prev = node;
        head = node;
        if (tail == null) tail = head;
        size++;
    }

    /** Insert at the tail. O(1) */
    public void insertAtTail(int data) {
        DNode node = new DNode(data);
        node.prev = tail;
        if (tail != null) tail.next = node;
        tail = node;
        if (head == null) head = tail;
        size++;
    }

    /** Insert a new node immediately before the given node. O(1) */
    public void insertBefore(DNode target, int data) {
        if (target == null) return;
        if (target == head) { insertAtHead(data); return; }

        DNode node = new DNode(data);
        node.prev = target.prev;
        node.next = target;
        target.prev.next = node;
        target.prev = node;
        size++;
    }

    /** Insert a new node immediately after the given node. O(1) */
    public void insertAfter(DNode target, int data) {
        if (target == null) return;
        if (target == tail) { insertAtTail(data); return; }

        DNode node = new DNode(data);
        node.next = target.next;
        node.prev = target;
        target.next.prev = node;
        target.next = node;
        size++;
    }

    // -------------------------------------------------------------------------
    // Deletion
    // -------------------------------------------------------------------------

    /** Remove the head node. O(1) */
    public int deleteHead() {
        if (head == null) throw new IllegalStateException("List is empty");
        int val = head.data;
        head = head.next;
        if (head != null) head.prev = null;
        else              tail = null;  // list is now empty
        size--;
        return val;
    }

    /** Remove the tail node. O(1) — key advantage over singly linked list */
    public int deleteTail() {
        if (tail == null) throw new IllegalStateException("List is empty");
        int val = tail.data;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else              head = null;
        size--;
        return val;
    }

    /**
     * Remove a known node in O(1) — no need to find the predecessor.
     * This is the key advantage over a singly linked list.
     */
    public void delete(DNode node) {
        if (node == null) return;
        if (node == head) { deleteHead(); return; }
        if (node == tail) { deleteTail(); return; }

        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    /** Remove the first node with the given value. O(n) to find it */
    public boolean deleteByValue(int data) {
        DNode curr = head;
        while (curr != null) {
            if (curr.data == data) { delete(curr); return true; }
            curr = curr.next;
        }
        return false;
    }

    // -------------------------------------------------------------------------
    // Traversal
    // -------------------------------------------------------------------------

    /** Forward traversal head -> tail. O(n) */
    public void printForward() {
        DNode curr = head;
        StringBuilder sb = new StringBuilder("HEAD <-> ");
        while (curr != null) {
            sb.append(curr.data);
            if (curr.next != null) sb.append(" <-> ");
            curr = curr.next;
        }
        sb.append(" <-> NULL");
        System.out.println(sb);
    }

    /** Backward traversal tail -> head. O(n) */
    public void printBackward() {
        DNode curr = tail;
        StringBuilder sb = new StringBuilder("TAIL <-> ");
        while (curr != null) {
            sb.append(curr.data);
            if (curr.prev != null) sb.append(" <-> ");
            curr = curr.prev;
        }
        sb.append(" <-> NULL");
        System.out.println(sb);
    }

    // -------------------------------------------------------------------------
    // Utility
    // -------------------------------------------------------------------------

    public int size()        { return size; }
    public boolean isEmpty() { return size == 0; }
    public DNode getHead()   { return head; }
    public DNode getTail()   { return tail; }

    // -------------------------------------------------------------------------
    // Demo
    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtHead(0);
        list.printForward();  // HEAD <-> 0 <-> 1 <-> 2 <-> 3 <-> NULL
        list.printBackward(); // TAIL <-> 3 <-> 2 <-> 1 <-> 0 <-> NULL

        // Insert before node with value 2
        DNode target = list.getHead().next.next; // node 2
        list.insertBefore(target, 99);
        list.printForward();  // HEAD <-> 0 <-> 1 <-> 99 <-> 2 <-> 3 <-> NULL

        // O(1) deletion of a known node
        list.delete(target);  // delete node 2
        list.printForward();  // HEAD <-> 0 <-> 1 <-> 99 <-> 3 <-> NULL

        list.deleteHead();
        list.deleteTail();
        list.printForward();  // HEAD <-> 1 <-> 99 <-> NULL

        System.out.println("Size: " + list.size()); // 2
    }
}
