package DSA.arrays.binarysearch;

import java.util.Scanner;

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
                System.out.println("Steps taken " + steps);
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
}
