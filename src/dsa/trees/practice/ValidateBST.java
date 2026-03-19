package dsa.trees.practice;

import dsa.trees.Node;

/**
 * LeetCode 98 — Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Determine if a binary tree is a valid BST.
 * A valid BST: every node in the left subtree is strictly less than the node,
 * every node in the right subtree is strictly greater.
 *
 * Example 1:
 *     2
 *    / \
 *   1   3
 *   Output: true
 *
 * Example 2:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *   Output: false  (4 is in the right subtree of 5, but 4 < 5)
 *
 * Constraints:
 *   - 0 <= number of nodes <= 10^4
 *   - -2^31 <= Node.val <= 2^31 - 1
 *
 * Hint: A simple left < root < right check is not enough — a node must be
 *       within bounds set by ALL its ancestors, not just its parent.
 *       Pass min and max bounds down the recursion.
 *       Use long (not int) for the bounds to handle Integer.MIN_VALUE and MAX_VALUE.
 */
public class ValidateBST {

    public boolean isValidBST(Node root) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        ValidateBST solution = new ValidateBST();

        Node valid = new Node(2, new Node(1), new Node(3));
        System.out.println(solution.isValidBST(valid)); // true

        Node invalid = new Node(5, new Node(1), new Node(4, new Node(3), new Node(6)));
        System.out.println(solution.isValidBST(invalid)); // false

        // Edge case: single node
        System.out.println(solution.isValidBST(new Node(1))); // true

        // Edge case: root value equals Integer.MIN_VALUE
        System.out.println(solution.isValidBST(new Node(Integer.MIN_VALUE))); // true
    }
}
