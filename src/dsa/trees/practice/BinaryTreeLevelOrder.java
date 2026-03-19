package dsa.trees.practice;

import dsa.trees.Node;
import java.util.List;

/**
 * LeetCode 102 — Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * Given the root of a binary tree, return the level-order traversal of its
 * nodes' values as a list of lists (one list per level, left to right).
 *
 * Example:
 *       3
 *      / \
 *     9  20
 *        / \
 *       15   7
 *   Output: [[3], [9, 20], [15, 7]]
 *
 * Constraints:
 *   - 0 <= number of nodes <= 2000
 *   - -1000 <= Node.val <= 1000
 *
 * Hint: Use a Queue (BFS). The trick for grouping by level is to snapshot
 *       queue.size() before the inner loop — that tells you how many nodes
 *       are on the current level. Process exactly that many nodes, then
 *       add them to a level list before moving to the next level.
 */
public class BinaryTreeLevelOrder {

    public List<List<Integer>> levelOrder(Node root) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        BinaryTreeLevelOrder solution = new BinaryTreeLevelOrder();

        Node tree1 = new Node(3,
            new Node(9),
            new Node(20, new Node(15), new Node(7))
        );
        System.out.println(solution.levelOrder(tree1)); // [[3], [9, 20], [15, 7]]

        System.out.println(solution.levelOrder(new Node(1))); // [[1]]

        System.out.println(solution.levelOrder(null)); // []
    }
}
