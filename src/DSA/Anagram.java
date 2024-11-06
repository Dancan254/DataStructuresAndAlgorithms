package dsa;

import java.util.*;

public class Anagram {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> anagrams = findAnagrams(strs);
        System.out.println(anagrams);
        for (List<String> group : anagrams) {
            System.out.println(group);
        }
    }
    public static List<List<String>> findAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        //aet -> {eat, tea, ate}
        //ant ->
        for (String str : strs) {
            char[] charArray = str.toCharArray();//eat
            Arrays.sort(charArray);//-> aet
            String sortedStr = new String(charArray);//aet
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
