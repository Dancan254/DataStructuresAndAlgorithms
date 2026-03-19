package dsa.linked_list;

/**
 * Standard singly linked list node used across all linked list problems.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) { this.val = val; }

    /** Convenience: build a list from an array and return its head. */
    public static ListNode of(int... vals) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int v : vals) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }

    /** Print the list as [1 -> 2 -> 3 -> null]. */
    public static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(" -> ");
            head = head.next;
        }
        return sb.append("]").toString();
    }
}
