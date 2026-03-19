package dsa.arrays_hashing.practice;

import java.util.List;

/**
 * LeetCode 49 — Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 *
 * Given an array of strings, group the anagrams together.
 * The answer can be returned in any order.
 *
 * Example:
 *   Input:  ["eat","tea","tan","ate","nat","bat"]
 *   Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Constraints:
 *   - 1 <= strs.length <= 10^4
 *   - 0 <= strs[i].length <= 100
 *   - strs[i] consists of lowercase English letters
 *
 * Hint: Two strings are anagrams when they share the same "signature".
 *       What could you use as a signature? Think about sorting each string's
 *       characters — anagrams produce the same sorted result.
 *       Then group all strings by their signature using a HashMap.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();

        List<List<String>> result = solution.groupAnagrams(
            new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}
        );
        for (List<String> group : result) {
            System.out.println(group); // [eat, tea, ate], [tan, nat], [bat] (order may vary)
        }

        System.out.println("---");

        List<List<String>> result2 = solution.groupAnagrams(new String[]{""});
        System.out.println(result2); // [[""]]

        List<List<String>> result3 = solution.groupAnagrams(new String[]{"a"});
        System.out.println(result3); // [["a"]]
    }
}
