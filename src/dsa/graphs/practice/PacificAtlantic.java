package dsa.graphs.practice;

import java.util.List;

/**
 * LeetCode 417 — Pacific Atlantic Water Flow
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 *
 * Given an m×n island with heights, water can flow to an adjacent cell (4 dirs)
 * if its height is <= the current cell. Water can flow off the top/left edges
 * into the Pacific and off the bottom/right edges into the Atlantic.
 *
 * Return all cells from which water can flow to BOTH oceans.
 *
 * Example:
 *   heights = [[1,2,2,3,5],
 *              [3,2,3,4,4],
 *              [2,4,5,3,1],
 *              [6,7,1,4,5],
 *              [5,1,1,2,4]]
 *   Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 *
 * Constraints:
 *   - 1 <= m, n <= 200
 *   - 0 <= heights[i][j] <= 10^5
 *
 * Hint: Instead of simulating water flowing DOWN from each cell (expensive),
 *       reverse the problem: BFS uphill from each ocean border.
 *       - Multi-source BFS from all Pacific border cells (top row + left col).
 *       - Multi-source BFS from all Atlantic border cells (bottom row + right col).
 *       Cells reachable from both BFS runs are your answer.
 *       Move to a neighbour when its height is >= current (uphill is valid in reverse).
 */
public class PacificAtlantic {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        PacificAtlantic solution = new PacificAtlantic();

        int[][] heights = {
            {1,2,2,3,5},
            {3,2,3,4,4},
            {2,4,5,3,1},
            {6,7,1,4,5},
            {5,1,1,2,4}
        };
        System.out.println(solution.pacificAtlantic(heights));
        // [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]

        System.out.println(solution.pacificAtlantic(new int[][]{{1}}));
        // [[0,0]]
    }
}
