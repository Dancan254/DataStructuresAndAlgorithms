package dsa;

import java.util.HashSet;

public class LongestSubString {
    public static void main(String[] args) {
        String test = "abcabdcab";
        int result = lengthOfLongestSubString(test);
        System.out.println("Longest Substring length: "+ result);

    System.out.println("Using hashset: " + longestSubString(test));
    }

    public static int longestSubString(String s){
       int left = 0;
       int right = 0;
       int maxLength = 0;
       int length = s.length();
       HashSet<Character> set = new HashSet<>();
        while(right < length){
            char c = s.charAt(right);
            if (!set.contains(c)){
                set.add(c);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            }
            else{
                set.remove(c);
                left++;
            }
        }
        return maxLength;
    }

    public static int maxSum(int[] arr, int k){
        int left = 0;
        int max_sum = 0;
        return -1;
    }


    public static int lengthOfLongestSubString(String s){
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            //create a string builder to hold the chars
            StringBuilder currentSubString = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                if (currentSubString.indexOf(String.valueOf(s.charAt(j))) != -1){
                    break;
                }
                currentSubString.append(s.charAt(j));
                System.out.println(currentSubString);
                maxLength = Math.max(maxLength, currentSubString.length());
            }
        }
        return maxLength;
    }
}
