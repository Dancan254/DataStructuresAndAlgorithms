package dsa.graphs;

/**
 * Union-Find (Disjoint Set Union) with path compression and union by rank.
 *
 * Answers two questions efficiently:
 *   1. Are two nodes in the same connected component? — find(x) == find(y)
 *   2. Merge two components. — union(x, y)
 *
 * Two optimisations bring the amortised cost to near-O(1) per operation:
 *   - Path compression:  during find, point every node on the path directly
 *                        to the root (flattens the tree).
 *   - Union by rank:     always attach the shorter tree under the taller one
 *                        so the trees stay flat over time.
 *
 * Time: O(α(n)) per operation (inverse Ackermann — effectively constant).
 * Space: O(n)
 *
 * Common applications: Kruskal's MST, number of islands (offline), detecting
 * cycles in undirected graphs, dynamic connectivity queries.
 */
public class UnionFind {

    private final int[] parent;
    private final int[] rank;
    private int components; // number of disjoint sets

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    /** Initialise n disjoint singletons: {0}, {1}, ..., {n-1}. */
    public UnionFind(int n) {
        parent = new int[n];
        rank   = new int[n];
        components = n;
        for (int i = 0; i < n; i++) parent[i] = i; // each node is its own root
    }

    // -------------------------------------------------------------------------
    // Find — with path compression
    // -------------------------------------------------------------------------

    /**
     * Return the root (representative) of the component containing x.
     * Path compression: during traversal every node is made to point directly
     * to the root, so future calls are O(1).
     */
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]); // compress path
        return parent[x];
    }

    // -------------------------------------------------------------------------
    // Union — by rank
    // -------------------------------------------------------------------------

    /**
     * Merge the components containing x and y.
     * Returns true if they were in different components (a merge happened),
     * false if they were already connected.
     *
     * Union by rank: the root with lower rank is attached under the root with
     * higher rank to keep trees flat. Rank only increases when two trees of
     * equal rank are merged.
     */
    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return false; // already in the same component

        // Attach smaller rank tree under larger rank tree
        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
        components--;
        return true;
    }

    // -------------------------------------------------------------------------
    // Queries
    // -------------------------------------------------------------------------

    /** Return true if x and y belong to the same component. */
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    /** Return the current number of disjoint components. */
    public int getComponents() {
        return components;
    }

    // -------------------------------------------------------------------------
    // Cycle Detection (undirected graph via edge list)
    // -------------------------------------------------------------------------

    /**
     * Check whether adding edges one by one creates a cycle.
     * If union(u, v) returns false, u and v were already connected — adding
     * this edge creates a cycle.
     *
     * Used in Kruskal's MST to skip edges that would form a cycle.
     */
    public static boolean hasCycle(int vertices, int[][] edges) {
        UnionFind uf = new UnionFind(vertices);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) return true; // same component = cycle
        }
        return false;
    }

    // -------------------------------------------------------------------------
    // Demo
    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println("=== Union-Find Basic Operations ===");
        UnionFind uf = new UnionFind(8);

        System.out.println("Components: " + uf.getComponents()); // 8

        uf.union(0, 1);
        uf.union(1, 2);
        uf.union(3, 4);
        uf.union(5, 6);
        uf.union(6, 7);

        System.out.println("Components after unions: " + uf.getComponents()); // 4: {0,1,2},{3,4},{5,6,7},{-}

        System.out.println("connected(0, 2): " + uf.connected(0, 2)); // true
        System.out.println("connected(0, 3): " + uf.connected(0, 3)); // false
        System.out.println("connected(5, 7): " + uf.connected(5, 7)); // true

        uf.union(2, 3); // merge {0,1,2} and {3,4}
        System.out.println("After union(2,3), connected(0, 4): " + uf.connected(0, 4)); // true
        System.out.println("Components: " + uf.getComponents()); // 3

        System.out.println("\n=== Cycle Detection ===");
        int[][] noCycle = {{0,1},{1,2},{2,3}};
        System.out.println("No-cycle graph has cycle: " + hasCycle(4, noCycle)); // false

        int[][] withCycle = {{0,1},{1,2},{2,0}};
        System.out.println("Triangle graph has cycle:  " + hasCycle(3, withCycle)); // true

        System.out.println("\n=== Number of Islands (grid as Union-Find) ===");
        // Represent a 3x3 grid as vertices 0-8 and connect adjacent land cells
        // Grid:  1 1 0
        //        1 0 0
        //        0 0 1
        char[][] grid = {
            {'1','1','0'},
            {'1','0','0'},
            {'0','0','1'}
        };
        System.out.println("Islands: " + countIslands(grid)); // 2
    }

    /** Classic "number of islands" solved with Union-Find. */
    private static int countIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        UnionFind uf = new UnionFind(rows * cols);
        int waterCells = 0;

        int[] dr = {0, 1};
        int[] dc = {1, 0};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '0') { waterCells++; continue; }
                for (int d = 0; d < 2; d++) {
                    int nr = r + dr[d], nc = c + dc[d];
                    if (nr < rows && nc < cols && grid[nr][nc] == '1') {
                        uf.union(r * cols + c, nr * cols + nc);
                    }
                }
            }
        }
        return uf.getComponents() - waterCells;
    }
}
