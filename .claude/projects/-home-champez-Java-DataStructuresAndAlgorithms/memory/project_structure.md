---
name: project_structure
description: Current repo structure, design decisions, and what has been built for the DSA interview prep guide
type: project
---

This is a Java DSA interview preparation repository structured for sequential learning.

**Top-level files:**
- `README.md` — clean overview, workflow explanation, learning path table
- `STUDY_GUIDE.md` — full sequential roadmap + Blind 75 coverage map by topic

**Source structure:** `src/dsa/<topic>/`
Each topic folder contains:
- `CONCEPTS.md` — professional theory and pattern breakdowns (no emojis)
- Solved reference `.java` files demonstrating each core pattern
- `practice/` subfolder — blank method stubs with problem descriptions, hints, constraints, and test cases in `main()` for IDE-based practice

**13 topics built:**
arrays_hashing, two_pointers, sliding_window, stack, binary_search, linked_list, trees, heap, backtracking, graphs, dynamic_programming, intervals, bit_manipulation

**Shared utility classes:**
- `dsa.linked_list.ListNode` — shared node for linked list practice files (has `of()` and `toString()` helpers)
- `dsa.trees.Node` — shared tree node (uses `val` field, LeetCode-compatible)

**Old folders removed:** src/dsa/arrays/, src/dsa/slidingwindow/, src/dsa/LinkedList/, src/dsa/sorting/, loose root dsa files, old trees/TreeNode.java and trees/BinarySearchTree.java

**Practice files cover ~55 Blind 75 problems across all topics.**
