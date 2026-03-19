package dsa.trees.practice;

import dsa.trees.Node;

/**
 * LeetCode 226 — Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * Given the root of a binary tree, invert the tree (mirror it), and return its root.
 *
 * Example:
 *   Input:
 *         4
 *        / \
 *       2   7
 *      / \ / \
 *     1  3 6  9
 *
 *   Output:
 *         4
 *        / \
 *       7   2
 *      / \ / \
 *     9  6 3  1
 *
 * Constraints:
 *   - 0 <= number of nodes <= 100
 *   - -100 <= Node.val <= 100
 *
 * Hint: Recursion is natural here. To invert a tree rooted at node:
 *       1. Swap node.left and node.right.
 *       2. Recursively invert the left subtree.
 *       3. Recursively invert the right subtree.
 *       Base case: if node is null, return null.
 */
public class InvertBinaryTree {

    public Node invertTree(Node root) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        InvertBinaryTree solution = new InvertBinaryTree();

        //       4
        //      / \
        //     2   7
        //    / \ / \
        //   1  3 6  9
        Node root = new Node(4,
            new Node(2, new Node(1), new Node(3)),
            new Node(7, new Node(6), new Node(9))
        );

        Node inverted = solution.invertTree(root);

        // Expected inorder of inverted: 9, 7, 6, 4, 3, 2, 1
        printInorder(inverted);
        System.out.println();

        System.out.println(solution.invertTree(null)); // null
    }

    private static void printInorder(Node node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}
