package StacksNQueues;
import java.util.Stack;
public class StacksNQueues {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(5);
        stack.push(3);
        stack.add(2, 12);
        stack.add(9);
        System.out.println(stack);
        System.out.println(stack);
//  Stack use LIFO (Last in first out) approach
//        System.out.println(a);
    }

}
class Stacksx{
    private final int maxSize;
    private final int[] stackArray;
    private int top;
    public Stacksx(int n){
        maxSize = n;
        stackArray = new int[n];
        top = -1;
    }
    // pushing element at top of stack;
    public void pushStack(int num){
        if(top == maxSize){
            System.out.println("Stack is FULL, STACK OVERFLOW");
            return;
        }
        stackArray[++top] = num;
    }
    // popping element from top of the stack
    public int popStack(){
        if(top == -1){
            System.out.println(" Stack underflow!!! No new element..");
            return -1;
        }
        return stackArray[top--];
    }
    // peek function - return the top most element
    public int peekElement(){
        if(top == -1){
            System.out.println("Stack is Empty");
            return -1;
        }
        else return stackArray[top];
    }
    // is empty function/
    public boolean isEmpty(){
        return top == -1;
    }
    public boolean isFull(){
        return top == maxSize;
    }
}
