package LinkedList;

public class Circular_LL {


    Node head;
    Node tail;


    // displaying all the elements of the doubly linkedlist

    public void displayElement(){
        Node temp = head;
        do{
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }while(temp != head);
    }
    // insertion at the beginning of list
    public void insertBeginning(int data){
        Node newElement = new Node(data);
        if(head == null){
            head = newElement;
            tail = newElement;
        }
        tail.next = newElement;
        newElement.next = head;
        tail = newElement;

    }

    class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
        }
        Node(int data, Node next, Node prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}
