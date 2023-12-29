package DSA.arrays.binarysearch;

public class Demo {
    public static void main(String[] args) {
        int[] numbs = {5, 6, 7, 8, 9, 13};
        int target = 9;

        int result = binarySearch(numbs, target);
        System.out.println("Found at index " + result);
    }

    private static int binarySearch(int[] numbs, int target) {
        //iterate
        //starting point
        int left = 0;
        //ending point
        int right = numbs.length - 1;
        while (left <= right){
            //mid
            int mid = (left+right)/2;
            //check if middle value matches the target
            if (numbs[mid] == target){
                return mid;
            } else if (numbs[mid] < target) {
                left++;
            }
            else {
                right--;
            }
        }
        return -1;
    }

}
