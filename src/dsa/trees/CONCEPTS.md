# Trees

## What Is a Tree?

A tree is a hierarchical data structure consisting of nodes connected by edges,
with no cycles. Every tree has exactly one root node, and every non-root node
has exactly one parent. Trees model hierarchical relationships: file systems,
organisation charts, HTML DOM, compilers, databases.

---

## Terminology

| Term | Definition |
|------|-----------|
| Root | The top node with no parent |
| Leaf | A node with no children |
| Height of a node | Longest path (in edges) from that node to a leaf |
| Height of a tree | Height of the root |
| Depth of a node | Number of edges from root to that node |
| Level | All nodes at the same depth (root is level 0) |
| Degree | Number of children a node has |
| Subtree | A node and all its descendants |
| Ancestor | Any node on the path from root to a given node |
| Descendant | Any node reachable by following children |

---

## 1. Binary Tree

A binary tree is a tree where every node has **at most two children**: left and right.

```java
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}
```

### Types of Binary Trees

**Full Binary Tree:** every node has 0 or 2 children (never 1).

**Complete Binary Tree:** all levels are fully filled except possibly the last,
which is filled from left to right. Heaps are stored as complete binary trees.

**Perfect Binary Tree:** all internal nodes have exactly 2 children and all
leaves are at the same level. A perfect tree of height h has 2^(h+1) - 1 nodes.

**Balanced Binary Tree:** the height difference between the left and right subtree
of every node is at most 1. Height is O(log n). AVL trees and Red-Black trees
maintain balance automatically.

**Degenerate (Skewed) Tree:** every internal node has only one child. Effectively
a linked list. Height is O(n).

```
Full:        Complete:    Perfect:    Degenerate:
    1             1           1           1
   / \           / \         / \           \
  2   3         2   3       2   3            2
 / \             \         / \ / \            \
4   5             4       4  5 6  7             3
```

---

## 2. Binary Tree Traversals

All traversals visit every node exactly once: O(n) time, O(h) space (call stack).

### Depth-First Search (DFS)

**Preorder — root, left, right:**
Use for: tree copying, serialisation, prefix expression evaluation.
```java
void preorder(TreeNode node) {
    if (node == null) return;
    visit(node);                 // root first
    preorder(node.left);
    preorder(node.right);
}
```

**Inorder — left, root, right:**
Use for: BST sorted output, expression tree in-fix form.
```java
void inorder(TreeNode node) {
    if (node == null) return;
    inorder(node.left);
    visit(node);                 // root in the middle
    inorder(node.right);
}
```

**Postorder — left, right, root:**
Use for: deletion, computing subtree values before the parent (e.g., heights, sums).
```java
void postorder(TreeNode node) {
    if (node == null) return;
    postorder(node.left);
    postorder(node.right);
    visit(node);                 // root last
}
```

### Breadth-First Search (BFS) — Level Order

Process nodes level by level using a queue. The key trick: snapshot
`queue.size()` before the inner loop to know how many nodes are on the current level.

```java
Queue<TreeNode> queue = new LinkedList<>();
queue.offer(root);
while (!queue.isEmpty()) {
    int levelSize = queue.size();
    for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.poll();
        visit(node);
        if (node.left  != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
    }
}
```

---

## 3. Binary Search Tree (BST)

A BST enforces an ordering property on every node:
- All values in the **left subtree** are strictly **less than** the node's value.
- All values in the **right subtree** are strictly **greater than** the node's value.
- Both subtrees are themselves valid BSTs.

### Operations

| Operation | Average (balanced) | Worst (skewed) |
|-----------|--------------------|----------------|
| Search | O(log n) | O(n) |
| Insert | O(log n) | O(n) |
| Delete | O(log n) | O(n) |
| Min / Max | O(log n) | O(n) |
| Successor / Predecessor | O(log n) | O(n) |

**Search:**
```java
TreeNode search(TreeNode root, int target) {
    if (root == null || root.val == target) return root;
    if (target < root.val) return search(root.left, target);
    return search(root.right, target);
}
```

**Insert:**
```java
TreeNode insert(TreeNode root, int val) {
    if (root == null) return new TreeNode(val);
    if (val < root.val) root.left  = insert(root.left,  val);
    else if (val > root.val) root.right = insert(root.right, val);
    return root; // val == root.val: duplicate ignored
}
```

**Delete:** Three cases:
1. Node is a leaf — remove it.
2. Node has one child — replace with that child.
3. Node has two children — replace value with inorder successor (smallest
   in right subtree), then delete the successor.

```java
TreeNode delete(TreeNode root, int val) {
    if (root == null) return null;
    if (val < root.val) { root.left  = delete(root.left,  val); }
    else if (val > root.val) { root.right = delete(root.right, val); }
    else {
        if (root.left  == null) return root.right; // case 1 and 2
        if (root.right == null) return root.left;  // case 2
        // Case 3: find inorder successor
        TreeNode successor = root.right;
        while (successor.left != null) successor = successor.left;
        root.val = successor.val;
        root.right = delete(root.right, successor.val);
    }
    return root;
}
```

**Key BST property:** inorder traversal of a BST yields elements in sorted order.

---

## 4. AVL Tree (Self-Balancing BST)

An AVL tree maintains the **balance factor** (left height − right height) at
every node within {−1, 0, +1}. After any insert or delete, rotations restore
balance. This guarantees O(log n) worst-case for all operations.

### Balance Factor

```
balanceFactor(node) = height(node.left) - height(node.right)
```

A node is balanced if its balance factor is in {-1, 0, +1}.

### Rotations

When a node becomes unbalanced (|BF| > 1), one or two rotations fix it.

**Right Rotation** (Left-heavy, Left-Left case):
```
      y                x
     / \              / \
    x   T3    →     T1   y
   / \                  / \
  T1  T2               T2  T3
```

**Left Rotation** (Right-heavy, Right-Right case):
```
    x                  y
   / \                / \
  T1   y     →       x   T3
      / \           / \
     T2  T3        T1  T2
```

**Left-Right Rotation:** Left rotate on left child, then right rotate on root.
**Right-Left Rotation:** Right rotate on right child, then left rotate on root.

---

## 5. Red-Black Tree

Another self-balancing BST. Each node is coloured Red or Black, and a set of
rules ensures the tree remains approximately balanced (height ≤ 2 log n):

1. Every node is Red or Black.
2. The root is Black.
3. Every leaf (null sentinel) is Black.
4. Red nodes have only Black children.
5. All paths from any node to its descendant leaves have the same number of Black nodes.

Java's `TreeMap` and `TreeSet` are implemented as Red-Black trees.
Preferred over AVL in practice because rebalancing requires fewer rotations on
write-heavy workloads.

---

## 6. Trie (Prefix Tree)

A trie stores strings character by character. Each node has up to 26 children
(for lowercase letters) and a boolean marking end-of-word. Provides O(k) insert
and search where k is the word length, regardless of dictionary size.

```
Insert "cat", "car", "card", "care", "bat":

root
├── c
│   └── a
│       ├── t  [end]
│       └── r  [end]
│           ├── d  [end]
│           └── e  [end]
└── b
    └── a
        └── t  [end]
```

```java
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class Trie {
    TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) curr.children[i] = new TrieNode();
            curr = curr.children[i];
        }
        curr.isEnd = true;
    }

    boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.isEnd;
    }

    boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }

    private TrieNode findNode(String s) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) return null;
            curr = curr.children[i];
        }
        return curr;
    }
}
```

| Operation | Time | Space |
|-----------|------|-------|
| Insert | O(k) | O(k) new nodes |
| Search | O(k) | O(1) |
| startsWith | O(k) | O(1) |
| Total space | — | O(ALPHABET × N × K) |

---

## 7. Complexity Summary

| Structure | Search | Insert | Delete | Space |
|-----------|--------|--------|--------|-------|
| Unbalanced BST | O(h) | O(h) | O(h) | O(n) |
| Balanced BST (AVL, RB) | O(log n) | O(log n) | O(log n) | O(n) |
| Trie (k = word length) | O(k) | O(k) | O(k) | O(26×n×k) |
| Tree traversal (any) | O(n) | — | — | O(h) stack |

---

## Common Mistakes

- Using `int` bounds in BST validation — node values at `Integer.MIN_VALUE` or
  `Integer.MAX_VALUE` cause incorrect comparisons. Use `long` bounds.
- In BFS, not snapshotting `queue.size()` before the inner loop — the size changes
  as you enqueue children within the same level.
- Confusing height (edges to furthest leaf) with depth (edges from root).
- In BST deletion with two children, replacing with the inorder successor means
  finding the minimum in the right subtree — not the maximum in the left.
- Forgetting that the null base case must be the first line of every DFS function.
