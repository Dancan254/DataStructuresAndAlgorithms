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
       System.out.print(list.findByIndex(10));
       System.out.println();
       list.pop();
       list.printList();
    }
}
