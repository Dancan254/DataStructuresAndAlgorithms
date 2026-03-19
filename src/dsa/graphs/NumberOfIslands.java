package dsa.graphs;

/**
 * LeetCode 200 — Number of Islands
 *
 * Count the number of islands in a grid of '1' (land) and '0' (water).
 * An island is a group of '1's connected horizontally or vertically.
 *
 * Pattern: DFS on grid — flood fill
 *
 * For each unvisited '1', run DFS to mark the entire island as visited
 * (by setting cells to '0') and increment the island count.
 *
 * Time:  O(m * n)
 * Space: O(m * n) — recursion stack in the worst case (all land)
 */
public class NumberOfIslands {

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
        // Boundary check and water/visited check
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return;
        if (grid[r][c] != '1') return;

        grid[r][c] = '0'; // mark as visited

        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();

        char[][] grid1 = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        System.out.println(solution.numIslands(grid1)); // 1

        char[][] grid2 = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        System.out.println(solution.numIslands(grid2)); // 3
    }
}
