package dsa.trees.practice;

import dsa.trees.Node;

/**
 * LeetCode 124 — Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * A path in a binary tree is a sequence of nodes where each pair of adjacent
 * nodes has an edge, and each node appears at most once. The path does not
 * need to pass through the root.
 *
 * Return the maximum sum of any path in the tree.
 *
 * Example 1:
 *     1
 *    / \
 *   2   3
 *   Output: 6   (2 -> 1 -> 3)
 *
 * Example 2:
 *       -10
 *       /  \
 *      9   20
 *          / \
 *         15   7
 *   Output: 42  (15 -> 20 -> 7)
 *
 * Constraints:
 *   - 1 <= number of nodes <= 3 * 10^4
 *   - -1000 <= Node.val <= 1000
 *
 * Hint: At each node, the maximum path through it uses both its left and right
 *       subtrees: node.val + max(leftGain, 0) + max(rightGain, 0).
 *       But when returning to the parent, you can only use ONE branch.
 *       Use a global variable to track the overall maximum.
 *       Use Math.max(gain, 0) to ignore negative-sum subtrees.
 */
public class BinaryTreeMaxPathSum {

    public int maxPathSum(Node root) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        BinaryTreeMaxPathSum solution = new BinaryTreeMaxPathSum();

        Node tree1 = new Node(1, new Node(2), new Node(3));
        System.out.println(solution.maxPathSum(tree1)); // 6

        Node tree2 = new Node(-10,
            new Node(9),
            new Node(20, new Node(15), new Node(7))
        );
        System.out.println(solution.maxPathSum(tree2)); // 42

        Node tree3 = new Node(-3);
        System.out.println(solution.maxPathSum(tree3)); // -3 (must include at least one node)
    }
}
