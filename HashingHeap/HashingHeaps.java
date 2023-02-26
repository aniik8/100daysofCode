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
}
