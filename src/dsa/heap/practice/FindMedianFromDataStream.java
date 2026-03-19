package dsa.heap.practice;

/**
 * LeetCode 295 — Find Median from Data Stream
 * https://leetcode.com/problems/find-median-from-data-stream/
 *
 * Design a data structure that supports:
 *   - addNum(int num): add an integer to the data structure
 *   - findMedian(): return the median of all elements so far
 *
 * If the total count is even, the median is the average of the two middle values.
 *
 * Example:
 *   addNum(1)   →  data = [1]
 *   addNum(2)   →  data = [1, 2]
 *   findMedian()  →  1.5
 *   addNum(3)   →  data = [1, 2, 3]
 *   findMedian()  →  2.0
 *
 * Constraints:
 *   - -10^5 <= num <= 10^5
 *   - At least one element before calling findMedian()
 *   - findMedian() calls <= 5 * 10^4
 *
 * Hint: Maintain two heaps:
 *   - A max-heap for the lower half (so you can access the largest in O(1))
 *   - A min-heap for the upper half (so you can access the smallest in O(1))
 *   Invariant: lower.size() == upper.size()  OR  lower.size() == upper.size() + 1
 *   The median is lower.peek() when sizes differ, or the average of both tops.
 */
public class FindMedianFromDataStream {

    // TODO: declare your heap fields here

    public FindMedianFromDataStream() {
        // TODO: initialise your heaps
    }

    public void addNum(int num) {
        // TODO: implement — add num, then rebalance
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public double findMedian() {
        // TODO: implement — return median based on heap sizes
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        FindMedianFromDataStream mf = new FindMedianFromDataStream();

        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian()); // 1.5

        mf.addNum(3);
        System.out.println(mf.findMedian()); // 2.0

        mf.addNum(4);
        System.out.println(mf.findMedian()); // 2.5
    }
}
