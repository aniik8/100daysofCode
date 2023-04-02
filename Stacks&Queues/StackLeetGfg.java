package StacksNQueues;

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
}
