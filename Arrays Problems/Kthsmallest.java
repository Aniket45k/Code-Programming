import java.util.*;

public class Kthsmallest {

    public static int Smallest(int nums[], int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int arr[] = { 3, 6, 8, 2, 9, 12, 7, 19 };
        System.out.println(Smallest(arr, 4));
    }
}
