package dsa.linked_list;

/**
 * LeetCode 21 — Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return the sorted merged list.
 *
 * Pattern: Dummy head + two-pointer merge
 *
 * A dummy head node eliminates special-casing the first insertion.
 * Advance curr.next to the smaller of l1/l2 at each step.
 * Attach the non-exhausted list at the end.
 *
 * Time:  O(n + m)
 * Space: O(1)
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // Attach whichever list still has remaining nodes
        curr.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();

        ListNode l1 = ListNode.of(1, 2, 4);
        ListNode l2 = ListNode.of(1, 3, 4);
        System.out.println(ListNode.toString(solution.mergeTwoLists(l1, l2)));
        // [1 -> 1 -> 2 -> 3 -> 4 -> 4]

        System.out.println(ListNode.toString(solution.mergeTwoLists(null, null)));
        // []
    }
}
