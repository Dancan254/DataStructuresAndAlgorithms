package dsa.arrays.practice;

public class BrickBalancing {
    public static void main(String[] args) {
        int[] arr1 = {11, 10, 8, 12, 8, 10, 11};
        long startTime = System.nanoTime();
        int moves = leastMoves(arr1);
        long duration = startTime - System.currentTimeMillis();
        System.out.println("Moves  = " + moves);
        System.out.println("Total time taken: " + duration);
    }

    public static int leastMoves(int[] arr){
        int n = arr.length;
        //find the sum
        int sum = 0;
        for (int num : arr){
            sum +=num;
        }
        //check if equal to the nums * 10
        if(sum % (10*n) != 0){
            return -1;
        }
        int moves = 0;
        int cumulative = 0;
        for (int j : arr) {
            cumulative += j - 10;
            System.out.println(cumulative);
            moves += Math.abs(cumulative);
            System.out.println(moves);
        }
        return moves;
    }

}
