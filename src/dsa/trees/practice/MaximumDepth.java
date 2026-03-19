package dsa.trees.practice;

import dsa.trees.Node;

/**
 * LeetCode 104 — Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * Given the root of a binary tree, return its maximum depth.
 * Maximum depth = number of nodes along the longest path from root to a leaf.
 *
 * Example 1:
 *       3
 *      / \
 *     9  20
 *        / \
 *       15   7
 *   Output: 3
 *
 * Example 2:
 *   Input:  [1, null, 2]
 *   Output: 2
 *
 * Constraints:
 *   - 0 <= number of nodes <= 10^4
 *   - -100 <= Node.val <= 100
 *
 * Hint: The depth of a node is 1 + the maximum depth of its two subtrees.
 *       The depth of null is 0.
 *       This is a single recursive call — one of the shortest tree solutions.
 */
public class MaximumDepth {

    public int maxDepth(Node root) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        MaximumDepth solution = new MaximumDepth();

        Node tree1 = new Node(3,
            new Node(9),
            new Node(20, new Node(15), new Node(7))
        );
        System.out.println(solution.maxDepth(tree1)); // 3

        Node tree2 = new Node(1, null, new Node(2));
        System.out.println(solution.maxDepth(tree2)); // 2

        System.out.println(solution.maxDepth(null)); // 0
    }
}
