package dsa.trees.practice;

import dsa.trees.Node;

/**
 * LeetCode 230 — Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 *
 * Given the root of a BST and an integer k, return the k-th smallest value.
 *
 * Example 1:
 *     3
 *    / \
 *   1   4
 *    \
 *     2
 *   k = 1  →  Output: 1
 *
 * Example 2:
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *   k = 3  →  Output: 3
 *
 * Constraints:
 *   - 1 <= k <= number of nodes <= 10^4
 *   - 0 <= Node.val <= 10^4
 *
 * Hint: Inorder traversal of a BST visits nodes in ascending sorted order.
 *       The k-th node visited in inorder is the k-th smallest.
 *       You can stop early once you have visited k nodes.
 */
public class KthSmallestInBST {

    public int kthSmallest(Node root, int k) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        KthSmallestInBST solution = new KthSmallestInBST();

        Node tree1 = new Node(3, new Node(1, null, new Node(2)), new Node(4));
        System.out.println(solution.kthSmallest(tree1, 1)); // 1

        Node tree2 = new Node(5,
            new Node(3, new Node(2, new Node(1), null), new Node(4)),
            new Node(6)
        );
        System.out.println(solution.kthSmallest(tree2, 3)); // 3
    }
}
