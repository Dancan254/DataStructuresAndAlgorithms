package dsa;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        //add
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        //check if present
        boolean isPresent = set.contains(2);
        System.out.println(isPresent);
        System.out.println(set);
        set.add(4);
        System.out.println(set);
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
