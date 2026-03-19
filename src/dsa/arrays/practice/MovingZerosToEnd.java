package dsa.arrays.practice;

import dsa.sorting.selectiosort.Demo;

import java.util.Arrays;

public class MovingZerosToEnd {
    public static void main(String[] args) {
        int[] array = {2, 5, 0, 6, 0, 8, 0};
        moveZeroToTheEnd(array);
        System.out.println(Arrays.toString(array));
    }

    private static void moveZeroToTheEnd(int[] array) {
        //j represents zero elements
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            //check if the current element is zero
            if (array[i] != 0 && array[j] == 0){
                //swap with the next number
                Demo.swap(array, i, j);
            }
            if (array[j] != 0){
                j++;
            }

        }
    }
 
}
