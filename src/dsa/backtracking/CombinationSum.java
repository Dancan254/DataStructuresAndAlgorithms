package dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 39 — Combination Sum
 *
 * Given distinct integers and a target, find all unique combinations where
 * candidates sum to target. Each candidate may be used unlimited times.
 *
 * Pattern: Backtracking with reuse allowed
 *
 * Pass the same index i (not i+1) to allow reuse.
 * Prune when candidates[i] > remaining — since candidates are positive,
 * all subsequent candidates are also too large after sorting.
 *
 * Time:  O(n^(t/m)) where t = target, m = smallest candidate
 * Space: O(t/m) recursion depth
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int start, int remaining,
                           List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current)); // add a COPY
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remaining) continue; // prune
            current.add(candidates[i]);
            backtrack(candidates, i, remaining - candidates[i], current, result); // i: allow reuse
            current.remove(current.size() - 1); // backtrack
        }
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();

        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
        // [[2,2,3], [7]]

        System.out.println(solution.combinationSum(new int[]{2, 3, 5}, 8));
        // [[2,2,2,2], [2,3,3], [3,5]]
    }
}
