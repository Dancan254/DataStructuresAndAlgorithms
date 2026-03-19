package dsa.linked_list.practice;

import dsa.linked_list.ListNode;

/**
 * LeetCode 19 — Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Given the head of a linked list, remove the n-th node from the end
 * and return the head. Do it in one pass.
 *
 * Example 1:
 *   Input:  1 -> 2 -> 3 -> 4 -> 5,  n = 2
 *   Output: 1 -> 2 -> 3 -> 5
 *
 * Example 2:
 *   Input:  [1],  n = 1
 *   Output: []
 *
 * Example 3:
 *   Input:  1 -> 2,  n = 1
 *   Output: [1]
 *
 * Constraints:
 *   - 1 <= number of nodes <= 30
 *   - 1 <= n <= number of nodes (n is always valid)
 *
 * Hint: Use a dummy head node (points to head) so that removing the first node
 *       is handled uniformly.
 *       Advance the fast pointer n+1 steps ahead of slow (both start at dummy).
 *       When fast reaches null, slow is just before the target node.
 *       Then: slow.next = slow.next.next.
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        RemoveNthFromEnd solution = new RemoveNthFromEnd();

        System.out.println(ListNode.toString(
            solution.removeNthFromEnd(ListNode.of(1, 2, 3, 4, 5), 2)
        )); // [1 -> 2 -> 3 -> 5]

        System.out.println(ListNode.toString(
            solution.removeNthFromEnd(ListNode.of(1), 1)
        )); // []

        System.out.println(ListNode.toString(
            solution.removeNthFromEnd(ListNode.of(1, 2), 1)
        )); // [1]
    }
}
