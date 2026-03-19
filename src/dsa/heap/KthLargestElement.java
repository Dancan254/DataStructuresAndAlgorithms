package dsa.heap;

import java.util.PriorityQueue;

/**
 * LeetCode 215 — Kth Largest Element in an Array
 *
 * Find the k-th largest element (not k-th largest distinct element).
 *
 * Pattern: Min-heap of size k
 *
 * Keep a min-heap of the k largest elements seen so far.
 * When size exceeds k, evict the heap's minimum (currently the smallest
 * of the k candidates). After all elements are processed, the heap top
 * is the k-th largest overall.
 *
 * Time:  O(n log k)
 * Space: O(k)
 */
public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest — keeps k largest in heap
            }
        }

        return minHeap.peek(); // smallest of the k largest = k-th largest overall
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        KthLargestElement solution = new KthLargestElement();

        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)); // 5
        System.out.println(solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)); // 4
    }
}
