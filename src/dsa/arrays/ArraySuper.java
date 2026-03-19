package dsa.arrays;

public class ArraySuper {
    private long[] array;
    private int numberOfElements;

    public ArraySuper(int max){
        array = new long[max];
        numberOfElements = 0;
    }

    public int size(){
        return numberOfElements;
    }

    public int find(long targetElement){
        //we'll use bin search
        int lowerBound = 0;
        int upperBound = numberOfElements - 1;
        int mid = 0;
        while(lowerBound < upperBound){
            mid = (lowerBound + upperBound)/2;
            if (array[mid] == targetElement){
                return mid;
            } else if (array[mid] < targetElement) {
                lowerBound = mid + 1;
            }
            else {
                upperBound = mid - 1;
            }
        }
        return -1;
    }

    public void insertAtEnd(long value){
        if (numberOfElements < array.length){
            array[numberOfElements] = value;
            numberOfElements++;
        }
        System.out.println("Array is full, cannot insert more elements");
    }

    public void insertForOrderedArray(int value){
        if (numberOfElements < array.length){
            //find the correct position to insert the element
            int i;
            for (i = numberOfElements - 1; i>=0; i--){
                if (array[i] > value){
                    array[i+1] = array[i];
                }else{
                    break;
                }
            }
                array[i+1] = value;
            numberOfElements++;
            }
        else{
            System.out.println("Array is full");
        }
    }

    public void delete(long value){
        int index = find(value);
        if(index != -1){
            for (int i = index; i < numberOfElements - 1; i++) {
                array[i] = array[i+1];
            }
            numberOfElements--;
        }
        System.out.println("Element not found");
    }
}
