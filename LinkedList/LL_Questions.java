package LinkedList;

public class LL_Questions {

    private LinkedList.LL.Node head;
    private LinkedList.LL.Node tail;
    private int size;



    //. Leetcode- 206 reversing a Linked-list, given a head of the list
    public void reverseList()
    {
        LinkedList.LL.Node previous = null;
        LinkedList.LL.Node current = head;
        LinkedList.LL.Node next = current.next;
        while(current != null){
            current.next = previous;
            previous = current;
            current = next;
            if(next != null){
                next = next.next;
            }
        }
        head = previous;
    }
    // Leetcode - 83. remove duplicate elements in the linked list

    public void removeDuplicate(){
        LinkedList.LL.Node newNode = head;
        while(newNode.next != null){
            if(newNode.data == newNode.next.data){
                newNode.next = newNode.next.next;
            }else{
                newNode = newNode.next;
                size--;
            }
        }
    }

}
