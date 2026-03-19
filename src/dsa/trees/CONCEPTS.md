# Trees

## Overview

A binary tree is a hierarchical structure where each node has at most two children
(left and right). Trees appear in a large fraction of interview problems — from
simple traversals to complex path-sum and serialisation challenges.

```java
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}
```

---

## Tree Traversals

All four traversals visit every node exactly once: O(n) time, O(h) space
where h is the tree height (O(log n) balanced, O(n) skewed).

### Depth-First Search (DFS)

**Preorder** (root → left → right): used for tree copying, serialisation.
**Inorder** (left → root → right): produces sorted output for BSTs.
**Postorder** (left → right → root): used for deletion, evaluating subtrees.

```java
void preorder(TreeNode node) {
    if (node == null) return;
    process(node.val);       // root first
    preorder(node.left);
    preorder(node.right);
}

void inorder(TreeNode node) {
    if (node == null) return;
    inorder(node.left);
    process(node.val);       // root between children
    inorder(node.right);
}

void postorder(TreeNode node) {
    if (node == null) return;
    postorder(node.left);
    postorder(node.right);
    process(node.val);       // root last
}
```

### Breadth-First Search (BFS) — Level Order

Use a queue. Process nodes level by level.

```java
List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
        int levelSize = queue.size(); // number of nodes at current level
        List<Integer> level = new ArrayList<>();
        for (int i = 0; i < levelSize; i++) {
            TreeNode node = queue.poll();
            level.add(node.val);
            if (node.left  != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        result.add(level);
    }
    return result;
}
```

---

## Pattern 1: Simple Recursive DFS

Many tree problems reduce to: compute something for a node given the results
from its left and right subtrees.

**Example — Maximum Depth (LeetCode 104):**
```java
public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
}
```

**Example — Invert Binary Tree (LeetCode 226):**
```java
public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    TreeNode tmp = root.left;
    root.left  = invertTree(root.right);
    root.right = invertTree(tmp);
    return root;
}
```

---

## Pattern 2: Same Tree / Subtree Check

Compare two trees structurally and by value.

**Example — Same Tree (LeetCode 100):**
```java
public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;
    return p.val == q.val
        && isSameTree(p.left,  q.left)
        && isSameTree(p.right, q.right);
}
```

**Subtree of Another Tree (LeetCode 572):**
At every node of the main tree, check if the subtree rooted there equals `subRoot`.

---

## Pattern 3: BST Properties

In a valid BST, every node's value is strictly greater than all values in its
left subtree and strictly less than all values in its right subtree.

**Validate BST (LeetCode 98):** Pass min/max bounds down the recursion.

```java
// O(n) time, O(h) space
public boolean isValidBST(TreeNode root) {
    return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
}

private boolean validate(TreeNode node, long min, long max) {
    if (node == null) return true;
    if (node.val <= min || node.val >= max) return false;
    return validate(node.left,  min,      node.val)
        && validate(node.right, node.val, max);
}
```

**Kth Smallest in BST (LeetCode 230):** Inorder traversal of a BST visits
nodes in sorted order. Stop at the k-th node.

```java
private int count = 0, result = 0;

public int kthSmallest(TreeNode root, int k) {
    inorder(root, k);
    return result;
}

private void inorder(TreeNode node, int k) {
    if (node == null) return;
    inorder(node.left, k);
    if (++count == k) { result = node.val; return; }
    inorder(node.right, k);
}
```

---

## Pattern 4: Lowest Common Ancestor (LCA)

**LCA of BST (LeetCode 235):** Use BST ordering — if both p and q are less than
the current node, the LCA is in the left subtree; if both are greater, in the
right; otherwise the current node is the LCA.

```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left,  p, q);
    if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
    return root; // one is in each subtree, or one equals root
}
```

---

## Pattern 5: Path Sum Problems

Accumulate or compare values along root-to-leaf (or any) paths.

**Binary Tree Maximum Path Sum (LeetCode 124):**
A path can start and end at any node. At each node, the maximum contribution
to a parent path is `node.val + max(left gain, right gain, 0)`.
Track the global maximum as the best complete path through each node.

```java
private int globalMax = Integer.MIN_VALUE;

public int maxPathSum(TreeNode root) {
    gain(root);
    return globalMax;
}

private int gain(TreeNode node) {
    if (node == null) return 0;
    int leftGain  = Math.max(gain(node.left),  0);
    int rightGain = Math.max(gain(node.right), 0);
    globalMax = Math.max(globalMax, node.val + leftGain + rightGain);
    return node.val + Math.max(leftGain, rightGain); // only one branch to parent
}
```

---

## Pattern 6: Trie (Prefix Tree)

A trie stores strings character by character. Each node has up to 26 children
(for lowercase letters) and a boolean marking end-of-word.

```java
class Trie {
    private TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            curr.children.computeIfAbsent(c, k -> new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private TrieNode find(String s) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            if (!curr.children.containsKey(c)) return null;
            curr = curr.children.get(c);
        }
        return curr;
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd = false;
}
```

---

## Complexity Summary

| Operation | Balanced BST | Skewed BST |
|-----------|-------------|------------|
| Search / Insert / Delete | O(log n) | O(n) |
| Traversal | O(n) | O(n) |
| BFS level order | O(n) | O(n) |
| Trie insert / search | O(k) | — k = word length |

---

## Common Mistakes

- Not handling the `null` base case at the start of every recursive function.
- Using `int` bounds in BST validation — duplicate or boundary values like
  `Integer.MIN_VALUE` can cause incorrect results. Use `long` or `Long`.
- In BFS, not recording `queue.size()` before the inner loop — the size changes
  as you enqueue children.
- In path sum problems, forgetting that a path through a node uses at most one
  of its two subtrees when contributing to a parent (not both).
