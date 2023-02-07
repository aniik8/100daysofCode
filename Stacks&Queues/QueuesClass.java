package StacksNQueues;

public class QueuesClass {
    public static void main(String[] args) {

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
