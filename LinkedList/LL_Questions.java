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
    public LinkedList.LL.Node mergeTwoLists(LinkedList.LL.Node list1, LinkedList.LL.Node list2) {
        LinkedList.LL.Node newlist = new LinkedList.LL.Node();
        LinkedList.LL.Node head = newlist;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        while(list1 != null && list2 != null){
            if(list1.data < list2.data){
                head.next = list1;
                list1 = list1.next;
                head = head.next;
            }else{
                head.next = list2;
                list2 = list2.next;
                head = head.next;
            }
            head.next = (list1 != null) ? list1 : (list2 != null ? list2 : null);
        }
        return newlist.next;
    }

}
