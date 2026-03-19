package dsa.backtracking.practice;

/**
 * LeetCode 79 — Word Search
 * https://leetcode.com/problems/word-search/
 *
 * Given an m×n board of characters and a string word, return true if the word
 * exists in the grid. The word must be constructed from letters of sequentially
 * adjacent cells (horizontally or vertically). The same cell may not be used twice.
 *
 * Example 1:
 *   Board:  [['A','B','C','E'],
 *            ['S','F','C','S'],
 *            ['A','D','E','E']]
 *   word = "ABCCED"  →  Output: true
 *
 * Example 2:
 *   Same board, word = "SEE"  →  Output: true
 *
 * Example 3:
 *   Same board, word = "ABCB"  →  Output: false  (can't reuse B)
 *
 * Constraints:
 *   - 1 <= m, n <= 6
 *   - 1 <= word.length <= 15
 *   - board and word consist only of uppercase and lowercase English letters
 *
 * Hint: For every cell that matches word[0], start a DFS.
 *       At each step: check bounds, check character match, mark cell as visited
 *       (temporarily replace with a sentinel like '#'), recurse in 4 directions,
 *       then RESTORE the cell (backtrack) before returning.
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        WordSearch solution = new WordSearch();

        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };

        System.out.println(solution.exist(board, "ABCCED")); // true
        System.out.println(solution.exist(board, "SEE"));    // true
        System.out.println(solution.exist(board, "ABCB"));   // false
    }
}
