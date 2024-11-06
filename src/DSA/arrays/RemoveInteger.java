package dsa.arrays;

import java.util.Arrays;

public class RemoveInteger {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 6, 8, 9,0};
        int[] oddArray = removeEvenNumber(array);
        System.out.println(Arrays.toString(oddArray));
    }
    public static int[] removeEvenNumber(int[] arr){
        //odd count
        int oddCount = 0;
        for (int j : arr) {
            if (j % 2 != 0) {
                oddCount++;
            }
        }
        //new array to hold the odd numbers
        int[] oddArr = new int[oddCount];
        int oddIndex = 0;
        //map the elements in each index
        for (int j : arr) {
            if (isOdd(j)) {
                oddArr[oddIndex] = j;
                oddIndex++;
            }
        }
        return oddArr;
    }
    public static boolean isOdd(int num){
        return num % 2 != 0;
    }
}
