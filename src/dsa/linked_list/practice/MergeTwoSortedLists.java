package dsa.linked_list.practice;

import dsa.linked_list.ListNode;

/**
 * LeetCode 21 — Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * Merge two sorted linked lists and return the head of the merged sorted list.
 *
 * Example 1:
 *   Input:  1->2->4,  1->3->4
 *   Output: 1->1->2->3->4->4
 *
 * Example 2:
 *   Input:  [],  []
 *   Output: []
 *
 * Example 3:
 *   Input:  [],  [0]
 *   Output: [0]
 *
 * Constraints:
 *   - 0 <= number of nodes in each list <= 100
 *   - -100 <= Node.val <= 100
 *
 * Hint: Create a dummy head node — this eliminates special-casing the first node.
 *       At each step, attach the smaller of the two current nodes, then advance
 *       that list's pointer. After the loop, attach whichever list still has nodes.
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();

        System.out.println(ListNode.toString(
            solution.mergeTwoLists(ListNode.of(1, 2, 4), ListNode.of(1, 3, 4))
        )); // [1 -> 1 -> 2 -> 3 -> 4 -> 4]

        System.out.println(ListNode.toString(
            solution.mergeTwoLists(null, null)
        )); // []

        System.out.println(ListNode.toString(
            solution.mergeTwoLists(null, ListNode.of(0))
        )); // [0]
    }
}
