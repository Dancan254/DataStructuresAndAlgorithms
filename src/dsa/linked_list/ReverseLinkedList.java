package dsa.linked_list;

/**
 * LeetCode 206 — Reverse Linked List
 *
 * Reverse a singly linked list in-place.
 *
 * Pattern: Iterative pointer reversal
 *
 * Maintain prev (initially null) and curr (initially head).
 * At each step: save curr.next, redirect curr.next to prev, advance both.
 * When curr is null, prev is the new head.
 *
 * Time:  O(n)
 * Space: O(1) iterative / O(n) recursive (call stack)
 */
public class ReverseLinkedList {

    // Iterative — preferred for its O(1) space
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode next = curr.next; // save forward link before overwriting
            curr.next = prev;          // reverse
            prev = curr;
            curr = next;
        }

        return prev; // new head
    }

    // Recursive — elegant but O(n) stack space
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head; // node after head now points back to head
        head.next = null;
        return newHead;
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();

        ListNode list = ListNode.of(1, 2, 3, 4, 5);
        System.out.println(ListNode.toString(solution.reverseList(list)));          // [5 -> 4 -> 3 -> 2 -> 1]

        ListNode list2 = ListNode.of(1, 2);
        System.out.println(ListNode.toString(solution.reverseListRecursive(list2))); // [2 -> 1]
    }
}
