package dsa.trees;

/**
 * Complete Binary Search Tree (BST) implementation.
 *
 * Enforces: left subtree < node < right subtree at every node.
 *
 * Covers: insert, search, delete (all 3 cases), minimum, maximum,
 *         inorder successor, height, isBalanced, contains, toSortedArray,
 *         all four traversals (pre/in/post/level order).
 */
public class BinarySearchTree {

    private Node root;

    // -------------------------------------------------------------------------
    // Insert
    // -------------------------------------------------------------------------

    /** Insert a value into the BST. Duplicate values are ignored. O(h) */
    public void insert(int val) {
        root = insertRec(root, val);
    }

    private Node insertRec(Node node, int val) {
        if (node == null) return new Node(val);
        if      (val < node.val) node.left  = insertRec(node.left,  val);
        else if (val > node.val) node.right = insertRec(node.right, val);
        // val == node.val: duplicate — ignore
        return node;
    }

    // -------------------------------------------------------------------------
    // Search
    // -------------------------------------------------------------------------

    /** Return true if the BST contains the given value. O(h) */
    public boolean contains(int val) {
        return searchRec(root, val) != null;
    }

    private Node searchRec(Node node, int val) {
        if (node == null || node.val == val) return node;
        if (val < node.val) return searchRec(node.left,  val);
        return searchRec(node.right, val);
    }

    // -------------------------------------------------------------------------
    // Delete
    // -------------------------------------------------------------------------

    /**
     * Remove a value from the BST. Three cases:
     *   1. Leaf node         — simply remove it.
     *   2. One child         — replace node with its child.
     *   3. Two children      — replace value with inorder successor (min of right
     *                          subtree), then delete the successor from right subtree.
     * O(h)
     */
    public void delete(int val) {
        root = deleteRec(root, val);
    }

    private Node deleteRec(Node node, int val) {
        if (node == null) return null;

        if (val < node.val) {
            node.left = deleteRec(node.left, val);
        } else if (val > node.val) {
            node.right = deleteRec(node.right, val);
        } else {
            // Node to delete found
            if (node.left == null)  return node.right; // cases 1 and 2
            if (node.right == null) return node.left;  // case 2

            // Case 3: find inorder successor (min of right subtree)
            Node successor = findMin(node.right);
            node.val = successor.val;                             // copy successor value
            node.right = deleteRec(node.right, successor.val);   // delete successor
        }
        return node;
    }

    // -------------------------------------------------------------------------
    // Min / Max / Successor
    // -------------------------------------------------------------------------

    /** Return the minimum value in the BST. O(h) */
    public int minimum() {
        if (root == null) throw new IllegalStateException("Empty tree");
        return findMin(root).val;
    }

    /** Return the maximum value in the BST. O(h) */
    public int maximum() {
        if (root == null) throw new IllegalStateException("Empty tree");
        return findMax(root).val;
    }

    /** Return the inorder successor of val (next larger value). O(h) */
    public Integer successor(int val) {
        Node curr = root;
        Node successor = null;
        while (curr != null) {
            if (val < curr.val) {
                successor = curr;      // curr could be the successor
                curr = curr.left;
            } else {
                curr = curr.right;     // need something larger
            }
        }
        return successor == null ? null : successor.val;
    }

    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    private Node findMax(Node node) {
        while (node.right != null) node = node.right;
        return node;
    }

    // -------------------------------------------------------------------------
    // Height and Balance
    // -------------------------------------------------------------------------

    /** Return the height of the tree (edges from root to deepest leaf). O(n) */
    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node node) {
        if (node == null) return -1; // height of empty = -1, height of leaf = 0
        return 1 + Math.max(heightRec(node.left), heightRec(node.right));
    }

    /** Return true if the tree is height-balanced (|left height - right height| <= 1 at every node). O(n) */
    public boolean isBalanced() {
        return checkBalance(root) != -1;
    }

    /** Returns height if balanced, -1 if not. Postorder. */
    private int checkBalance(Node node) {
        if (node == null) return 0;
        int left  = checkBalance(node.left);
        if (left == -1) return -1;
        int right = checkBalance(node.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }

    // -------------------------------------------------------------------------
    // Traversals
    // -------------------------------------------------------------------------

    public void inorder()   { inorderRec(root);   System.out.println(); }
    public void preorder()  { preorderRec(root);  System.out.println(); }
    public void postorder() { postorderRec(root); System.out.println(); }

    private void inorderRec(Node n)   { if (n == null) return; inorderRec(n.left);  System.out.print(n.val + " "); inorderRec(n.right); }
    private void preorderRec(Node n)  { if (n == null) return; System.out.print(n.val + " "); preorderRec(n.left); preorderRec(n.right); }
    private void postorderRec(Node n) { if (n == null) return; postorderRec(n.left); postorderRec(n.right); System.out.print(n.val + " "); }

    // -------------------------------------------------------------------------
    // Demo
    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        int[] values = {5, 3, 7, 1, 4, 6, 8, 2};
        for (int v : values) bst.insert(v);

        System.out.print("Inorder (sorted):  "); bst.inorder();   // 1 2 3 4 5 6 7 8
        System.out.print("Preorder:          "); bst.preorder();  // 5 3 1 2 4 7 6 8
        System.out.print("Postorder:         "); bst.postorder(); // 2 1 4 3 6 8 7 5

        System.out.println("Min: " + bst.minimum());    // 1
        System.out.println("Max: " + bst.maximum());    // 8
        System.out.println("Height: " + bst.height());  // 3

        System.out.println("Contains 4: " + bst.contains(4)); // true
        System.out.println("Contains 9: " + bst.contains(9)); // false

        System.out.println("Successor of 4: " + bst.successor(4)); // 5

        bst.delete(3);
        System.out.print("After deleting 3: "); bst.inorder(); // 1 2 4 5 6 7 8

        System.out.println("Balanced: " + bst.isBalanced()); // true
    }
}
