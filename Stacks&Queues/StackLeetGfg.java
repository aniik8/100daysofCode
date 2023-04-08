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
    static int largestRectsangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] left_arr = new int[heights.length];
        int[] right_arr = new int[heights.length];
        int[] area = new int[heights.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            while (stack.size() > 0 && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.size() == 0) left_arr[i] = -1;
            else left_arr[i] = stack.peek();


            stack.push(i);
        }
        stack.empty();
        int a = heights.length - 1;
        for (int i = heights.length - 1; i >= 0; i--)
        {
            while (stack.size() > 0 && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.size() == 0) right_arr[i] = heights.length;
            else right_arr[i] = stack.peek();

            stack.push(i);
        }
        System.out.println(Arrays.toString(right_arr));
        System.out.println(Arrays.toString(left_arr));
        for (int i = 0; i < heights.length; i++) {
            area[i] = (right_arr[i] - (left_arr[i]) - 1) * heights[i];
            max = Math.max(max, area[i]);
        }

        return max;

    }
    // 85 LeetCode
    static int maximalRectangle(char[][] matrix) {
        // Normal input of first array as the base
        int row = matrix.length, col = matrix[0].length, maxi = Integer.MIN_VALUE, area;
        int[] arr = new int[matrix[0].length];
        for (int i = 0; i < col; i++) {
            if(matrix[0][i] == '1')
                arr[i] = 1;
            else arr[i] = 0;
        }
        //calculate the maximum

        area = largestRectangleArea(arr);
        maxi = Math.max(maxi, area);
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j] == '0') arr[j] = 0;

                    // add the other array to the current one and calculate the maximum area;
                else {
                    if(matrix[i][j] == '1')
                        arr[j] = arr[j] +  1;
                }
            }

            area = largestRectangleArea(arr);

            maxi = Math.max(maxi, area);
        }
        return maxi;
    }

    // 42 trapping rain water
    static int trap(int[] height) {
        // maximum from the right array
        // maximum from the left array
        // minimum of both array and subtract them from the current array element
        // sum of all the array element.
        // 1. maximum element from the left.
        int maxiLeft = height[0], sum = 0, min;
        int maxiRight = height[height.length-1];
        int[] maxLeft = new int[height.length];
        maxLeft[0] = maxiLeft;
        int[] maxRight = new int[height.length];
        maxRight[height.length-1] = maxiRight;
        for (int i = 1; i < height.length; i++) {
            if(maxiLeft < height[i]){
                maxiLeft = height[i];
            }
            maxLeft[i] = maxiLeft;
        }
        System.out.println(Arrays.toString(maxLeft));
        for (int i = height.length-2; i >= 0; i--) {
            if(maxiRight < height[i]){
                maxiRight = height[i];
            }
            maxRight[i] = maxiRight;
        }
        System.out.println(Arrays.toString(maxRight));
        for (int i = 0; i < height.length; i++) {
            min = Math.min(maxLeft[i], maxRight[i]) - height[i];
            sum += min;
        }
        return sum;
    }
    // maximum trapping rainwater GFG
    static long trappingWater(int arr[], int n) {
        int maxiLeft = arr[0], min;
        long sum = 0;
        int h = arr.length;
        int maxiRight = arr[h-1];
        int[] maxLeft = new int[h];
        maxLeft[0] = maxiLeft;
        int[] maxRight = new int[h];
        maxRight[h-1] = maxiRight;
        for (int i = 1; i < arr.length; i++) {
            if(maxiLeft < arr[i]){
                maxiLeft = arr[i];
            }
            maxLeft[i] = maxiLeft;
        }
        for (int i = arr.length-2; i >= 0; i--) {
            if(maxiRight < arr[i]){
                maxiRight = arr[i];
            }
            maxRight[i] = maxiRight;
        }
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(maxLeft[i], maxRight[i]) - arr[i];
            sum += min;
        }
        return sum;
    }
}
// Max rectangle area ---> gfg
class Solutsion {
    public int maxArea(int M[][], int n, int m) {
        int row = M.length, col = M[0].length, maxi = Integer.MIN_VALUE, area;
        int[] arr = new int[M[0].length];
        // calculating the area the first row
        for (int i = 0; i < col; i++)
        {   arr[i] = M[0][i];
        }
        // calculating the area the first row
        area = largestRectangleArea(arr);
        maxi = Math.max(maxi, area);
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // if our element at base is 0, then no need to calculate the area of that part.
                if(M[i][j] == 0) arr[j] = 0;

                    // add the other array to the current one and calculate the maximum area;
                else {
                    if(M[i][j] == 1)
                        arr[j] = arr[j] +  1;
                }
            }
            area = largestRectangleArea(arr);
            maxi = Math.max(maxi, area);
        }
        return maxi;
    }
    // Calculating area, same function as Largest Area Histogram problem
    int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int height = heights.length;
        int[] left_arr = new int[height];
        int[] right_arr = new int[height];
        int[] area = new int[height];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height; i++)
        {
            while (stack.size() > 0 && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.size() == 0) left_arr[i] = -1;
            else left_arr[i] = stack.peek();
            stack.push(i);
        }
        stack = new Stack<>();
        int a = height - 1;
        for (int i = height - 1; i >= 0; i--) {

            while (stack.size() > 0 && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.size() == 0) right_arr[a--] = height;
            else right_arr[a--] = stack.peek();

            stack.push(i);
        }
        for (int i = 0; i < height; i++) {
            area[i] = (right_arr[i] - (left_arr[i]) - 1) * heights[i];
            max = Math.max(max, area[i]);
        }

        return max;
    }
    static int maximalSquare(char[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        int[] hist = new int[n];
        int ans = 0;
        for (char[] chars : matrix) {
            for (int col = 0; col < n; col++)
                hist[col] += chars[col] == '1' ? 1 : -hist[col];
            ans = Math.max(ans, largestSquareArea(hist));
        }
        return ans;
    }
    
}
