package DSA.arrays.linearSearch;

public class Demo {

    public static void main(String[] args) {
        int[] numbs = {5, 6, 7, 8, 9, 13};
        int target = 9;

        int result = linearSearch(numbs, target);
        System.out.println("Found at index " + result);
    }

    private static int linearSearch(int[] numbs, int target) {
        //iterate
        int steps = 0;
        for (int i = 0; i < numbs.length; i++) {
            steps ++;
            //check if equal
            if (numbs[i]== target) {
                System.out.println("Steps taken " + steps);
                return i;
            }
        }
        System.out.println("Steps taken " + steps);
        return -1;
    }


}
