package DSA.arrays;

public class MinimumValue {
    public static void main(String[] args) {
        int[] array = {5, 3, 7, 2, 90, 8};
        int minValue = findMinimumValue(array);
        System.out.println("The minimum value is: " + minValue);

    }

    private static int findMinimumValue(int[] array) {
        //edge cases
        if (array == null || array.length == 0){
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        //set the first num as min
        int min = array[0];
        //iterate through the array comparing with other numbers
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]){
                min = array[i];
            }
        }
        return min;
    }
}
