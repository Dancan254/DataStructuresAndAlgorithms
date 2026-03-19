package dsa.arrays_hashing;

import java.util.*;

/**
 * LeetCode 347 — Top K Frequent Elements
 *
 * Given an integer array and k, return the k most frequent elements.
 *
 * Pattern: Frequency Count + Bucket Sort
 *
 * Approach A (heap): count frequencies, then use a min-heap of size k.
 *   Time O(n log k), Space O(n + k)
 *
 * Approach B (bucket sort): the frequency of any element is at most n.
 *   Create n+1 buckets indexed by frequency. Walk buckets from high to low.
 *   Time O(n), Space O(n) — optimal.
 */
public class TopKFrequent {

    // Approach A: min-heap — O(n log k)
    public int[] topKFrequentHeap(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);

        // Min-heap ordered by frequency — keeps only the k most frequent
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                Comparator.comparingInt(freq::get)
        );

        for (int key : freq.keySet()) {
            heap.offer(key);
            if (heap.size() > k) heap.poll(); // evict least frequent
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) result[i] = heap.poll();
        return result;
    }

    // Approach B: bucket sort — O(n)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);

        // Bucket index = frequency; a number appearing f times goes in bucket[f]
        @SuppressWarnings("unchecked")
        List<Integer>[] buckets = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int f = entry.getValue();
            if (buckets[f] == null) buckets[f] = new ArrayList<>();
            buckets[f].add(entry.getKey());
        }

        int[] result = new int[k];
        int idx = 0;
        // Iterate from highest frequency to lowest
        for (int f = buckets.length - 1; f >= 0 && idx < k; f--) {
            if (buckets[f] == null) continue;
            for (int num : buckets[f]) {
                result[idx++] = num;
                if (idx == k) break;
            }
        }
        return result;
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        TopKFrequent solution = new TopKFrequent();

        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2))); // [1, 2]
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1}, 1)));                 // [1]
    }
}
