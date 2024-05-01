package DSA.arrays;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 5};
        int missingNumber = findMissingNumber(numbers);
        System.out.println("The missing number is: " + missingNumber);
    }

    private static int findMissingNumber(int[] numbers){
        //find the sum of the array
        int sumTotal = sumOfArrayWithoutMissingNumber(numbers);
        int sum = sumWithMissingNumber(numbers);
        return sumTotal - sum;
    }
    private static int sumOfArrayWithoutMissingNumber(int[] array){
        //1, 2, 3, 4, 5
        int n = array.length + 1;
        return n *(n + 1)/2;
    }
    private static int sumWithMissingNumber(int[] numbers){
        return Arrays.stream(numbers).sum();
    }
}
