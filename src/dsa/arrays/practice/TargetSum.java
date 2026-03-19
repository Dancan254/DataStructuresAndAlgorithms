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

    public int maxSum(int[] nums, int k) {
        // O(n) time, O(1) space
        int windowSum = 0;
        // First window
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        int maxSum = windowSum;
        // Slide the window
        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum - nums[i - k] + nums[i];
            //              subtract left      add right
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

// [2,1,5,1,3,2], k=3
// [2,1,5]=8 → 8-2+1=7 → 7-1+3=9 ✓
}
