# Graphs — Exercises

---

## Medium

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 1 | Number of Islands | [200](https://leetcode.com/problems/number-of-islands/) | Yes | DFS flood fill; mark '1' as '0' |
| 2 | Clone Graph | [133](https://leetcode.com/problems/clone-graph/) | Yes | BFS/DFS + HashMap old→clone |
| 3 | Max Area of Island | [695](https://leetcode.com/problems/max-area-of-island/) | No | DFS returning island size |
| 4 | Pacific Atlantic Water Flow | [417](https://leetcode.com/problems/pacific-atlantic-water-flow/) | Yes | Multi-source BFS from each ocean border |
| 5 | Surrounded Regions | [130](https://leetcode.com/problems/surrounded-regions/) | No | DFS from border 'O's; mark safe; flip rest |
| 6 | Rotting Oranges | [994](https://leetcode.com/problems/rotting-oranges/) | No | Multi-source BFS; track fresh count |
| 7 | Course Schedule | [207](https://leetcode.com/problems/course-schedule/) | Yes | Kahn's BFS topological sort; cycle = not all processed |
| 8 | Course Schedule II | [210](https://leetcode.com/problems/course-schedule-ii/) | No | Same as above; collect the order |
| 9 | Number of Connected Components | [323](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/) | Yes | Union-Find or DFS counting unvisited starts |
| 10 | Graph Valid Tree | [261](https://leetcode.com/problems/graph-valid-tree/) | Yes | n-1 edges + no cycle (Union-Find) |
| 11 | Walls and Gates | [286](https://leetcode.com/problems/walls-and-gates/) | No | Multi-source BFS from gates (0 cells) |

## Hard

| # | Problem | LeetCode | Blind 75 | Pattern Hint |
|---|---------|----------|----------|--------------|
| 12 | Alien Dictionary | [269](https://leetcode.com/problems/alien-dictionary/) | Yes | Build order graph from adjacent words; topological sort |
| 13 | Longest Consecutive Sequence | [128](https://leetcode.com/problems/longest-consecutive-sequence/) | Yes | Set lookup — covered in arrays_hashing |
| 14 | Reconstruct Itinerary | [332](https://leetcode.com/problems/reconstruct-itinerary/) | Yes | Hierholzer's algorithm (Eulerian path) |

---

## Reflection Questions

1. BFS guarantees shortest path in an unweighted graph — explain why DFS does not.
2. In Kahn's algorithm, what does it mean if the number of processed nodes is less than V?
3. Union-Find `find()` uses path compression. Draw a before/after showing what this does to the tree.
4. When should you use DFS vs BFS for a graph problem?
