package dsa.trees.practice;

import dsa.trees.Node;

/**
 * LeetCode 235 — Lowest Common Ancestor of a Binary Search Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * Given a BST and two nodes p and q, find their lowest common ancestor (LCA).
 * The LCA is the deepest node that has both p and q as descendants.
 * A node is a descendant of itself.
 *
 * Example 1:
 *         6
 *        / \
 *       2   8
 *      / \ / \
 *     0  4 7  9
 *       / \
 *      3   5
 *   p = 2, q = 8  →  Output: 6
 *   p = 2, q = 4  →  Output: 2
 *
 * Constraints:
 *   - 2 <= number of nodes <= 10^5
 *   - All node values are unique
 *   - p != q, and both p and q exist in the tree
 *
 * Hint: Use the BST ordering property — no DFS over every node needed.
 *       If both p and q are less than root, the LCA is in the left subtree.
 *       If both are greater, the LCA is in the right subtree.
 *       Otherwise, root itself is the LCA (they are on different sides, or one equals root).
 */
public class LowestCommonAncestor {

    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        LowestCommonAncestor solution = new LowestCommonAncestor();

        Node n0 = new Node(0);
        Node n3 = new Node(3);
        Node n5 = new Node(5);
        Node n4 = new Node(4, n3, n5);
        Node n2 = new Node(2, n0, n4);
        Node n7 = new Node(7);
        Node n9 = new Node(9);
        Node n8 = new Node(8, n7, n9);
        Node root = new Node(6, n2, n8);

        System.out.println(solution.lowestCommonAncestor(root, n2, n8).val); // 6
        System.out.println(solution.lowestCommonAncestor(root, n2, n4).val); // 2
    }
}
