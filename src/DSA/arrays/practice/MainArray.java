package dsa.arrays.practice;

import java.util.Arrays;

public class MainArray {
    public static void main(String[] args) {
        //jagged array-> an 2d array with uneven length
        int[][] jaggedArray = new int[3][]; //the number must be specified
        jaggedArray[0] = new int[2];
        jaggedArray[1] = new int[4];
        jaggedArray[2] = new int[3];
        //each column will have values as zeros
        System.out.println(Arrays.deepToString(jaggedArray));

        //more concise way of doing it
        int[][] triangle = {
                {1},
                {1, 2},
                {1, 2, 3}
        };
        //Array copying
        int[] original = {1, 2, 3,4, 5};
        int[] destination = new int[5];
        System.arraycopy(original, 0, destination, 0, original.length);

        //create a new array of specified length
        int[] destination2 = Arrays.copyOf(original, original.length);

        //clone -> creates a shallow copy
        int[] destination3 = original.clone();

        //copy a specific range
        int[] partial = Arrays.copyOfRange(original, 1, 4);
    }
}
