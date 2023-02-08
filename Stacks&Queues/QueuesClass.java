package StacksNQueues;

import java.util.Stack;

public class QueuesClass {
    public static void main(String[] args) {
        QueueClass q = new QueueClass(5);
        q.insertElement(5);
        q.insertElement(4);
        q.insertElement(3);
        q.insertElement(2);
        q.insertElement(1);
        while(!(q.isEmpty())){
            System.out.println(q.deleteElement());
        }
    }
}
class QueueClass{
    private int maxLength;
    private int top;
    private int[] queueArray;
    private int front;
    private int rear;

    QueueClass(int maxLength){
        queueArray = new int[maxLength];
        front = 0;
        rear = -1;

    }


    // insertion at the end;
    public void insertElement(int element){
        // if(!isEmpty()) then do this thing
        if(!isFull()) {
            queueArray[++rear] = element;
        }else{
            System.out.println("Error 404!!!! stack is full");
        }
    }
    // deletion from the front
    public int deleteElement(){
        int temp = queueArray[front++];
        return temp;
    }
    // peek element
    public int peekElement(){
        return queueArray[rear];
    }
    // isEmpty
    public boolean isEmpty(){
        return rear == -1;
    }
    // isFull
    public boolean isFull(){
        return rear == maxLength;
    }

}
// Queue using two stack;
class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() throws Exception{
        while(!(stack1.isEmpty())){
            stack2.push(stack1.pop());
        }
        int removed = stack2.pop();
        while(!(stack2.isEmpty())){
            stack1.push(stack2.pop());
        }
        return removed;
    }

    public int peek() throws Exception{
        while(!(stack1.isEmpty())){
            stack2.push(stack1.pop());
        }
        int peekEle = stack2.peek();

        while(!(stack2.isEmpty())){
            stack1.push(stack2.pop());
        }
        return peekEle;
    }

    public boolean empty() {
        return (stack1.empty() && stack2.empty());
    }
    // 921. Minimum Add to Make Parentheses Valid
    public static int minAddToMakeValid(String s) {
        Stack<Character> sc = new Stack<>();
        int count = 0;
        for(int i = 0; i < s.length()-1; i++){

            char ch = s.charAt(i);
            sc.push(ch);
            char ch1 = s.charAt(i + 1);
            if (ch == '(' && ch1 == ')') {
                sc.pop();
                break;
            }
        }
        while(!(sc.isEmpty())){
            count++;
            sc.pop();
        }
        return count;
    }
}
