package LinkedList;

public class Doubly_LL {
    // inserting a node in a doubly linkedlist


    public void displayElement(){
        Node temp = head;
        Node temp2 = head;
        while(temp != null){
            System.out.print(temp.data + "-> ");
            temp = temp.next;
            if(temp != null) temp2 = temp;
        }
        System.out.println( " END OF DLL " );

        while(temp2 != null){
            System.out.print(temp2.data + " -> ");
            temp2 = temp2.prev;
        }
        System.out.println( "END OF DLL" );

    }
    // inserting an element in starting
    public void insertAtFirst(int data)
    {
        Node newElement = new Node(data);

        if(head != null){
            newElement.next = head;
            head.prev = newElement;
        }
        head = newElement;
        size++;
    }
    // inserting at the End
    public void insertAtEnd(int data){
        if(head == null) insertAtFirst(data);
        else {
            Node newElement = new Node(data);
            Node temp = head;
            while(temp != null){
                if(temp.next == null) break;
                else temp = temp.next;
            }
            temp.next = newElement;
            newElement.prev = temp;
            newElement.next = null;
        }
        size++;
    }
    // insert middle element
    public void insertMiddleEle(int data, int index){
        if(index == 0) insertAtFirst(data);
        else if(index == size) insertAtEnd(data);
        else{int count=0;

            Node newElement = new Node(data);
            Node temp = head;
            while((count)!=index){
                temp = temp.next;
                count++;
            }
            newElement.next = temp.next.next;
            temp.next = newElement;
            newElement.prev = temp;

        }
    }
    public void deleteFirst(){
        head = head.next;
        head.prev = null;
    }
    public void deleteLast(){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.prev.next = null;
    }
    // will make a function that'll return a value/node at desired index and then we'll search or delete that..
    public void deleteMid(int index){

    }

    Node head;
    int size=0;


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
