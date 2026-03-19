package dsa.linked_list.practice;

import dsa.linked_list.ListNode;

/**
 * LeetCode 143 — Reorder List
 * https://leetcode.com/problems/reorder-list/
 *
 * Reorder the list from L0->L1->...->Ln to L0->Ln->L1->Ln-1->L2->Ln-2->...
 * Modify the list in-place. Do not return anything.
 *
 * Example 1:
 *   Input:  1 -> 2 -> 3 -> 4
 *   Output: 1 -> 4 -> 2 -> 3
 *
 * Example 2:
 *   Input:  1 -> 2 -> 3 -> 4 -> 5
 *   Output: 1 -> 5 -> 2 -> 4 -> 3
 *
 * Constraints:
 *   - 1 <= number of nodes <= 5 * 10^4
 *   - 1 <= Node.val <= 1000
 *
 * Hint: This problem has three distinct steps:
 *   1. Find the middle of the list using fast/slow pointers.
 *   2. Reverse the second half of the list.
 *   3. Merge the two halves by alternating nodes.
 *   Implement each step separately and test before combining.
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        ReorderList solution = new ReorderList();

        ListNode list1 = ListNode.of(1, 2, 3, 4);
        solution.reorderList(list1);
        System.out.println(ListNode.toString(list1)); // [1 -> 4 -> 2 -> 3]

        ListNode list2 = ListNode.of(1, 2, 3, 4, 5);
        solution.reorderList(list2);
        System.out.println(ListNode.toString(list2)); // [1 -> 5 -> 2 -> 4 -> 3]
    }
}
