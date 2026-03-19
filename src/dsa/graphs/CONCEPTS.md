# Graphs

## Overview

A graph is a collection of nodes (vertices) connected by edges. Unlike trees,
graphs can have cycles, multiple paths between nodes, and disconnected components.

Most graph interview problems involve one of four algorithms: BFS, DFS,
Union-Find, or topological sort.

---

## Representations

**Adjacency List (most common for sparse graphs):**
```java
List<List<Integer>> adj = new ArrayList<>();
for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
adj.get(u).add(v);
adj.get(v).add(u); // undirected
```

**Grid as implicit graph:** Cells are nodes; edges connect cells in 4 directions.
No explicit adjacency list needed — neighbours are `(r±1, c)` and `(r, c±1)`.

---

## Pattern 1: DFS on a Graph

Track visited nodes to avoid infinite loops.

```java
void dfs(int node, boolean[] visited, List<List<Integer>> adj) {
    visited[node] = true;
    for (int neighbour : adj.get(node)) {
        if (!visited[neighbour]) dfs(neighbour, visited, adj);
    }
}
```

**Example — Number of Islands (LeetCode 200):**
Grid DFS. Every time you find an unvisited '1', increment count and DFS to
mark the entire island as visited.

```java
// O(m * n) time, O(m * n) space
public int numIslands(char[][] grid) {
    int count = 0;
    for (int r = 0; r < grid.length; r++) {
        for (int c = 0; c < grid[0].length; c++) {
            if (grid[r][c] == '1') {
                dfs(grid, r, c);
                count++;
            }
        }
    }
    return count;
}

private void dfs(char[][] grid, int r, int c) {
    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return;
    if (grid[r][c] != '1') return;
    grid[r][c] = '0'; // mark visited by mutating the grid
    dfs(grid, r+1, c); dfs(grid, r-1, c);
    dfs(grid, r, c+1); dfs(grid, r, c-1);
}
```

---

## Pattern 2: BFS on a Graph

BFS finds the **shortest path** in an unweighted graph.

```java
void bfs(int start, boolean[] visited, List<List<Integer>> adj) {
    Queue<Integer> queue = new LinkedList<>();
    visited[start] = true;
    queue.offer(start);

    while (!queue.isEmpty()) {
        int node = queue.poll();
        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                visited[neighbour] = true;
                queue.offer(neighbour);
            }
        }
    }
}
```

---

## Pattern 3: Cycle Detection / Topological Sort

**Topological sort** produces a linear ordering of nodes in a Directed Acyclic
Graph (DAG) where all edges point forward.

**Kahn's Algorithm (BFS-based):**
1. Compute in-degrees of all nodes.
2. Enqueue all nodes with in-degree 0.
3. Process each node: decrement neighbours' in-degrees; enqueue any that reach 0.
4. If all nodes are processed, no cycle exists.

**Example — Course Schedule (LeetCode 207):**
Can all courses be finished given prerequisites?

```java
// O(V + E) time, O(V + E) space
public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] inDegree = new int[numCourses];
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

    for (int[] pre : prerequisites) {
        adj.get(pre[1]).add(pre[0]);
        inDegree[pre[0]]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
        if (inDegree[i] == 0) queue.offer(i);
    }

    int processed = 0;
    while (!queue.isEmpty()) {
        int course = queue.poll();
        processed++;
        for (int next : adj.get(course)) {
            if (--inDegree[next] == 0) queue.offer(next);
        }
    }
    return processed == numCourses; // false if cycle detected
}
```

---

## Pattern 4: Union-Find (Disjoint Set Union)

Efficiently answers: "are two nodes in the same connected component?"
Supports `union(a, b)` and `find(a)` in nearly O(1) amortised with path
compression and union by rank.

```java
class UnionFind {
    private int[] parent, rank;
    private int components;

    UnionFind(int n) {
        parent = new int[n];
        rank   = new int[n];
        components = n;
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]); // path compression
        return parent[x];
    }

    boolean union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return false; // already connected
        if (rank[px] < rank[py]) { int tmp = px; px = py; py = tmp; }
        parent[py] = px;
        if (rank[px] == rank[py]) rank[px]++;
        components--;
        return true;
    }

    int getComponents() { return components; }
}
```

**Example — Number of Connected Components (LeetCode 323):**
Union all edges. The answer is `UnionFind.getComponents()`.

---

## Pattern 5: Multi-Source BFS

Start BFS from multiple sources simultaneously. Used when you need shortest
distance from any of a set of source nodes.

**Example — Pacific Atlantic Water Flow (LeetCode 417):**
Run BFS from Pacific border cells (top row + left col) and from Atlantic border
cells (bottom row + right col). Cells reachable from both are the answer.

---

## Complexity Summary

| Algorithm | Time | Space |
|-----------|------|-------|
| DFS / BFS on graph | O(V + E) | O(V) |
| DFS / BFS on grid | O(m * n) | O(m * n) |
| Topological sort (Kahn's) | O(V + E) | O(V + E) |
| Union-Find (with optimisations) | O(α(n)) per op | O(n) |

---

## Common Mistakes

- Not marking a node as visited **before** enqueuing it in BFS (causes duplicate processing).
- In grid DFS, mutating the grid to mark visited but not restoring it if the graph
  is used again (fine for isolation problems, not for backtracking problems).
- Confusing directed and undirected edges when building the adjacency list.
- In topological sort, not checking whether all nodes were processed — this check
  is how you detect a cycle.
