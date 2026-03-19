package dsa.linked_list.practice;

import dsa.linked_list.ListNode;

/**
 * LeetCode 141 — Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * Given the head of a linked list, determine if the list contains a cycle.
 * A cycle exists if some node can be reached again by continuously following next.
 * Must use O(1) memory.
 *
 * Example 1:
 *   Input:  3 -> 2 -> 0 -> -4 -> (back to node at index 1)
 *   Output: true
 *
 * Example 2:
 *   Input:  1 -> 2 -> (back to node at index 0)
 *   Output: true
 *
 * Example 3:
 *   Input:  1
 *   Output: false
 *
 * Constraints:
 *   - 0 <= number of nodes <= 10^4
 *   - -10^5 <= Node.val <= 10^5
 *
 * Hint: Use two pointers — slow moves one step at a time, fast moves two.
 *       If there is a cycle, fast will eventually lap slow and they will meet.
 *       If there is no cycle, fast will reach null.
 *       The loop condition is: fast != null && fast.next != null.
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();

        // No cycle
        System.out.println(solution.hasCycle(ListNode.of(1, 2, 3, 4))); // false

        // Create cycle: 1 -> 2 -> 3 -> 4 -> back to node 2
        ListNode head = ListNode.of(1, 2, 3, 4);
        ListNode cycleEntry = head.next; // node with value 2
        ListNode tail = head;
        while (tail.next != null) tail = tail.next;
        tail.next = cycleEntry; // create the cycle
        System.out.println(solution.hasCycle(head)); // true

        System.out.println(solution.hasCycle(null)); // false
    }
}
