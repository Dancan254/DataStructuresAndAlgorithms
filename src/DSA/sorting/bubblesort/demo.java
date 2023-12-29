package DSA.sorting.bubblesort;

import java.util.Arrays;

public class demo {

    public static void main(String[] args) {
        int[] arr = {8, 6, 9, 2, 4, 5};
        System.out.println("Before sorting");
        System.out.println(Arrays.toString(arr));
        System.out.println();
        System.out.println("After sorting");
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void bubbleSort(int[] arr) {
        //start
        int start = 0;
        int end = arr.length - 1;
        int temp = 0;
        //iterate through the array while comparing
        //outer loops is responsible for the number of iterations
        //inner loop is responsible for swapping
        for (int i = 0; i < arr.length; i++) {
            boolean swapped= false;
            for (int j = 0; j < arr.length-i-1; j++) {
                //8, 6, 9, 2, 4, 5
                if (arr[j] > arr[j + 1]) {
                    //switch
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped in the inner loop, the array is already sorted
            if (!swapped) {
                System.out.println("sorted already");
                break;
            }
            }
    }

}
