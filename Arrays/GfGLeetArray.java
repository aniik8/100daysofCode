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
int findKRotation(int arr[], int n) {
    // code here
}
}
