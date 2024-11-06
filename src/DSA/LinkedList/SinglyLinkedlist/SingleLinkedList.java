package dsa.linkedList.SinglyLinkedlist;

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

    //add new node to the beginning of the list
    public void prepend(int data){
        //create a new node instance with the data
        Node node = new Node(data);
        //set next of this new node to the current head
        node.next = head; //link node to the current head
        head = node;//update the head of the new node
    }

    //remove the first node in the list with specified data
    public void deleteWithValue(int data){
        //check if the list is empty, return if so
        if(head == null){
            return;
        }
        //if head contains the data, update the head to nextNode
        if(head.data == data){
            head = head.next;
            return;
        }
        //traverse until you find a node whose next contains the data
        Node current = head;
        while (current.next != null) { 
            if(current.next.data == data){
                current.next = current.next.next; //skip over the node
                return;
            }
            else current = current.next;
        }
    
    }

    //print list elements
    public void printList(){
        //traverse
        Node current = head;
        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.print("null");
    }
    
}