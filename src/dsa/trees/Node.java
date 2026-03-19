package dsa.trees;

/**
 * Binary tree node for interview-style problems.
 * Uses the standard LeetCode field name `val` for direct compatibility.
 */
public class Node {
    public int val;
    public Node left, right;

    public Node(int val) { this.val = val; }
    public Node(int val, Node left, Node right) {
        this.val   = val;
        this.left  = left;
        this.right = right;
    }
}
