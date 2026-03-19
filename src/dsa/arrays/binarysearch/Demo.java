package dsa.arrays.binarysearch;

public class Demo {
    public static void main(String[] args) {
        int[] numbs = {5, 6, 7, 8, 9, 13};
        int target = 9;
        int result = binarySearch(numbs, target);
        System.out.println("Found at index " + result);
    }

    private static int binarySearch(int[] numbs, int target) {
        //steps
        int steps = 0;
        //starting point
        int left = 0;
        //ending point
        int right = numbs.length - 1;
        while (left <= right){
            //mid
            int mid = (left+right)/2;
            //check if middle value matches the target
            if (numbs[mid] == target){
                System.out.println("Steps taken " + steps);
                //return the index of the middle target element
                return mid;
            } else if (numbs[mid] < target) {
                left++;
            }
            else {
                right--;
            }
        }
        System.out.println("Steps taken " + steps);
        return -1;
    }
    //using recursion
    public static int binarySearch(int[] array, int target, int left, int right){
        if(left <= right){
            int mid = (left + right)/2;
            if (array[mid] == target){
                return mid;
            } else if (array[mid] < target) {
                return binarySearch(array,target, mid+1, right);
            }
            else{
                return binarySearch(array, target, left, mid-1);
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        // O(log n) - eliminate half each time
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;  // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return -1;
    }

// [1,3,5,7,9,11,13], target=7
// mid=6, nums[6]=13 > 7, search left
// mid=3, nums[3]=7 ✓ Found in 2 steps!
}
