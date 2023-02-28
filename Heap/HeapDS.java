package Heap;

public class HeapDS {
    static void heapify(int[] arr, int n, int i)
    {
        // Find parent
        int parent = (i - 1) / 2;

        if (arr[parent] > 0) {
            // For Max-Heap
            // If current node is greater than its parent
            // Swap both of them and call heapify again
            // for the parent
            if (arr[i] > arr[parent]) {

                // swap arr[i] and arr[parent]
                int temp = arr[i];
                arr[i] = arr[parent];
                arr[parent] = temp;

                // Recursively heapify the parent node
                heapify(arr, n, parent);
            }
        }
    }
    static int deleteRoot(int arr[], int n)
    {
        // Get the last element
        int lastElement = arr[n - 1];

        // Replace root with first element
        arr[0] = lastElement;

        // Decrease size of heap by 1
        n = n - 1;

        // heapify the root node
        heapify(arr, n, 0);

        // return new size of Heap
        return n;
    }

    // Function to insert a new node to the heap.
    static int insertNode(int[] arr, int n, int Key)
    {
        // Increase the size of Heap by 1
        n = n + 1;

        // Insert the element at end of Heap
        arr[n - 1] = Key;

        // Heapify the new node following a
        // Bottom-up approach
        heapify(arr, n, n - 1);

        // return new size of Heap
        return n;
    }

    /* A utility function to print array of size n */
    static void printArray(int[] arr, int n)
    {
        for (int i = 0; i < n; ++i)
            System.out.println(arr[i] + " ");

        System.out.println();
    }
}
