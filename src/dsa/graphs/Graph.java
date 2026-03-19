package dsa.graphs;

import java.util.*;

/**
 * Adjacency list graph supporting both directed and undirected variants.
 *
 * Vertices are integers 0..n-1. Edges are stored as ArrayList<Integer> per vertex.
 *
 * Demonstrates: addEdge, DFS (recursive + iterative), BFS, cycle detection,
 *               connected components count, topological sort (Kahn's algorithm),
 *               and shortest path (BFS, unweighted).
 *
 * Time: O(V + E) for all traversals.   Space: O(V + E) for adjacency list.
 */
public class Graph {

    private final int vertices;
    private final boolean directed;
    private final List<List<Integer>> adj;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    public Graph(int vertices, boolean directed) {
        this.vertices = vertices;
        this.directed = directed;
        adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) adj.add(new ArrayList<>());
    }

    /** Undirected graph by default. */
    public Graph(int vertices) { this(vertices, false); }

    // -------------------------------------------------------------------------
    // Add Edge
    // -------------------------------------------------------------------------

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        if (!directed) adj.get(v).add(u);
    }

    public List<Integer> neighbours(int v) { return adj.get(v); }
    public int vertexCount()               { return vertices; }

    // -------------------------------------------------------------------------
    // DFS — Recursive
    // -------------------------------------------------------------------------

    /**
     * Visit all vertices reachable from start using recursive DFS.
     * Returns the visited set in the order nodes were first reached.
     */
    public List<Integer> dfsRecursive(int start) {
        boolean[] visited = new boolean[vertices];
        List<Integer> order = new ArrayList<>();
        dfsHelper(start, visited, order);
        return order;
    }

    private void dfsHelper(int v, boolean[] visited, List<Integer> order) {
        visited[v] = true;
        order.add(v);
        for (int neighbour : adj.get(v)) {
            if (!visited[neighbour]) dfsHelper(neighbour, visited, order);
        }
    }

    // -------------------------------------------------------------------------
    // DFS — Iterative (explicit stack)
    // -------------------------------------------------------------------------

    /** Iterative DFS using an explicit stack. Avoids stack-overflow on deep graphs. */
    public List<Integer> dfsIterative(int start) {
        boolean[] visited = new boolean[vertices];
        List<Integer> order = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();

        visited[start] = true;
        stack.push(start);

        while (!stack.isEmpty()) {
            int v = stack.pop();
            order.add(v);
            for (int neighbour : adj.get(v)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    stack.push(neighbour);
                }
            }
        }
        return order;
    }

    // -------------------------------------------------------------------------
    // BFS
    // -------------------------------------------------------------------------

    /**
     * BFS from start. Returns vertices in level-order.
     * Mark visited BEFORE enqueuing — not after dequeuing — to avoid duplicates.
     */
    public List<Integer> bfs(int start) {
        boolean[] visited = new boolean[vertices];
        List<Integer> order = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            order.add(v);
            for (int neighbour : adj.get(v)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
        return order;
    }

    // -------------------------------------------------------------------------
    // Shortest Path (BFS — unweighted)
    // -------------------------------------------------------------------------

    /**
     * Return the shortest distance (number of edges) from start to every vertex.
     * dist[v] == -1 means v is unreachable from start.
     */
    public int[] shortestPath(int start) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, -1);
        dist[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int neighbour : adj.get(v)) {
                if (dist[neighbour] == -1) {
                    dist[neighbour] = dist[v] + 1;
                    queue.offer(neighbour);
                }
            }
        }
        return dist;
    }

    // -------------------------------------------------------------------------
    // Connected Components (undirected)
    // -------------------------------------------------------------------------

    /**
     * Count connected components in an undirected graph.
     * Iterates over all vertices and launches a DFS from each unvisited one.
     */
    public int connectedComponents() {
        boolean[] visited = new boolean[vertices];
        int count = 0;
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfsHelper(i, visited, new ArrayList<>());
                count++;
            }
        }
        return count;
    }

    // -------------------------------------------------------------------------
    // Cycle Detection
    // -------------------------------------------------------------------------

    /**
     * Detect a cycle in an undirected graph using DFS.
     * A back edge (edge to an already-visited non-parent vertex) means a cycle.
     */
    public boolean hasCycleUndirected() {
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && cycleUndirectedDFS(i, -1, visited)) return true;
        }
        return false;
    }

    private boolean cycleUndirectedDFS(int v, int parent, boolean[] visited) {
        visited[v] = true;
        for (int neighbour : adj.get(v)) {
            if (!visited[neighbour]) {
                if (cycleUndirectedDFS(neighbour, v, visited)) return true;
            } else if (neighbour != parent) {
                return true; // back edge to non-parent = cycle
            }
        }
        return false;
    }

    /**
     * Detect a cycle in a directed graph using DFS with a recursion stack.
     * A back edge to a vertex currently on the call stack = cycle.
     */
    public boolean hasCycleDirected() {
        boolean[] visited   = new boolean[vertices];
        boolean[] recStack  = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && cycleDirectedDFS(i, visited, recStack)) return true;
        }
        return false;
    }

    private boolean cycleDirectedDFS(int v, boolean[] visited, boolean[] recStack) {
        visited[v]  = true;
        recStack[v] = true;
        for (int neighbour : adj.get(v)) {
            if (!visited[neighbour]) {
                if (cycleDirectedDFS(neighbour, visited, recStack)) return true;
            } else if (recStack[neighbour]) {
                return true; // back edge within current path = cycle
            }
        }
        recStack[v] = false; // backtrack — remove from current path
        return false;
    }

    // -------------------------------------------------------------------------
    // Topological Sort — Kahn's Algorithm (BFS-based)
    // -------------------------------------------------------------------------

    /**
     * Topological ordering of a DAG using Kahn's algorithm.
     * Returns an empty list if the graph contains a cycle (not a valid DAG).
     * Only meaningful for directed graphs.
     */
    public List<Integer> topologicalSort() {
        int[] inDegree = new int[vertices];
        for (int u = 0; u < vertices; u++)
            for (int v : adj.get(u)) inDegree[v]++;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++)
            if (inDegree[i] == 0) queue.offer(i);

        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.add(u);
            for (int v : adj.get(u))
                if (--inDegree[v] == 0) queue.offer(v);
        }

        return order.size() == vertices ? order : new ArrayList<>(); // empty = cycle detected
    }

    // -------------------------------------------------------------------------
    // Utility
    // -------------------------------------------------------------------------

    public void printAdjList() {
        for (int i = 0; i < vertices; i++)
            System.out.println(i + " -> " + adj.get(i));
    }

    // -------------------------------------------------------------------------
    // Demo
    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println("=== Undirected Graph ===");
        Graph g = new Graph(6);
        g.addEdge(0, 1); g.addEdge(0, 2);
        g.addEdge(1, 3); g.addEdge(2, 4);
        g.addEdge(4, 5);
        g.printAdjList();

        System.out.println("\nDFS (recursive) from 0: " + g.dfsRecursive(0));
        System.out.println("DFS (iterative) from 0: " + g.dfsIterative(0));
        System.out.println("BFS from 0:             " + g.bfs(0));
        System.out.println("Shortest paths from 0:  " + Arrays.toString(g.shortestPath(0)));
        System.out.println("Connected components:   " + g.connectedComponents());
        System.out.println("Has cycle:              " + g.hasCycleUndirected());

        System.out.println("\n--- Add edge creating a cycle ---");
        g.addEdge(3, 5);
        System.out.println("Has cycle:              " + g.hasCycleUndirected());

        System.out.println("\n=== Directed Graph — Topological Sort ===");
        Graph dag = new Graph(6, true);
        dag.addEdge(5, 2); dag.addEdge(5, 0);
        dag.addEdge(4, 0); dag.addEdge(4, 1);
        dag.addEdge(2, 3); dag.addEdge(3, 1);
        System.out.println("Topological order: " + dag.topologicalSort());
        System.out.println("Has cycle:         " + dag.hasCycleDirected());

        System.out.println("\n=== Disconnected Graph ===");
        Graph disconnected = new Graph(7);
        disconnected.addEdge(0, 1); disconnected.addEdge(1, 2);
        disconnected.addEdge(3, 4);
        // vertices 5 and 6 are isolated
        System.out.println("Connected components: " + disconnected.connectedComponents()); // 4
    }
}
