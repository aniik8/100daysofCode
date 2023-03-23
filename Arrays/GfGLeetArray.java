package Arrays;

public class GfGLeetArray {
    public static void main(String[] args) {

    }
    // 1. Number of occurrence : asked in google, amazon, zoho.in Gfg question

    int count(int[] arr, int n, int x) {
        int start = 0, end  = arr.length - 1;
        int left_index = Binsearch(arr, x, start, end, "left");
        if(left_index < 0) return 0;
        int right_index = Binsearch(arr, x, start, end, "right");
        return (right_index - left_index + 1);
    }
    static int Binsearch(int arr[], int target, int start,int end, String decision){
        int mid, result = -1;
        while(start <= end){
            mid = start + (end - start )/2;
            if(arr[mid] == target){
                result = mid;
                if(decision.equals("left"))
                    end = mid - 1;
                else start = mid + 1;

            }
            else if(arr[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return result;
    }
// ---------------------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------
// 2. Number of rotations in a rotated sorted array. gfg
static int findKRotation(int arr[], int n) {
    int start = 0, end = n - 1;
    while(start <= end){
        if(arr[start] <= arr[end]) return start;
        int mid = start + (end - start) / 2;
        int prev = (mid + n  - 1) % n;
        int next = (mid + 1) % n;
        if(arr[mid] <= arr[prev] && arr[mid] <= arr[next]){
            return mid;
        }
        // because element is being found in unsorted part
        else if(arr[start] <= arr[mid]){
            start = mid + 1;
        }
        else{
            end = mid - 1;
        }
    }
    return 0;
}
    
}
