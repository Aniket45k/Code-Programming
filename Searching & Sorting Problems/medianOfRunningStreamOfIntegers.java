import java.util.Collections;
import java.util.PriorityQueue;

public class medianOfRunningStreamOfIntegers {
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static void insertNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());

    }

    public static double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        medianOfRunningStreamOfIntegers MedianOfRunningStreamOfIntegers = new medianOfRunningStreamOfIntegers();
        medianOfRunningStreamOfIntegers.insertNum(3);
        medianOfRunningStreamOfIntegers.insertNum(1);
        System.out.println("the median is : " + medianOfRunningStreamOfIntegers.findMedian());
        medianOfRunningStreamOfIntegers.insertNum(5);
        System.out.println("the median is : " + medianOfRunningStreamOfIntegers.findMedian());
        medianOfRunningStreamOfIntegers.insertNum(4);
        System.out.println("the median is : " + medianOfRunningStreamOfIntegers.findMedian());
    }

}
