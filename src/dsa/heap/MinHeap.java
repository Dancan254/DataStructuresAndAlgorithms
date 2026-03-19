package dsa.heap;

import java.util.Arrays;

/**
 * Complete Min-Heap implementation backed by an integer array.
 *
 * Demonstrates: insert (sift-up), extractMin (sift-down), peek,
 *               buildHeap (Floyd's O(n) algorithm), and heapSort.
 *
 * Index relationships for node at index i (0-based):
 *   Parent:      (i - 1) / 2
 *   Left child:  2 * i + 1
 *   Right child: 2 * i + 2
 */
public class MinHeap {

    private int[] data;
    private int size;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    MinHeap() { this(16); }
    MinHeap(int capacity) { data = new int[capacity]; }

    /** Build a min-heap from an existing array in O(n) using Floyd's algorithm. */
    MinHeap(int[] arr) {
        data = Arrays.copyOf(arr, arr.length);
        size = arr.length;
        buildHeap();
    }

    // -------------------------------------------------------------------------
    // Insert
    // -------------------------------------------------------------------------

    /** Insert a value. O(log n) */
    public void insert(int val) {
        if (size == data.length) resize();
        data[size] = val;
        siftUp(size);
        size++;
    }

    private void siftUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (data[i] < data[parent]) {
                swap(i, parent);
                i = parent;
            } else break;
        }
    }

    // -------------------------------------------------------------------------
    // Extract Min
    // -------------------------------------------------------------------------

    /** Remove and return the minimum element (root). O(log n) */
    public int extractMin() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        int min = data[0];
        data[0] = data[--size]; // replace root with last element
        siftDown(0);
        return min;
    }

    private void siftDown(int i) {
        while (true) {
            int smallest = i;
            int left  = 2 * i + 1;
            int right = 2 * i + 2;

            if (left  < size && data[left]  < data[smallest]) smallest = left;
            if (right < size && data[right] < data[smallest]) smallest = right;

            if (smallest == i) break; // heap property satisfied
            swap(i, smallest);
            i = smallest;
        }
    }

    // -------------------------------------------------------------------------
    // Peek
    // -------------------------------------------------------------------------

    /** Return the minimum element without removing it. O(1) */
    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        return data[0];
    }

    // -------------------------------------------------------------------------
    // Build Heap — Floyd's Algorithm O(n)
    // -------------------------------------------------------------------------

    /**
     * Convert an arbitrary array into a valid heap in O(n).
     * Start from the last internal node and sift each down.
     * Most nodes are leaves and require no sifting — hence O(n) not O(n log n).
     */
    private void buildHeap() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    // -------------------------------------------------------------------------
    // Heap Sort (Max-Heap based, sorts ascending)
    // -------------------------------------------------------------------------

    /**
     * Sort an array in ascending order using heap sort. O(n log n), O(1) space.
     * Uses a max-heap internally so the largest elements bubble to the end.
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: build max-heap (siftDown with max-heap condition)
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDownMax(arr, i, n);
        }

        // Step 2: extract max one by one — swap root to end, shrink heap
        for (int i = n - 1; i > 0; i--) {
            int tmp = arr[0]; arr[0] = arr[i]; arr[i] = tmp; // swap max to end
            siftDownMax(arr, 0, i);
        }
    }

    private static void siftDownMax(int[] arr, int i, int size) {
        while (true) {
            int largest = i;
            int left  = 2 * i + 1;
            int right = 2 * i + 2;
            if (left  < size && arr[left]  > arr[largest]) largest = left;
            if (right < size && arr[right] > arr[largest]) largest = right;
            if (largest == i) break;
            int tmp = arr[i]; arr[i] = arr[largest]; arr[largest] = tmp;
            i = largest;
        }
    }

    // -------------------------------------------------------------------------
    // Utility
    // -------------------------------------------------------------------------

    public boolean isEmpty() { return size == 0; }
    public int size()        { return size; }

    private void swap(int i, int j) {
        int tmp = data[i]; data[i] = data[j]; data[j] = tmp;
    }

    private void resize() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    public void print() {
        System.out.println(Arrays.toString(Arrays.copyOf(data, size)));
    }

    // -------------------------------------------------------------------------
    // Demo
    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println("=== Min-Heap Insert ===");
        MinHeap heap = new MinHeap();
        for (int v : new int[]{5, 3, 8, 1, 9, 2, 7}) heap.insert(v);
        heap.print(); // [1, 3, 2, 5, 9, 8, 7]  (valid min-heap)

        System.out.println("Peek: " + heap.peek());          // 1
        System.out.println("ExtractMin: " + heap.extractMin()); // 1
        System.out.println("Peek: " + heap.peek());          // 2
        heap.print();

        System.out.println("\n=== Build Heap from Array (Floyd) ===");
        MinHeap fromArray = new MinHeap(new int[]{9, 4, 7, 1, 8, 3, 6});
        fromArray.print(); // valid min-heap arrangement

        System.out.println("\n=== Heap Sort ===");
        int[] arr = {5, 3, 8, 1, 9, 2, 7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 5, 7, 8, 9]
    }
}
