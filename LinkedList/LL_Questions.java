package LinkedList;

import java.util.LinkedList;

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
    // Question no. 61 leetcode
    public void rotateRight(LinkedList.LL L1, int k) {
        LinkedList.LL.Node temp = head;
        LinkedList.LL.Node nullTobe = head;
        int  n = 0;
        int size=1;
        while(temp.next != null){
            size++;
            temp = temp.next;
        }

        temp.next = head;
        int rotations = k % size;
        int skip_node = size - rotations;
        while(n != skip_node-1) {
            nullTobe = nullTobe.next;
            n++;
        }
        head = nullTobe.next;
        nullTobe.next = null;

    }
    //leetcode 203
    public void removeElements(LinkedList.LL list1 , int val)
    {
        LinkedList.LL.Node temp = head;
        while(head != null &&  head.data == val ){
            if(head.next != null) {
                head = head.next;
            }else{
                head = null;
            }
        }
        while(temp.next != null){
            if(temp.next.data == val)
            {
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }

        }
    }
    // program to return an array of larger element of each node in a linkedlist.
    public int[] LargerNodes(LinkedList.LL l1){
        int max, n=0;
        int size = 0;
        LinkedList.LL.Node temp = head;
        LinkedList.LL.Node temp2 = head;

        while(temp != null){
            size++;
            temp = temp.next;
        }
        int[] arr = new int[size];
        while(head != null){
            max = 0;
            while(temp2 != null){
                if(max < temp2.data){
                    max = temp2.data;
                }
                if(temp2.next == null){
                    arr[n] = (max == head.data ?  0 : max);
                    n++;
                }
                temp2 = temp2.next;
            }
            head = head.next;
            temp2 = head;
        }
        return arr;
    }
    // leetcode 1019.
    public int[] nextLargerNodes(LinkedList.LL l1){
        int n=0;
        int size = 0;boolean flag = false;
        LinkedList.LL.Node temp = head;
        LinkedList.LL.Node temp2 = head;

        while(temp != null){
            size++;
            temp = temp.next;
        }
        int[] arr = new int[size];
        while(head != null){
            // 1,7,5,1,9,2,5,1
            flag = false;
            while(temp2 != null)
            {
                if(temp2.next != null && head.data < temp2.next.data){
                    arr[n] = temp2.next.data;
                    n++;
                    flag = true;
                }
                else if(temp2.next == null){
                    arr[n] =  0;
                    n++;
                }

                temp2 = temp2.next;
            }
            head = head.next;
            temp2 = head;
            if(flag) break;
        }
        return arr;
    }
    // LL 328. ODD even linked list.

    public void oddEvenList() {
        LinkedList.LL.Node evenNode = head.next;
        LinkedList.LL.Node evenHead = evenNode;
        LinkedList.LL.Node oddNode = head;
        while (oddNode.next != null && evenNode.next != null) {
            oddNode.next = oddNode.next.next;
            oddNode = oddNode.next;
            evenNode.next = evenNode.next.next;
            evenNode = evenNode.next;
        }
        oddNode.next = evenHead;
    }
    // 237. Delete node in a linked list
    public void deleteNode(LinkedList.LL node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
// Leetcode 2487. -- time limit exceeded
public void removeNodes(LinkedList.LL l1)
{
    LinkedList.LL.Node head = l1.head;
    while(head.next.data > head.data){
        head = head.next;
    }
    if(head !=null)
    {
        LinkedList.LL.Node temp = head;
        LinkedList.LL.Node temp2 = head.next;
        while (temp != null)
        {
            if (temp2.data > temp.data)
            {
                temp.data = temp.next.data;
                temp.next = temp.next.next;
            }else
                temp2 = temp2.next;
            if(temp2 == null && temp != null)
            {   temp2 = temp.next;
                temp = temp.next;
            }

        }
    }
}
// time 6 ms
public void reverse(LinkedList.LL.Node l1)
{
    Node cur= head;
    Node prev=null;
    Node next=null;

    while(cur!=null)
    {
        next=cur.next;
        cur.next=prev;
        prev=cur;
        cur=next;
    }
    return prev;
}

    public Node removeNodes(LinkedList.LL.Node head) {
        head=reverse(head);
        int max=head.val;
        ListNode iter=head.next;
        ListNode prev=head;
        while(iter!=null)
        {
            if(iter.val<max)//delete node
            {
                prev.next=iter.next;
            }
            else//update max value
            {
                max=iter.val;
                prev=iter;
            }
            iter=iter.next;
        }

        return reverse(head);
    }

    class Node{
        int data;
        LinkedList.LL.Node next;
        public Node(){};
        public Node(int data) {
            this.data = data;
        }
        public Node(int data, LinkedList.LL.Node next){
            this.data = data;
            this.next = next;
        }
    }



}
