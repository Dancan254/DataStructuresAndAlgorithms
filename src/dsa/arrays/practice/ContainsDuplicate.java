package dsa.arrays.practice;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(containsDuplicate(arr));
    }

    public static boolean containsDuplicate(int[] arr){
        // 1, 2, 3, 1
        Set<Integer> unique = new HashSet<>();
        for (int j : arr) {
            if(!unique.add(j)) return true;
        }
        return false;
    }
}
