package dsa.arrays;

public class SecondMaximumElement {
    public static void main(String[] args) {
        int[] array = {5, 3, 7, 2, 90, 8};
        int secondMaximum = findSecondMaximumElement(array);
        System.out.println("The second maximum number is " + secondMaximum);
    }

    private static int findSecondMaximumElement(int[] array) {
        //set the initial max and second max elements
        int maxNumber = Integer.MIN_VALUE;
        int secondMaxNumber = Integer.MIN_VALUE;
        //iterate through the array comparing the numbers
        for (int j : array) {
            if (j > maxNumber) {
                //set the max number to second max
                secondMaxNumber = maxNumber;
                maxNumber = j;
            } else if (j > secondMaxNumber || j != maxNumber) {
                secondMaxNumber = j;
            }
        }
        return secondMaxNumber;
    }
}
