package dsa.sorting.selectiosort;

import java.util.Arrays;

public class demo {

    public static void main(String[] args) {
        int[] arr = {8, 6, 9, 2, 4, 5};
        System.out.println("Before sorting");
        System.out.println(Arrays.toString(arr));
        System.out.println();
        System.out.println("After sorting");
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));


    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;
            //find max element
            int maxIndex = getMax(arr, 0, last);
            swap(arr, maxIndex, last);
        }
    }

    //method to get max number
    public static int getMax(int[] arr, int start, int end){
        int max = start;
        for (int i = start; i <= end; i++) {
            if (arr[max] < arr[i]){
                max = i;
            }
        }
        return max;
    }

    public static void swap(int[]arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void selectionSort2(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
