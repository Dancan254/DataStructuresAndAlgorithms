package dsa.arrays;

import java.util.Arrays;

public class NotificationSplit {
    public static void main(String[] args) {
        String message = "I am boy";
        String[] messageArray = message.split(" ");
        System.out.println(Arrays.toString(messageArray));

    }
    public static String splitNotification(String message, int k){
        //if the message length is equal to our length
        if (message.length() <= k) return message;
        //ellipsis
        String ellipsis = " ...";
        String[] words = message.split(" ");
        return "";
    }
}
