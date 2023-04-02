package StacksNQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackLeetGfg {
    public static void main(String[] args) {

    }
    // https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1
    // Next Greater Element
    static long[] nextLargerElement(long[] arr, int n)
    {
        Stack<Long> s = new Stack<>();
        int a = arr.length-1;
        long[] array = new long[arr.length];
        for (int i = arr.length-1; i >= 0; i--) {
            if(s.size() == 0)
                array[a--] = -1;
            else if(s.size() > 0 && arr[i] < s.peek()){
                array[a--] = s.peek();
            }
            else if(s.size() > 0 && arr[i] >= s.peek()){
                while(s.size() > 0 && arr[i] >= s.peek()) {
                    s.pop();
                }
                if(s.size() == 0) array[a--] = -1;
                else array[a--] = s.peek();
            }
            s.push(arr[i]);
        }
        return array;
    }
    // https://practice.geeksforgeeks.org/problems/smallest-number-on-left3403/1
    // Smallest number on left
    static List<Integer> leftSmaller(int n, int a[])
    {   Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(stack.size() == 0) list.add(-1);
            else if(stack.size() > 0 && a[i] > stack.peek())
                list.add(stack.peek());
            else if(stack.size() > 0 && a[i] <= stack.peek()){
                while(stack.size() > 0 && a[i] <= stack.peek())
                    stack.pop();
                if(stack.size() == 0) list.add(-1);
                else list.add(stack.peek());

            }
            stack.push(a[i]);
        }
        return list;
    }
}
