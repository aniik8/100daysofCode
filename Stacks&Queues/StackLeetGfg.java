package StacksNQueues;

import java.util.ArrayList;
import java.util.Arrays;
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
    // Next smaller right.
    // Help Classmates ------> https://practice.geeksforgeeks.org/problems/fab3dbbdce746976ba35c7b9b24afde40eae5a04/1
    static int[] help_classmate(int[] arr, int n)
    {   Stack<Integer> stack = new Stack<>();
        int[] array = new int[arr.length];
        int a = arr.length-1;
        for (int i = n-1; i >=0 ; i--) {
            if(stack.size() == 0)
                array[a--] = -1;
            else if(stack.size() > 0 && arr[i] > stack.peek()){
                array[a--] = stack.peek();
            }else if(stack.size() > 0 && arr[i] <= stack.peek()){
                while(stack.size() > 0 && arr[i] <= stack.peek())
                {
                    stack.pop();
                }
                if(stack.size() == 0) array[a--] = -1;
                else array[a--] = stack.peek();

            }
            stack.push(arr[i]);
        }
        return array;
        // Your code goes here
    }
    // 1475. Final Prices With a Special Discount in a Shop
    static int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[prices.length];
        int a = prices.length - 1;
        for (int i = prices.length-1; i >= 0; i--){
            if(stack.empty()){
                arr[a--] = prices[i];
            }
            else if(stack.size() > 0 && prices[i] > stack.peek())
                arr[a--] = prices[i] - stack.peek();
            else if(stack.size() > 0 && prices[i] < stack.peek()){
                while(stack.size() > 0 && prices[i] < stack.peek()){
                    stack.pop();
                }
                if(stack.size() == 0) arr[a--] = prices[i];
                else arr[a--] = prices[i] - stack.peek();
            }
            else if(prices[i] == stack.peek())
                arr[a--] = 0;
            stack.push(prices[i]);
        }
        return arr;
    }
    // Stock span problem
    // greater to right algo
    static int[] calculateSpan(int price[], int n)
    {   Stack<Integer> stack = new Stack<>();
        int[] arr = new int[price.length];
        for (int i = 0; i < price.length; i++) {
            while(!stack.isEmpty() && price[stack.peek()] <= price[i]) stack.pop();
            if(stack.isEmpty()) arr[i]=i+1;
            else arr[i]=i-stack.peek();
            stack.push(i);
        }
        return arr;
    }
    // https://leetcode.com/problems/largest-rectangle-in-histogram/
    // Maximum area histogram
    static int largestRectangleArea(int[] heights) {
        int max_area = 0;
        Stack<Integer> stack = new Stack<>();
        int[] left_arr = new int[heights.length];
        int[] right_arr = new int[heights.length];
        int[] area = new int[heights.length];
        // nearest smallest left.
        for (int i = 0; i < heights.length; i++) {
            if(stack.isEmpty()) left_arr[i] = -1;
            else if(stack.size() > 0 && heights[stack.peek()] >= heights[i]){
                while(stack.size() > 0 && heights[stack.peek()] >= heights[i]){
                    stack.pop();
                }
                if(stack.size() == 0) left_arr[i] = -1;
                else left_arr[i] = stack.peek();
            }
            else if(stack.size() > 0 && heights[stack.peek()] < heights[i])
                left_arr[i] = stack.peek();
            stack.push(i);
        }
        stack.empty();
        System.out.println(Arrays.toString(left_arr));
        int a = heights.length - 1;
        for (int i = heights.length-1; i >= 0; i--) {
            if(stack.isEmpty()) right_arr[a--] = heights.length;
            else if(stack.size() > 0 && heights[stack.peek()] >= heights[i]){
                while(stack.size() > 0 && heights[stack.peek()] >= heights[i]){
                    stack.pop();
                }
                if(stack.size() == 0) right_arr[a--] = heights.length;
                else right_arr[a--] = stack.peek();
            }
            else if(stack.size() > 0 && heights[stack.peek()] < heights[i])
                right_arr[a--] = stack.peek();
            stack.push(i);
        }
        System.out.println(Arrays.toString(right_arr));
        for (int i = 0; i < heights.length; i++) {
            area[i] = (right_arr[i] - left_arr[i] - 1) * heights[i];
        }
        System.out.println(Arrays.toString(area));
        return max_area;
    }
    // simple approach
    static int largestRectangleAreas(int[] heights) {
        int n = heights.length;
        int max = 0;
        int nr[] = new int[n];
        int nl[] = new int[n];

        Stack<Integer> s = new Stack<>();
        // Right
        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.empty()) {
                nr[i] = n;
            } else {
                nr[i] = s.peek();
            }
            s.push(i);
        }
        // Left
        s = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!s.empty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.empty()) {
                nl[i] = -1;
            } else {
                nl[i] = s.peek();
            }
            s.push(i);
        }

        for (int i = 0; i < n; i++) {
            int hi = heights[i];
            int width = nr[i] - nl[i] - 1;
            int curr = hi * width;
            max = Math.max(curr, max);
        }
        return max;
    }
}
