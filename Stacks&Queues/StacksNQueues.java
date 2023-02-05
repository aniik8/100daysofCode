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
