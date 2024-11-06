package DSA.LinkedList.SinglyLinkedlist;

public class SingleLinkedList {
    private Node head;

    //add node at the end
    public void append(int data){
        //create new node instance
        Node newNode = new Node(data);
        //check if the head is null, assign the data there
        if(head == null){
            head = newNode;
            return;
        }
        //if not null, traverse to the last node
        Node currentNode = head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        //link the new node at the end
        currentNode.next = newNode;
    }
    
}