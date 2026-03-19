package dsa.arrays.practice;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5,6};
        reverseArray(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    private static void reverseArray(int[] array, int start, int end) {
        while(start < end){
            swapElements(array, start, end);
            start++;
            end--;
        }
    }

    private static void swapElements(int[] array, int start, int end){
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }
}
