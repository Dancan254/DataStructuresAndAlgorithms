package dsa;

import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        String name = "Ian";
        int phoneNumber = 792;

        map.put(name, phoneNumber);
        map.put("Dan", 890);
        map.put("MOngs", 890);

        //lets get the phone number of mongs
        int result = map.get("Ian");
        int result2 = map.getOrDefault("Mongare", 0);
        System.out.println(result2);

        boolean hasPeris = map.containsKey("Peris");
        System.out.println("Does it have key peris? " + hasPeris);

        boolean hasPerisNumber = map.containsValue(890);
        System.out.println("Does it have value 890? " + hasPerisNumber);

        //int removed = map.remove("Mongsre");
        //int removeAgain = map.remove("Ian");
        //System.out.println("removed: " + removed);
        //System.out.println("removeAgain: " + removeAgain);

        int count = map.size();
        System.out.println("Size: " + count);

        boolean isEmpty = map.isEmpty();
        System.out.println("Is empty: " + isEmpty);

        //iterate keys only
        for(String key : map.keySet()){
            System.out.println("Key: " + key);
        }

        //iterate the values
        for(int value : map.values()){
            System.out.println("Value: " + value);
        }

        //iterate with both key and value
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

        //say we have a map and we want to add a value now sure whether or not it exists
       map.putIfAbsent("Ann", 990);
        System.out.println(map);

        //using compute if absent
        //before it you would find yourself doing this
        if(!map.containsKey("champez")){
            map.put("champez", 999);
        }
        //then you'd return or do whatever you wanted with the value
        //now lets say you are building a map of lists
        Map<String, List<String>> mapOfLists = new HashMap<>();

        List<String> fruits = mapOfLists.computeIfAbsent("fruit",  k -> new ArrayList<>());
        fruits.add("apple");
        fruits.add("banana");

        System.out.println("Using computeIfAbsent:");
        System.out.println(mapOfLists);

        //use it for counting
        Map<String, Integer> score = new HashMap<>();
        score.computeIfAbsent("mongs", k -> 0);
        System.out.println(score);
        score.put("mongs", score.get("mongs") + 1);
        System.out.println(score);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        //a map to store the anagrams
        Map<String, List<String>> map = new HashMap<>();
        //iterate through the array
        for(String str : strs){
            //convert each string to a char array
            char[] chars = str.toCharArray();
            //sort the char
            Arrays.sort(chars);
            //have it back to a string
            String sortedStr = new String(chars);
            //now we check if it is in our map
            /*
            if (!map.containsKey(sortedStr)){
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
             */
            map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static int[] twoSum(int[] nums, int target){
        //key, value -> num index
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            // 2, 7, 11, 15
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
