package dsa.trees;

import java.util.*;

/**
 * Core tree traversal patterns: DFS (pre/in/post-order) and BFS (level order).
 *
 * These are the building blocks for almost every tree problem. Understand
 * when to use each order before moving on to more complex tree problems.
 *
 * Time:  O(n) for all traversals
 * Space: O(h) for DFS (h = height), O(n) worst case for BFS queue
 */
public class TreeTraversals {

    // --- DFS: Preorder (root, left, right) -----------------------------------

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private void preorderHelper(Node node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);            // root first
        preorderHelper(node.left,  result);
        preorderHelper(node.right, result);
    }

    // --- DFS: Inorder (left, root, right) — sorted for BST ------------------

    public List<Integer> inorder(Node root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(Node node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);
        result.add(node.val);            // root between children
        inorderHelper(node.right, result);
    }

    // --- DFS: Postorder (left, right, root) ----------------------------------

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private void postorderHelper(Node node, List<Integer> result) {
        if (node == null) return;
        postorderHelper(node.left,  result);
        postorderHelper(node.right, result);
        result.add(node.val);            // root last
    }

    // --- BFS: Level Order ----------------------------------------------------

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // snapshot size before enqueuing children
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                level.add(node.val);
                if (node.left  != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        Node root = new Node(1,
                new Node(2, new Node(4), new Node(5)),
                new Node(3));

        TreeTraversals t = new TreeTraversals();
        System.out.println("Preorder:    " + t.preorder(root));    // [1, 2, 4, 5, 3]
        System.out.println("Inorder:     " + t.inorder(root));     // [4, 2, 5, 1, 3]
        System.out.println("Postorder:   " + t.postorder(root));   // [4, 5, 2, 3, 1]
        System.out.println("Level order: " + t.levelOrder(root));  // [[1], [2, 3], [4, 5]]
    }
}
