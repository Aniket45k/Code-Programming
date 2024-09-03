
import java.util.PriorityQueue;

public class KthLargest {
    public static int largest(int nums[], int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();

    }

    public static void main(String[] args) {
        int arr[] = { 3, 6, 8, 2, 9, 12, 7, 19 };
        System.out.println(largest(arr, 4));
    }
}
