package dsa.backtracking.practice;

import java.util.List;

/**
 * LeetCode 39 — Combination Sum
 * https://leetcode.com/problems/combination-sum/
 *
 * Given an array of distinct integers and a target, return all unique combinations
 * that sum to target. Each candidate may be used an unlimited number of times.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 *   Input:  candidates = [2,3,6,7], target = 7
 *   Output: [[2,2,3],[7]]
 *
 * Example 2:
 *   Input:  candidates = [2,3,5], target = 8
 *   Output: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * Constraints:
 *   - 1 <= candidates.length <= 30
 *   - 2 <= candidates[i] <= 40
 *   - All candidates are distinct
 *   - 1 <= target <= 40
 *
 * Hint: Use backtracking with a `start` index to avoid re-using previous elements
 *       in a different order (which would create duplicates).
 *       Pass the SAME index i (not i+1) to allow reusing the same candidate.
 *       Prune when candidates[i] > remaining — no need to explore further.
 *       Remember to add a COPY of your current list to the result.
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();

        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
        // [[2,2,3],[7]]

        System.out.println(solution.combinationSum(new int[]{2, 3, 5}, 8));
        // [[2,2,2,2],[2,3,3],[3,5]]

        System.out.println(solution.combinationSum(new int[]{2}, 1));
        // []
    }
}
