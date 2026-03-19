package dsa.arrays.practice;

import java.util.ArrayList;

public class LongestPrefixSuffix {
    public static void main(String[] args) {
        String pattern = "aabaaac";
        ArrayList<Integer> lps = computeLPSArray(pattern);
        System.out.println(lps);

    }

    public static ArrayList<Integer> computeLPSArray(String pattern) {
        int n = pattern.length();
        ArrayList<Integer> lps = new ArrayList<>();
        for (int k = 0; k < n; k++) lps.add(0);
        // length of the previous longest prefix suffix
        //[0, 0, 0, 0, 0, 0, 0]
        int len = 0;
        int i = 1;
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps.set(i, len);
                //[0, 1]
                i++;
            } else {
                if (len != 0) {
                    // fall back in the pattern
                    //len = 1 -> get(0)
                    //len -> 0
                    len = lps.get(len - 1);
                } else {
                    //[0, 1, 0
                    lps.set(i, 0);
                    i++;
                    //i -> 3
                }
            }
        }

        return lps;
    }

}
