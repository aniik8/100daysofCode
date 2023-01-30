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
        // size of LL
        while(temp != null)
        {   size++;
            temp = temp.next;
        }
        // pointer to the middle element so that the second half can be reversed
        while(n != (size/2))
        {
            n++;
            head2 = head2.next;

        }

        // reversing a second half LL
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

        LinkedList.LL.Node temp3 = list1.head;
        while(head2 != null){
            if(temp3.data != head2.data){
                return false;
            }else{
                temp3 = temp3.next;
                head2 = head2.next;
            }
        }
        return true;
    }
    // LeetCode 143.
    public void reorderList(){
        // reversing second half of the list
        // calculate the size of the list;

        LinkedList.LL.Node temp = head;
        LinkedList.LL.Node head2 = head;
        int size = 0, n = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        // pointing second head at the middle of the list.

        while (n != (size/2)){
            n++;
            head2 = head2.next;

        }
        // reversing a linkedlist
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
        LinkedList.LL.Node headSecond = head2;
        LinkedList.LL.Node headFirst = head;
        while(headFirst != null && headSecond != null){
            LinkedList.LL.Node temp2 = headFirst.next;
            headFirst.next = headSecond;
            headFirst = temp2;

            temp2 = headSecond.next;
            headSecond.next = headFirst;
            headSecond = temp2;
        }
        if(headFirst != null){
            headFirst.next = null;
        }
    }

}
