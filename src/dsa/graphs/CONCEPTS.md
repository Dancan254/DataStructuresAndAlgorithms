# Graphs

## What Is a Graph?

A graph G = (V, E) consists of a set of vertices (nodes) V and a set of edges E
connecting pairs of vertices. Graphs model networks: roads, social connections,
dependencies, web links, electrical circuits.

Unlike trees, graphs can have **cycles**, multiple paths between nodes, and
**disconnected components** (nodes with no path between them).

---

## Graph Terminology

| Term | Definition |
|------|-----------|
| Vertex (node) | A fundamental unit |
| Edge | A connection between two vertices |
| Adjacent | Two vertices connected by an edge |
| Degree | Number of edges incident to a vertex |
| In-degree | Number of incoming edges (directed graphs) |
| Out-degree | Number of outgoing edges (directed graphs) |
| Path | A sequence of vertices connected by edges |
| Cycle | A path that starts and ends at the same vertex |
| Connected | A graph where every pair of vertices has a path |
| Component | A maximal connected subgraph |
| DAG | Directed Acyclic Graph — no directed cycles |
| Weighted | Edges have associated costs/weights |

---

## 1. Graph Types

**Undirected:** edges have no direction. If (u, v) exists, (v, u) also exists.
```
A -- B -- C
|         |
D --------+
```

**Directed (Digraph):** edges have direction. (u, v) means u → v only.
```
A → B → C
↑       |
D ←-----+
```

**Weighted:** each edge has a numerical weight (cost, distance, capacity).

**DAG (Directed Acyclic Graph):** directed with no cycles. Used for dependency
resolution, scheduling, topological ordering.

---

## 2. Graph Representations

### Adjacency List (Most Common)

Each vertex stores a list of its neighbours. Efficient for sparse graphs.

```java
// Build an undirected graph with n vertices
List<List<Integer>> adj = new ArrayList<>();
for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

void addEdge(int u, int v) {
    adj.get(u).add(v);
    adj.get(v).add(u); // omit for directed graph
}
```

| Operation | Time |
|-----------|------|
| Add edge | O(1) |
| Check edge (u,v) | O(degree(u)) |
| Iterate neighbours of u | O(degree(u)) |
| Space | O(V + E) |

### Adjacency Matrix

An n×n boolean (or weight) matrix. `matrix[u][v] = true` means edge u→v exists.
Best when the graph is dense or you need O(1) edge queries.

```java
boolean[][] matrix = new boolean[n][n];

void addEdge(int u, int v) {
    matrix[u][v] = true;
    matrix[v][u] = true; // omit for directed
}
```

| Operation | Time |
|-----------|------|
| Add edge | O(1) |
| Check edge (u,v) | O(1) |
| Iterate neighbours of u | O(V) — must scan entire row |
| Space | O(V²) |

### Edge List

A list of all edges as pairs (or triples for weighted). Used in algorithms
that process all edges (Kruskal's MST, Bellman-Ford).

```java
int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 0}};
```

---

## 3. Depth-First Search (DFS)

Explores as far as possible along each branch before backtracking. Uses a
stack (or recursion). Finds all vertices reachable from a source.

```java
boolean[] visited;

void dfs(int v) {
    visited[v] = true;
    for (int neighbour : adj.get(v)) {
        if (!visited[neighbour]) dfs(neighbour);
    }
}

// Iterative DFS with explicit stack
void dfsIterative(int start) {
    Deque<Integer> stack = new ArrayDeque<>();
    visited[start] = true;
    stack.push(start);
    while (!stack.isEmpty()) {
        int v = stack.pop();
        process(v);
        for (int neighbour : adj.get(v)) {
            if (!visited[neighbour]) {
                visited[neighbour] = true;
                stack.push(neighbour);
            }
        }
    }
}
```

**Time:** O(V + E)   **Space:** O(V) for visited + O(V) call stack

**Use DFS for:** cycle detection, topological sort, connected components,
strongly connected components (Kosaraju's, Tarjan's), path finding.

---

## 4. Breadth-First Search (BFS)

Explores all neighbours at the current depth before going deeper. Uses a queue.
Guarantees the **shortest path** in an unweighted graph.

```java
void bfs(int start) {
    boolean[] visited = new boolean[n];
    Queue<Integer> queue = new LinkedList<>();
    visited[start] = true;
    queue.offer(start);

    while (!queue.isEmpty()) {
        int v = queue.poll();
        process(v);
        for (int neighbour : adj.get(v)) {
            if (!visited[neighbour]) {
                visited[neighbour] = true;
                queue.offer(neighbour);
            }
        }
    }
}
```

**Key:** mark visited BEFORE enqueuing, not after — otherwise the same node
can be enqueued multiple times before being processed.

**Time:** O(V + E)   **Space:** O(V)

**Use BFS for:** shortest path in unweighted graphs, level-order traversal,
bipartite checking, multi-source shortest path.

---

## 5. Topological Sort

A linear ordering of vertices in a DAG such that for every directed edge u → v,
u appears before v. Only valid for DAGs (no cycles).

### Kahn's Algorithm (BFS-based)

1. Compute in-degree for all vertices.
2. Enqueue all vertices with in-degree 0.
3. Dequeue a vertex, add to result, decrement neighbours' in-degrees.
4. Enqueue any neighbour whose in-degree reaches 0.
5. If result contains all V vertices, the graph is a DAG.

```java
int[] inDegree = new int[n];
for (int u = 0; u < n; u++)
    for (int v : adj.get(u)) inDegree[v]++;

Queue<Integer> queue = new LinkedList<>();
for (int i = 0; i < n; i++) if (inDegree[i] == 0) queue.offer(i);

List<Integer> order = new ArrayList<>();
while (!queue.isEmpty()) {
    int u = queue.poll();
    order.add(u);
    for (int v : adj.get(u))
        if (--inDegree[v] == 0) queue.offer(v);
}
// order.size() < n means a cycle was detected
```

### DFS-Based Topological Sort

Run DFS. When a node finishes (all descendants visited), push it onto a stack.
Pop the stack to get the topological order.

---

## 6. Union-Find (Disjoint Set Union)

Efficiently answers "are these two nodes in the same connected component?" and
merges components. Nearly O(1) per operation with two optimisations:
- **Path compression:** flatten the tree during `find` by making all nodes point directly to the root.
- **Union by rank:** always attach the shorter tree under the taller one.

```java
class UnionFind {
    int[] parent, rank;
    int components;

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
        if (px == py) return false; // already in same component

        // Union by rank
        if (rank[px] < rank[py]) { int tmp = px; px = py; py = tmp; }
        parent[py] = px;
        if (rank[px] == rank[py]) rank[px]++;
        components--;
        return true;
    }

    boolean connected(int x, int y) { return find(x) == find(y); }
    int getComponents()             { return components; }
}
```

**Time:** O(α(n)) per operation (effectively O(1)) where α is the inverse Ackermann function.

---

## 7. Shortest Path Algorithms

| Algorithm | Graph Type | Time | Notes |
|-----------|-----------|------|-------|
| BFS | Unweighted | O(V+E) | Exact shortest path |
| Dijkstra's | Weighted, non-negative | O((V+E) log V) | Min-heap based |
| Bellman-Ford | Weighted, negative edges OK | O(VE) | Detects negative cycles |
| Floyd-Warshall | All-pairs | O(V³) | DP on all pairs |

**Dijkstra's (outline):**
```java
int[] dist = new int[n];
Arrays.fill(dist, Integer.MAX_VALUE);
dist[start] = 0;
PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
pq.offer(new int[]{start, 0});

while (!pq.isEmpty()) {
    int[] curr = pq.poll();
    int u = curr[0], d = curr[1];
    if (d > dist[u]) continue; // stale entry
    for (int[] edge : adj.get(u)) {
        int v = edge[0], w = edge[1];
        if (dist[u] + w < dist[v]) {
            dist[v] = dist[u] + w;
            pq.offer(new int[]{v, dist[v]});
        }
    }
}
```

---

## 8. Complexity Summary

| Algorithm | Time | Space | Use Case |
|-----------|------|-------|---------|
| DFS | O(V + E) | O(V) | Connectivity, cycles, topological sort |
| BFS | O(V + E) | O(V) | Shortest path (unweighted) |
| Topological sort | O(V + E) | O(V) | Dependency ordering |
| Union-Find | O(α(n)) per op | O(V) | Dynamic connectivity |
| Dijkstra's | O((V+E) log V) | O(V) | Shortest path (non-negative weights) |

---

## Common Mistakes

- Marking nodes as visited after dequeuing (BFS) instead of before enqueuing —
  causes the same node to be enqueued multiple times.
- Forgetting that topological sort only works on DAGs — cycle detection is built
  into Kahn's algorithm via the final count check.
- In Union-Find, comparing `find(x) == find(y)` not `x == y` (roots, not values).
- Using DFS on a very deep graph without converting to iterative (stack overflow).
- Not initialising `dist` to `Integer.MAX_VALUE` in Dijkstra's — adding to it
  causes overflow: check `d > dist[u]` to skip stale priority queue entries.
