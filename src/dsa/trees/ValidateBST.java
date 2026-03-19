package dsa.trees;

/**
 * LeetCode 98 — Validate Binary Search Tree
 *
 * Determine if a binary tree is a valid BST.
 * A valid BST: left subtree values < node.val < right subtree values, recursively.
 *
 * Pattern: DFS with min/max bounds
 *
 * Pass valid range [min, max] to each node. A node violates the BST property
 * if its value is outside this range. Use long to avoid edge cases with
 * Integer.MIN_VALUE and Integer.MAX_VALUE as node values.
 *
 * Time:  O(n)
 * Space: O(h) — recursion stack, h = tree height
 */
public class ValidateBST {

    public boolean isValidBST(Node root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(Node node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;

        return validate(node.left,  min,      node.val)
            && validate(node.right, node.val, max);
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        ValidateBST solution = new ValidateBST();

        //     2
        //    / \
        //   1   3
        Node valid = new Node(2, new Node(1), new Node(3));
        System.out.println(solution.isValidBST(valid)); // true

        //     5
        //    / \
        //   1   4
        //      / \
        //     3   6
        Node invalid = new Node(5, new Node(1), new Node(4, new Node(3), new Node(6)));
        System.out.println(solution.isValidBST(invalid)); // false (4 < 5)
    }
}
