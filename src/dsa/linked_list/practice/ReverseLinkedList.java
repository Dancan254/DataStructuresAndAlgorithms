package dsa.linked_list.practice;

import dsa.linked_list.ListNode;

/**
 * LeetCode 206 — Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Reverse a singly linked list and return the new head.
 *
 * Example:
 *   Input:  1 -> 2 -> 3 -> 4 -> 5
 *   Output: 5 -> 4 -> 3 -> 2 -> 1
 *
 * Constraints:
 *   - 0 <= number of nodes <= 5000
 *   - -5000 <= Node.val <= 5000
 *
 * Hint: You need three pointers: prev (starts null), curr (starts at head),
 *       and a temporary next pointer.
 *       At each step: save curr.next, redirect curr.next to prev, advance both.
 *       When curr is null, prev is the new head.
 *
 *       Try the iterative approach first, then attempt the recursive version.
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();

        ListNode list1 = ListNode.of(1, 2, 3, 4, 5);
        System.out.println(ListNode.toString(solution.reverseList(list1)));
        // [5 -> 4 -> 3 -> 2 -> 1]

        ListNode list2 = ListNode.of(1, 2);
        System.out.println(ListNode.toString(solution.reverseList(list2)));
        // [2 -> 1]

        System.out.println(ListNode.toString(solution.reverseList(null)));
        // []
    }
}
