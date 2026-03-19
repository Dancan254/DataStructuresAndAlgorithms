package dsa;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] nums = {10, 20, 25, 30};
        //access -> 30
        System.out.println(nums[3]); // -> O(1)
        //searching for a value -> 25 -> n
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == 25){
                System.out.println("Found at index: " + i);
                break;
            }
            System.out.println("Not found moving to the next");
        }
        //inserting at the end -> 0(1) -> if there is space -> 0(n) -> no space, resize

        int target = 15;

    }
    public static int[] twoSum(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i]  +  nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

}
