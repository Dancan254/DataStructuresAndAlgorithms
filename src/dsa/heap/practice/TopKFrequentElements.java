package dsa.heap.practice;

import java.util.Arrays;

/**
 * LeetCode 347 — Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Given an integer array and an integer k, return the k most frequent elements.
 * The answer can be in any order. Must be better than O(n log n).
 *
 * Example 1:
 *   Input:  nums = [1,1,1,2,2,3], k = 2
 *   Output: [1, 2]
 *
 * Example 2:
 *   Input:  nums = [1], k = 1
 *   Output: [1]
 *
 * Constraints:
 *   - 1 <= nums.length <= 10^5
 *   - k is in range [1, number of unique elements]
 *
 * Approach A (heap, O(n log k)):
 *   Count frequencies. Use a min-heap of size k ordered by frequency.
 *   Evict the minimum when size exceeds k. What remains are the top k.
 *
 * Approach B (bucket sort, O(n)):
 *   The frequency of any element is at most n.
 *   Create n+1 buckets indexed by frequency. Walk from high to low.
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();

        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2))); // [1, 2]
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1}, 1)));                 // [1]
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2))); // [-1, 2]
    }
}
