package HashingHeap;
import java.util.*;
public class HashingHeaps {
    public static void main(String[] args) {
        HashSet<Integer> hash = new HashSet<>(100);
        hash.add(4);
        hash.add(10);
        hash.add(19);
        hash.add(25);
        System.out.println(hash);
        System.out.println(hash.size());
    }

    // count distinct element in an array using hashmap
    static int countDistinct(int[] arr) {
        int count = 0;
        HashSet<Integer> hashsEt = new HashSet<>(arr.length);
        for (int a :
                arr) {
            hashsEt.add(a);
        }
        return hashsEt.size();
    }

    // union of two arrays
    static int unionOfArray(int[] arr, int[] arr1) {
        HashSet<Integer> hashSet = new HashSet<>(arr.length + arr1.length);
        for (int a : arr) {
            hashSet.add(a);
        }
        for (int a : arr1) {
            hashSet.add(a);
        }
        return hashSet.size();
    }

    // intersection of two arrays.
    public static int intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = new HashSet<>();
        int[] arr = new int[Math.min(nums1.length, nums2.length)];
        int count = 0, i = 0;
        for (int a :
                nums1) {
            hashSet.add(a);
        }
        for (int a :
                nums2) {
            if (hashSet.contains(a)) {
                count++;
            }
        }
        return count;
    }
    public static int[] intersections(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet1 = new HashSet<>();
        int i = 0;
        HashSet<Integer> hashSetFinal = new HashSet<>();
        for (int a :
                nums1) {
            hashSet1.add(a);
        }
        for (int a :
                nums2) {
            if(hashSet1.contains(a)){
                hashSetFinal.add(a);
            }
        }
        int[] arr = new int[hashSetFinal.size()];
        for (Integer val :
                hashSetFinal) {
            arr[i] = val;
            i++;
        }
        return arr;
    }
    //  Count Distinct Elements in every Window of size k
    // important question
    void countDistinctElements(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();

        // either add the occurance of element by 1 or if not exist, add 1 to it's index
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) +1);
        }
        System.out.println(map.size());

        // to remove the elements of previous index if occurrence equals to 1 or if greater than 1 then subtract 1.
        for (int i = k; i < arr.length; i++) {
            if(map.get(arr[i-k]) == 1){
                map.remove(arr[i-k]);
            }else{
                map.put(arr[i-k], map.get(arr[i-k]-1));
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) +1);
            System.out.println(map.size());

        }
    }
}
