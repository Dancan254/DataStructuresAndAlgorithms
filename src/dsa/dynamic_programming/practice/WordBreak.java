package dsa.dynamic_programming.practice;

import java.util.List;

/**
 * LeetCode 139 — Word Break
 * https://leetcode.com/problems/word-break/
 *
 * Given a string s and a dictionary of strings wordDict, return true if s can
 * be segmented into one or more space-separated dictionary words.
 *
 * Example 1:
 *   Input:  s = "leetcode", wordDict = ["leet","code"]
 *   Output: true   ("leet" + "code")
 *
 * Example 2:
 *   Input:  s = "applepenapple", wordDict = ["apple","pen"]
 *   Output: true   ("apple" + "pen" + "apple")
 *
 * Example 3:
 *   Input:  s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 *   Output: false
 *
 * Constraints:
 *   - 1 <= s.length <= 300
 *   - 1 <= wordDict.length <= 1000
 *   - 1 <= wordDict[i].length <= 20
 *
 * Hint: dp[i] = true if s[0..i-1] can be segmented.
 *       dp[0] = true (empty string).
 *       For each i, try all split points j < i:
 *         if dp[j] is true AND s.substring(j, i) is in the dictionary, set dp[i] = true.
 *       Put the dictionary in a HashSet for O(1) lookup.
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        WordBreak solution = new WordBreak();

        System.out.println(solution.wordBreak("leetcode", List.of("leet", "code")));         // true
        System.out.println(solution.wordBreak("applepenapple", List.of("apple", "pen")));    // true
        System.out.println(solution.wordBreak("catsandog", List.of("cats","dog","sand","and","cat"))); // false
    }
}
