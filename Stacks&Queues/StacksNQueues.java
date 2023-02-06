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
    // Leetcode 20; valid parenthesis
    public boolean isValid(String s) {
        boolean flag = true;
        if(s.length() <= 1) return false; // for empty or string len=1;
        Stack<Character> parenthesis = new Stack<>();
        for(int i=0; i < s.length(); i++){
            char ch = s.charAt(i);
            switch (ch)
            {
                case '(':
                case '{':
                case '[':
                    parenthesis.push(ch);
                    break;
                case ')':
                case '}':
                case ']':
                    if(!parenthesis.isEmpty())
                    {
                        char chPop = parenthesis.pop();
                        if ((ch == '}' && chPop != '{')
                                || (ch == ')' && chPop != '(')
                                || (ch == ']' && chPop != '['))
                        {
                            return false;
                        }
                    }
                    else return false;  // prematurely empty
            }
        }
        if(!parenthesis.isEmpty()) return false;
        else return true;
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

// delimiter class
class delimiterChecker{
    private int maxLength;
    private int topList;
    private char[] delimiterList;

    public delimiterChecker(int n){
        maxLength = n;
        topList = -1;
        delimiterList = new char[n];
    }
    public void pushStack(char ch){

        delimiterList[++topList] = ch;
    }
    public char popStack(){
        return delimiterList[topList--];
    }
    public boolean isEmpty()
    {
        return topList == -1;
    }
    public boolean isFull()
    {
        return topList == maxLength;
    }
}
