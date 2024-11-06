package dsa.linkedList.SinglyLinkedlist;

public class Main {
    public static void main(String[] args) {

       SingleLinkedList list = new SingleLinkedList();
       list.append(20);
       list.append(30);
       list.append(40);
       list.append(30);
       list.printList();
       System.out.println();
       list.deleteWithValue(30);
       list.printList();
    }
}
