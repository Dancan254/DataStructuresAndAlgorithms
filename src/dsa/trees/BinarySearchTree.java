package dsa.trees;

/**
 * Each node has at most 2 children
 * Full Binary Tree – every node has either 0 or 2 children.
 * Complete Binary Tree – all levels are fully filled except possibly the last, which is filled from left to right.
 * Balanced Binary Tree – height difference between left and right subtrees of every node is minimal.
 * Basic operations take time proportional to the height of the tree
 * for a complete binary tree with n nodes, height = log n -> O(log n) worst case tome
 *
 * contains
 *         - insert() - add nodes level-by-level
 *         - inorder() - left - root - right
 *         - preorder() - root - left - right
 *         - postorder() - left - right - root
 *         - search() - finds a value in the tree
 * Besides the SEARCH operation, binary search trees can support such queries as MINIMUM,
 * MAXIMUM, SUCCESSOR, and PREDECESSOR
 */
public class BinarySearchTree {
    TreeNode root;

    public TreeNode search(TreeNode node, int value){
        while(node != null && node.value != value){
            if(value < node.value){
                node = node.left;
            }
            else{
                node = node.right;
            }
        }
        return node;
    }

    public TreeNode searchRecursive(TreeNode node, int value){
        if(node == null || node.value == value){
            return node;
        }
        if(value < node.value){
            return searchRecursive(node.left, value);
        } else{
            return search(node.right, value);
        }
    }

    public TreeNode  minimum(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    public TreeNode maximum(TreeNode node){
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}
