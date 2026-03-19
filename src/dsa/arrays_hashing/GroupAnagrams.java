package dsa.arrays_hashing;

import java.util.*;

/**
 * LeetCode 49 — Group Anagrams
 *
 * Given an array of strings, group the anagrams together.
 *
 * Pattern: Group by Signature
 *
 * Two words are anagrams if they contain the same characters with the same
 * frequencies. A canonical "signature" for each word lets us group them.
 *
 * Approach A (sort-based): sort each word's characters — O(k log k) per word.
 * Approach B (count-based): build a frequency key string — O(k) per word.
 *
 * Time:  O(n * k log k) — Approach A, where n = number of strings, k = max length
 * Space: O(n * k)
 */
public class GroupAnagrams {

    // Approach A: sorted character array as key
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // computeIfAbsent initialises a new list only if the key is absent
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(groups.values());
    }

    // Approach B: frequency count as key — O(n * k), avoids sorting
    public List<List<String>> groupAnagramsLinear(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) count[c - 'a']++;

            // Build a key like "1#0#2#..." to uniquely represent the frequency
            StringBuilder sb = new StringBuilder();
            for (int n : count) sb.append(n).append('#');
            String key = sb.toString();

            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(groups.values());
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();

        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(input);
        for (List<String> group : result) {
            System.out.println(group);
        }
        // [eat, tea, ate], [tan, nat], [bat]  (order may vary)
    }
}
