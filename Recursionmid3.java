import java.util.Arrays;

public class Recursionmid3 {
    public static void main(String[] args) {
        int[] arr2 = {19, 1, -4, 2, -12, 18, 32};

// Sorting algorithms using recursion.
        // 1. Bubble sort
        System.out.println((bubbleSort(arr2,0, arr2.length-1)));
        // 2. Selection sort
        System.out.println(Arrays.toString(selectionSort(arr2, 0, 1, arr2.length-1)));
        // 3. merge sort
        System.out.println(Arrays.toString(mergeSort(arr2)));
        // 4. quick sort
        quicksort(arr2, 0, arr2.length-1);

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
// 2. Selection sort
public static int[] selectionSort(int[] arr, int max, int next, int end){

    if(end == 1){
        return arr;
    }
    else if(arr[max] > arr[next]){
        int temp = arr[next];
        arr[next] = arr[max];
        arr[max] = temp;

    }
    else if(next == end){
        return selectionSort(arr, 0, 1, end-1);

    }
    return selectionSort(arr, next, next+1, end);
}
    public static int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }
        int mid = arr.length / 2;

        int[] arr1 = mergeSort(Arrays.copyOfRange(arr, 0, mid));

        int[] arr2 = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(arr1, arr2);
    }
    public static int[] merge(int [] arr1, int[] arr2){
        int[] arrcomb = new int[arr1.length+arr2.length];
        int i =0, j=0, k=0;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                arrcomb[k] = arr1[i];
                i++;
            }else {
                arrcomb[k] = arr2[i];
                j++;
            }
            k++;
        }
        while(i < arr1.length){
            arrcomb[k] = arr1[i];
            i++; k++;
        }
        while (j < arr2.length){
            arrcomb[k] = arr2[j];
            j++;k++;
        }
        return arrcomb;
    }
    // quick sort
    static void quicksort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }
        int start = low;
        int end = high;
        int mid = start + (end - start)/2;
        int pivot = arr[mid];
        while(start <= end){
            while(arr[start] < pivot) start++;
            while(arr[end] > pivot) end--;

            if(start <= end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++; end--;
            }
        }
        quicksort(arr, low, end);
        quicksort(arr, start, high);

    }

}
