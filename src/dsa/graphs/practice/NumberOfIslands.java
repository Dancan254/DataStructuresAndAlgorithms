package dsa.graphs.practice;

/**
 * LeetCode 200 — Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 *
 * Given an m×n grid of '1' (land) and '0' (water), count the number of islands.
 * An island is surrounded by water and formed by connecting adjacent lands
 * horizontally or vertically.
 *
 * Example 1:
 *   Input:
 *     11110
 *     11010
 *     11000
 *     00000
 *   Output: 1
 *
 * Example 2:
 *   Input:
 *     11000
 *     11000
 *     00100
 *     00011
 *   Output: 3
 *
 * Constraints:
 *   - 1 <= m, n <= 300
 *   - grid[i][j] is '0' or '1'
 *
 * Hint: Each time you find a '1' you have found a new island.
 *       Run DFS from that cell to mark the entire island as visited
 *       (change '1' to '0' as you go — this avoids a separate visited array).
 *       Count how many times you start a new DFS.
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
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
