package DSA.arrays;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a word: ");
        String name = input.nextLine();
        System.out.println("is " + name + " a palindrome? => " + isPalindrome(name));
        input.close();
    }

    private static boolean isPalindrome(String word) {
        //convert string to an array of characters
        char[] chars = word.toCharArray();
        //start index of the array
        int start = 0;
        //end index of the array
        int end = chars.length-1;
        if (word.length() == 1){
            return true;
        }
        while(start < end){
            //compare the first and last character
            if (chars[start] == chars[end]){
                return true;
            }
            start++;
            end--;
        }
        return false;
    }
}
