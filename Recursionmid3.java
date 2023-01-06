public class Recursionmid3 {
    public static void main(String[] args) {
        int[] arr2 = {19, 1, -4, 2, -12, 18, 32};

// Sorting algorithms using recursion.
        // 1. Bubble sort
        System.out.println((bubbleSort(arr2,0, arr2.length-1)));
    }
    public static int bubbleSort(int[] arr, int start, int last){
        if(last == 0){
            return 0;
        }
        else if(start == last){
            return bubbleSort(arr, 0, last-1);
        }
        else if (arr[start] > arr[start+1]){
            int temp = arr[start];
            arr[start] = arr[start+1];
            arr[start+1] = temp;
        }
        return bubbleSort(arr, start+1, last);
    }


}
