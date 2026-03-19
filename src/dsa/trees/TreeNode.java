package dsa.trees;

/**
 * https://www.geeksforgeeks.org/dsa/introduction-to-tree-data-structure/
 * A tree is as a hierarchical data structure with nodes
 * Has a root node at the top
 * Each node can have child nodes
 * Each node contains data and references to its child nodes
 * nodes are connected by edges
 * No cycles
 *
 * real world exampl3s
 * - File system (folders and files)
 * - databases
 * - network routing
 * - Family tree
 * Organization Hierarchy
 *
 * How it works
 * - TreeNode - represents each node with value and right and left references
 * Types
 * - BinaryTree - each node has at most two children
 * Full Binary Tree – every node has either 0 or 2 children.
 * Complete Binary Tree – all levels are fully filled except possibly the last, which is filled from left to right.
 * Balanced Binary Tree – height difference between left and right subtrees of every node is minimal.
 * Ternary Tree:
 * Each node can have at most three children, often labeled as left, middle, and right
 */
public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value){
        this.value = value;
        left = null;
        right = null;
    }
}
