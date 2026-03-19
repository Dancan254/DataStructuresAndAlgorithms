package dsa.arrays_hashing;

import java.util.ArrayList;
import java.util.List;

/**
 * Hash table implemented from scratch using separate chaining.
 *
 * Each bucket is a linked list of Entry nodes. On collision, the new entry is
 * prepended to the bucket's chain. Resizes (rehashes) when the load factor
 * exceeds 0.75 — doubling the number of buckets each time.
 *
 * Demonstrates: put, get, remove, contains, resize (rehash), load factor.
 *
 * Time: O(1) average for all operations, O(n) worst case (all keys in one bucket).
 * Space: O(n + capacity)
 *
 * This is a teaching implementation — use java.util.HashMap in production.
 */
public class HashTable<K, V> {

    // -------------------------------------------------------------------------
    // Entry (node in the chaining linked list)
    // -------------------------------------------------------------------------

    private static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key   = key;
            this.value = value;
        }
    }

    // -------------------------------------------------------------------------
    // Fields
    // -------------------------------------------------------------------------

    private static final int    DEFAULT_CAPACITY    = 16;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private Entry<K, V>[] buckets;
    private int            size;
    private final double   loadFactor;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    @SuppressWarnings("unchecked")
    public HashTable(int initialCapacity, double loadFactor) {
        this.buckets    = new Entry[initialCapacity];
        this.loadFactor = loadFactor;
    }

    public HashTable() { this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR); }

    // -------------------------------------------------------------------------
    // Hash Function
    // -------------------------------------------------------------------------

    /**
     * Map a key to a bucket index.
     * Using Math.abs is not fully safe for Integer.MIN_VALUE (overflows to negative),
     * so we mask the sign bit with & 0x7fffffff instead.
     */
    private int bucketIndex(K key) {
        return (key.hashCode() & 0x7fffffff) % buckets.length;
    }

    // -------------------------------------------------------------------------
    // Put
    // -------------------------------------------------------------------------

    /**
     * Insert or update a key-value pair. O(1) average.
     * If the key already exists its value is overwritten.
     * Triggers a resize when the load factor threshold is exceeded.
     */
    public void put(K key, V value) {
        int index = bucketIndex(key);
        Entry<K, V> curr = buckets[index];

        // Check if key already exists in the chain
        while (curr != null) {
            if (curr.key.equals(key)) {
                curr.value = value; // update existing
                return;
            }
            curr = curr.next;
        }

        // Prepend new entry to the bucket's chain
        Entry<K, V> entry = new Entry<>(key, value);
        entry.next    = buckets[index];
        buckets[index] = entry;
        size++;

        if ((double) size / buckets.length > loadFactor) resize();
    }

    // -------------------------------------------------------------------------
    // Get
    // -------------------------------------------------------------------------

    /** Return the value for the given key, or null if not present. O(1) average. */
    public V get(K key) {
        int index = bucketIndex(key);
        Entry<K, V> curr = buckets[index];
        while (curr != null) {
            if (curr.key.equals(key)) return curr.value;
            curr = curr.next;
        }
        return null;
    }

    public V getOrDefault(K key, V defaultValue) {
        V val = get(key);
        return val != null ? val : defaultValue;
    }

    // -------------------------------------------------------------------------
    // Remove
    // -------------------------------------------------------------------------

    /**
     * Remove the entry for the given key. Returns the removed value, or null
     * if the key was not present. O(1) average.
     */
    public V remove(K key) {
        int index = bucketIndex(key);
        Entry<K, V> curr = buckets[index];
        Entry<K, V> prev = null;

        while (curr != null) {
            if (curr.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = curr.next; // removing head of chain
                } else {
                    prev.next = curr.next;       // bypass removed node
                }
                size--;
                return curr.value;
            }
            prev = curr;
            curr = curr.next;
        }
        return null;
    }

    // -------------------------------------------------------------------------
    // Contains / Size / Empty
    // -------------------------------------------------------------------------

    public boolean containsKey(K key) { return get(key) != null; }
    public int     size()             { return size; }
    public boolean isEmpty()          { return size == 0; }

    // -------------------------------------------------------------------------
    // Resize (Rehash)
    // -------------------------------------------------------------------------

    /**
     * Double the bucket count and re-insert all existing entries.
     * Called when load factor exceeds the threshold.
     * O(n) — each entry is re-hashed and moved into the new array.
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        Entry<K, V>[] old = buckets;
        buckets = new Entry[old.length * 2];
        size    = 0; // put() will re-increment

        for (Entry<K, V> head : old) {
            Entry<K, V> curr = head;
            while (curr != null) {
                put(curr.key, curr.value); // re-hash into new buckets
                curr = curr.next;
            }
        }
    }

    // -------------------------------------------------------------------------
    // Keys / Values
    // -------------------------------------------------------------------------

    public List<K> keys() {
        List<K> result = new ArrayList<>();
        for (Entry<K, V> head : buckets) {
            Entry<K, V> curr = head;
            while (curr != null) {
                result.add(curr.key);
                curr = curr.next;
            }
        }
        return result;
    }

    public List<V> values() {
        List<V> result = new ArrayList<>();
        for (Entry<K, V> head : buckets) {
            Entry<K, V> curr = head;
            while (curr != null) {
                result.add(curr.value);
                curr = curr.next;
            }
        }
        return result;
    }

    // -------------------------------------------------------------------------
    // Diagnostics
    // -------------------------------------------------------------------------

    /** Show per-bucket chain lengths — useful for verifying distribution. */
    public void printDistribution() {
        for (int i = 0; i < buckets.length; i++) {
            int length = 0;
            Entry<K, V> curr = buckets[i];
            while (curr != null) { length++; curr = curr.next; }
            if (length > 0) System.out.println("bucket[" + i + "] length = " + length);
        }
        System.out.println("Total size=" + size + ", capacity=" + buckets.length
            + ", load=" + String.format("%.2f", (double) size / buckets.length));
    }

    // -------------------------------------------------------------------------
    // Demo
    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println("=== HashTable — Separate Chaining ===");
        HashTable<String, Integer> table = new HashTable<>(4, 0.75);

        table.put("apple",  1);
        table.put("banana", 2);
        table.put("cherry", 3);
        table.put("date",   4);
        table.put("elderberry", 5);
        table.put("fig",    6);

        System.out.println("get(apple):   " + table.get("apple"));    // 1
        System.out.println("get(cherry):  " + table.get("cherry"));   // 3
        System.out.println("get(missing): " + table.get("missing"));  // null
        System.out.println("getOrDefault: " + table.getOrDefault("missing", -1)); // -1

        table.put("apple", 99); // update
        System.out.println("after update, get(apple): " + table.get("apple")); // 99

        System.out.println("remove(banana): " + table.remove("banana")); // 2
        System.out.println("contains(banana): " + table.containsKey("banana")); // false
        System.out.println("size: " + table.size()); // 5

        System.out.println("\n--- Distribution after 6 puts into initial cap 4 (should have resized) ---");
        table.printDistribution();

        System.out.println("\n=== Frequency Count using HashTable ===");
        String sentence = "the quick brown fox jumps over the lazy dog";
        HashTable<Character, Integer> freq = new HashTable<>();
        for (char c : sentence.toCharArray()) {
            if (c == ' ') continue;
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        System.out.println("freq(t): " + freq.get('t')); // 2
        System.out.println("freq(o): " + freq.get('o')); // 4
        System.out.println("freq(z): " + freq.get('z')); // 1
    }
}
