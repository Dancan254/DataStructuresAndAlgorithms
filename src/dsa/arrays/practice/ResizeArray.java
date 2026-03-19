package dsa.arrays.practice;

public class ResizeArray {
    public static void main(String[] args) {
        int[] array = new int[5];
        System.out.println("Size before resizing " + array.length);
        int[] arr = resizeArray(array, 10);
        System.out.println("Size after resizing " +arr.length);
    }

    private static int[] resizeArray(int[] array, int resizeLength) {
        //create a temp array
        int[] temp = new int[resizeLength];
        //map the elements from initial array
        /*
        for(int i = 0;i<array.length;i++){
            temp[i] = array[i];
         }
         */
        System.arraycopy(array, 0, temp, 0, array.length);
        array = temp;
        return array;
    }
}
