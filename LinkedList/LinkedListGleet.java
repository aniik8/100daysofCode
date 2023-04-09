package LinkedList;

public class LinkedListGleet {
    public  void main(String[] args) {

    }
    Node reverseList(Node head)
    {
        if(head == null) return head;
        Node previous = null;
        Node current = head;
        Node next = current.next;
        while(current != null){
            current.next = previous;
            previous = current;
            current = next;
            if(next != null){
                next = next.next;
            }
        }
        head = previous;
        return head;
    }
}
class Node {
    int data;
    Node next;
    Node(int value) {
        this.data = value;
    }
}
