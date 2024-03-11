package DSA;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 5, 2, 8, 7};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr){
        //iterate through the array
        //4, 3, 6, 2
        for (int i = 0; i < arr.length; i++) {//1
            int ref = arr[i];//4//3
            int j = i - 1;// 0-1=-1//0
            while(j>=0 && arr[j]>ref){//true
                arr[j+1] = arr[j];//
                j--;
            }
            arr[j+1] = ref;//4
        }
    }
}
