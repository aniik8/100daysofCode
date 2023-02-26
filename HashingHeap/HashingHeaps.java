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

}
