package dsa.arrays.practice;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    public static void main(String[] args) {
        int[] nums = {2, 45, 11, 15, 7, 9};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
    //return the numbers that add up to the target

    public static int[] twoSum(int[] arr, int targetSum){
        int right = arr.length - 1;
        //create a map to store the elements
        Map<Integer, Integer> map = new HashMap<>();
        //iterate through tha array
        for (int i = 0; i <= right; i++) {
            int complement = targetSum - arr[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }
}
