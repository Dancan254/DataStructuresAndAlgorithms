package dsa;

import java.util.HashSet;

public class LongestSubString {
    public static void main(String[] args) {
        String test = "abcabdcab";
        int result = lengthOfLongestSubString(test);
        System.out.println("Longest Substring length: "+ result);
    }

    public static int longestSubString(String s){
       int left = 0;
       int maxLength = 0;
       HashSet<Character> set = new HashSet<>();
        for ( int right = 0; right < s.length(); right++) {
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxLength = Math.max(maxLength, right-left+1);
            }
            else {
               //while()
            }
        }
        return 0;
    }

    public static int maxSum(int[] arr, int k){
        int left = 0;
        int max_sum = 0;
        return -1;
    }

    //this has o(n^2)
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
