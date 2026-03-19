import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 4;

        int result = binSearch(arr, target);
        System.out.println(result);
    }

    public static int binSearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        //[4]
        //mid ->
        while(left <= right){
            int mid = left + (right - left) /2;
            //check if that middle element is our target
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
