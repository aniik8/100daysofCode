package LinkedList;

public class LL{
    // create a node

    // displaying a node
    // deleting a node

    private Node head;
    private Node tail;
    private int size;
    LL(){
        this.size = 0;
    }
    //creating a node.
    public void insertionNode(int data){
        Node newLink = new Node(data);
        newLink.next = head;
        head = newLink;
        if (tail == null){
            tail = newLink;
        }
        size++;
    }
    // displaying a node
    public void displayNode(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data +  " ->  ");
            temp = temp.next;
        }
        System.out.println("END OF LL");
    }

    public void DeleteNode(){
        head = head.next;

    }
    // insert at the end
    //this will actually insert an element in O(1) constant time. If we don't use tail var, then traversing till end as
    // as same in display method till temp is null and then inserting at that location
    // interviewer may ask why this taking an extra variable can help us, answer is time complexity.

    public void insertEnd(int data){
        if(tail == null){
            insertionNode(data);
        }
        else{
            Node newNode = new Node(data);
            tail.next = newNode;
            tail = newNode;
            size++;
        }

    }
    class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }
}
