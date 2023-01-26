package LinkedList;

public class Circular_LL {


    Node head;
    Node tail;
    int size = 0;

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
        size++;
    }
    public void insertMiddle(int data, int index){

        if(index == 0) {
            insertBeginning(data);
            return;
        }
        if(index == size-1) {
            insertEnd(data);
            return;
        }

        Node temp = head;
        for(int i=1;i < index; i++){            // traverse till the desired location
            temp = temp.next;
        }
        Node newElement = new Node(data, temp.next);  // create a Node with data and it's next location
        temp.next = newElement;
        size++;
    }

    public void insertEnd(int data){
        Node newElement = new Node(data);
        tail.next = newElement;
        newElement.next = head;
        newElement.prev = tail;
        tail = newElement;
        size++;
    }
    public void deleteFirst(){
        head = head.next;
        tail.next = head;
    }
    public void deleteLast()
    {

        tail = tail.prev;
        tail.prev.next = head;
    }

    class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
        }
        Node(int data, Node next){
            this.data = data;
            this.next = next;

        }
    }
}
