package dsa.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Complete Trie (Prefix Tree) implementation.
 *
 * A trie stores strings character by character. Each node represents one
 * character in the path from root. Nodes share common prefixes.
 *
 * Supports: insert, search (exact), startsWith (prefix), delete,
 *           autocomplete (list all words with a given prefix).
 *
 * Time complexity per operation: O(k) where k = word/prefix length.
 * Space: O(ALPHABET_SIZE * n * k) in the worst case.
 */
public class Trie {

    private static final int ALPHABET = 26;

    // -------------------------------------------------------------------------
    // Inner Node class
    // -------------------------------------------------------------------------

    private static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET];
        boolean isEnd = false;
        int wordCount = 0; // number of words passing through or ending at this node
    }

    // -------------------------------------------------------------------------

    private final TrieNode root = new TrieNode();

    // -------------------------------------------------------------------------
    // Insert
    // -------------------------------------------------------------------------

    /** Insert a word into the trie. O(k) */
    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) curr.children[i] = new TrieNode();
            curr = curr.children[i];
            curr.wordCount++;
        }
        curr.isEnd = true;
    }

    // -------------------------------------------------------------------------
    // Search
    // -------------------------------------------------------------------------

    /** Return true if the exact word exists in the trie. O(k) */
    public boolean search(String word) {
        TrieNode node = traverse(word);
        return node != null && node.isEnd;
    }

    /**
     * Return true if any word in the trie starts with the given prefix.
     * O(k)
     */
    public boolean startsWith(String prefix) {
        return traverse(prefix) != null;
    }

    /** Navigate to the end of the given string. Returns null if the path doesn't exist. */
    private TrieNode traverse(String s) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) return null;
            curr = curr.children[i];
        }
        return curr;
    }

    // -------------------------------------------------------------------------
    // Autocomplete
    // -------------------------------------------------------------------------

    /**
     * Return all words in the trie that begin with the given prefix.
     * O(k + total characters in matching words)
     */
    public List<String> autocomplete(String prefix) {
        List<String> results = new ArrayList<>();
        TrieNode node = traverse(prefix);
        if (node != null) dfs(node, new StringBuilder(prefix), results);
        return results;
    }

    private void dfs(TrieNode node, StringBuilder current, List<String> results) {
        if (node.isEnd) results.add(current.toString());
        for (int i = 0; i < ALPHABET; i++) {
            if (node.children[i] != null) {
                current.append((char) ('a' + i));
                dfs(node.children[i], current, results);
                current.deleteCharAt(current.length() - 1); // backtrack
            }
        }
    }

    // -------------------------------------------------------------------------
    // Delete
    // -------------------------------------------------------------------------

    /**
     * Remove a word from the trie. Does nothing if the word does not exist.
     * Cleans up nodes that are no longer part of any word. O(k)
     */
    public void delete(String word) {
        deleteRec(root, word, 0);
    }

    private boolean deleteRec(TrieNode node, String word, int depth) {
        if (node == null) return false;

        if (depth == word.length()) {
            if (!node.isEnd) return false; // word not present
            node.isEnd = false;
            return isEmpty(node); // true if node can be deleted
        }

        int i = word.charAt(depth) - 'a';
        boolean shouldDelete = deleteRec(node.children[i], word, depth + 1);

        if (shouldDelete) {
            node.children[i] = null;
            return !node.isEnd && isEmpty(node);
        }
        return false;
    }

    private boolean isEmpty(TrieNode node) {
        for (TrieNode child : node.children)
            if (child != null) return false;
        return true;
    }

    // -------------------------------------------------------------------------
    // Demo
    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("cat");
        trie.insert("car");
        trie.insert("card");
        trie.insert("care");
        trie.insert("bat");
        trie.insert("ball");

        System.out.println(trie.search("cat"));      // true
        System.out.println(trie.search("ca"));       // false (not a complete word)
        System.out.println(trie.startsWith("ca"));   // true
        System.out.println(trie.startsWith("xyz"));  // false

        System.out.println(trie.autocomplete("ca")); // [cat, car, card, care]
        System.out.println(trie.autocomplete("b"));  // [ball, bat]

        trie.delete("card");
        System.out.println(trie.search("card"));     // false
        System.out.println(trie.search("care"));     // true  (not affected)

        System.out.println(trie.autocomplete("ca")); // [cat, car, care]
    }
}
