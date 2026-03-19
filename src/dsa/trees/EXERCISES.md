# Trees — Exercises

---

## Easy

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 1 | Invert Binary Tree | [226](https://leetcode.com/problems/invert-binary-tree/) | Yes | Recursive DFS — swap children at each node |
| 2 | Maximum Depth of Binary Tree | [104](https://leetcode.com/problems/maximum-depth-of-binary-tree/) | Yes | 1 + max(left depth, right depth) |
| 3 | Diameter of Binary Tree | [543](https://leetcode.com/problems/diameter-of-binary-tree/) | No | Max of (left height + right height) at any node |
| 4 | Balanced Binary Tree | [110](https://leetcode.com/problems/balanced-binary-tree/) | No | Height DFS — return -1 if unbalanced |
| 5 | Same Tree | [100](https://leetcode.com/problems/same-tree/) | Yes | Structural + value equality recursion |
| 6 | Subtree of Another Tree | [572](https://leetcode.com/problems/subtree-of-another-tree/) | Yes | isSameTree at every node |

## Medium

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 7 | Binary Tree Level Order Traversal | [102](https://leetcode.com/problems/binary-tree-level-order-traversal/) | Yes | BFS queue, snapshot size per level |
| 8 | Binary Tree Right Side View | [199](https://leetcode.com/problems/binary-tree-right-side-view/) | No | BFS — last node at each level |
| 9 | Count Good Nodes in Binary Tree | [1448](https://leetcode.com/problems/count-good-nodes-in-binary-tree/) | No | DFS passing max value along path |
| 10 | Validate Binary Search Tree | [98](https://leetcode.com/problems/validate-binary-search-tree/) | Yes | DFS with min/max bounds |
| 11 | Kth Smallest Element in a BST | [230](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) | Yes | Inorder traversal — k-th node visited |
| 12 | Lowest Common Ancestor of a BST | [235](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/) | Yes | Use BST ordering to navigate |
| 13 | Construct Binary Tree from Preorder and Inorder | [105](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) | Yes | Preorder[0] is root; find it in inorder to split |
| 14 | Implement Trie (Prefix Tree) | [208](https://leetcode.com/problems/implement-trie-prefix-tree/) | Yes | TrieNode with children map and isEnd flag |
| 15 | Design Add and Search Words | [211](https://leetcode.com/problems/design-add-and-search-words-data-structure/) | Yes | Trie + DFS for '.' wildcard |

## Hard

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 16 | Binary Tree Maximum Path Sum | [124](https://leetcode.com/problems/binary-tree-maximum-path-sum/) | Yes | Postorder: track gain per node, update global max |
| 17 | Serialize and Deserialize Binary Tree | [297](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) | Yes | Preorder DFS — encode null as sentinel |
| 18 | Word Search II | [212](https://leetcode.com/problems/word-search-ii/) | Yes | Trie + backtracking DFS on grid |

---

## Reflection Questions

1. What traversal order do you use when a subtree's result must be computed
   before the parent's result? (hint: it's not preorder)
2. In BST validation, why is passing `int` bounds problematic for certain inputs?
3. In Binary Tree Maximum Path Sum, why can only one branch be returned to the
   parent even though both are used to update the global max?
4. How does a Trie achieve O(k) search time regardless of how many words are stored?
