# Data Structures and Algorithms — Interview Preparation Guide

A structured, sequential study guide covering the Blind 75 problems and the
core DSA topics required for software engineering interviews. Written in Java.

---

## Getting Started

```bash
git clone https://github.com/Dancan254/DataStructuresAndAlgorithms.git
cd DataStructuresAndAlgorithms
```

Open the project in IntelliJ IDEA or any Java IDE. The source root is `src/`.

---

## How This Repo Is Organised

```
src/dsa/
├── <topic>/
│   ├── CONCEPTS.md        — Theory, patterns, annotated code templates
│   ├── EXERCISES.md       — Problem list (Blind 75 marked) with pattern hints
│   ├── *.java             — Fully solved reference implementations
│   └── practice/
│       └── *.java         — Your workspace: empty method stubs + test cases
```

### Workflow

1. Read `CONCEPTS.md` for the topic. Understand every pattern before touching code.
2. Study the solved `.java` files in the topic root to see the patterns applied.
3. Open a file inside `practice/` — each file has the full problem description,
   constraints, a hint, and a `main()` method with test cases already written.
4. Implement the method in your IDE. Run `main()` directly to check your output.
5. Review `EXERCISES.md` for additional problems to attempt on LeetCode.

---

## Sequential Learning Path

Work through the topics in this order. Each one builds on the previous.

| # | Topic | Folder | Core Patterns |
|---|-------|--------|---------------|
| 01 | Arrays and Hashing | `arrays_hashing/` | Frequency maps, complement lookup, prefix sums, set membership |
| 02 | Two Pointers | `two_pointers/` | Opposite-end, three-pointer, fast/slow |
| 03 | Sliding Window | `sliding_window/` | Fixed window, variable window, minimum covering window |
| 04 | Stack | `stack/` | Bracket matching, monotonic stack |
| 05 | Binary Search | `binary_search/` | Classic, rotated arrays, search on answer space |
| 06 | Linked List | `linked_list/` | Reversal, merge, fast/slow pointers |
| 07 | Trees | `trees/` | DFS pre/in/post-order, BFS, BST properties, Trie |
| 08 | Heap / Priority Queue | `heap/` | Top-K, two-heap median |
| 09 | Backtracking | `backtracking/` | Subsets, permutations, grid search |
| 10 | Graphs | `graphs/` | BFS, DFS, topological sort, Union-Find |
| 11 | Dynamic Programming | `dynamic_programming/` | 1D DP, knapsack, 2D DP, subsequences |
| 12 | Intervals | `intervals/` | Sort by start/end, greedy scheduling |
| 13 | Bit Manipulation | `bit_manipulation/` | XOR tricks, counting bits, carry arithmetic |

See [STUDY_GUIDE.md](./STUDY_GUIDE.md) for the full Blind 75 problem map.

---

## Resources

- [Blind 75 LeetCode Problems](https://leetcode.com/discuss/general-discussion/460599/blind-75-leetcode-questions)
- [NeetCode Roadmap](https://neetcode.io/roadmap)
- [GeeksforGeeks — DSA](https://www.geeksforgeeks.org/data-structures/)
- [MIT 6.006 Introduction to Algorithms](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-fall-2011/)

---

All the best!
