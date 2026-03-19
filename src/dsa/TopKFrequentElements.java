package dsa;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequentElements1(nums, k)));
    }

    private static int[] topKFrequentElements1(int[] arr, int k){
        //create the map to track frequencies
        Map<Integer, Integer> map = new HashMap<>();
        //count the frequencies
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //create a list of num and its frequency
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        //sort list based on frequency -> descending
        entries.sort((a, b) -> b.getValue() - a.getValue());

        //take the first k elements
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = entries.get(i).getKey();
        }
        return result;
    }
}
