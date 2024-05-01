package DSA.LinkedList.SinglyLinkedlist;

public class SingleLinkedList {
    private ListNode head;

    public void printElements(){
        ListNode node = head;
        while(node != null){
            System.out.print(node.data + "=>");
            node = node.next;
        }
        System.out.print("null");
    }

    public int length() {
        if (head == null){
            return 0;
        }
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public void insertElementAtFirstIndex(int value){
        ListNode node = new ListNode(value);
        node.next = head;
        head = node;
    }
    public void insertElementAtEnd(int value){
        ListNode node = new ListNode(value);
        //check if the head is null
        if (head == null){
            head = node;
            return;
        }
        //if head is not null
        ListNode currentNode = head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = node;
    }

    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }


    }

    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        //create the nodes
        linkedList.head = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        ListNode fourth = new ListNode(40);

        //link the nodes
        linkedList.head.next = second;
        second.next = third;
        third.next = fourth;

        //the fourth with automatically point to null
        //size
        int length = linkedList.length();
        System.out.println("LinkedList size is " + length);

        //insert element
        linkedList.insertElementAtFirstIndex(26);
        linkedList.insertElementAtFirstIndex(15);
        linkedList.insertElementAtFirstIndex(90);

        //push to end
        linkedList.insertElementAtEnd(45);
        linkedList.printElements();
    }

}