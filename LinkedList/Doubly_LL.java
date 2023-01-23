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
        System.out.println( "END OF DLL" );

        while(temp2 != null){
            System.out.print(temp2.data + "->");
            temp2 = temp2.prev;
        }System.out.println( "END OF DLL" );
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

    }
// inserting at the End
    public void insertAtEnd(int data){
        if(head == null) insertAtFirst(data);
        else {
            Node newElement = new Node(data);
            Node temp = head;
            while(temp != null){
                temp = temp.next;
            }


        }

    }


    Node head;



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
