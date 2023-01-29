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
    // leetcode 21
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

// leetcode 141  - cycle present in a linkedlist or not
    public boolean hasCycle(LinkedList.LL.Node head) {
        LinkedList.LL.Node fast = head;
        LinkedList.LL.Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
// leetcode 863. middle of a linkedlist
public int middleofLL(LinkedList.LL list1){
    LinkedList.LL.Node temp = head;
    int size = 0;
    int n = 0;
    while(temp != null){
        size++;
        temp = temp.next;
    }

    while(n != ((size/2))){
        n++;
        head = head.next;
    }
    return head.data;
}
    //234. palindrome linkedlist
    public boolean isPalindrome(LinkedList.LL list1){
        int size=0, n=0;
        LinkedList.LL.Node temp = list1.head;
        LinkedList.LL.Node head2 = list1.head;
        while(temp != null)
        {

            size++;
            temp = temp.next;
        }
        while(n != (size/2))
        {
            n++;
            head2 = head2.next;

        }
        // reversing a second half linkedlist
        LinkedList.LL.Node prev = null;
        LinkedList.LL.Node current = head2;
        LinkedList.LL.Node next = current.next;
        while(current != null)
        {
            current.next = prev;
            prev = current;
            current = next;
            if(next != null) {
                next = next.next;
            }
        }
        head2 = prev;
    }
}
