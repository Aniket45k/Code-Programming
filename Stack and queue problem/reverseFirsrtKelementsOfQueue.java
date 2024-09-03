import java.util.*;

public class reverseFirsrtKelementsOfQueue {
    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // add code here.
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < k; i++) {
            st.push(q.remove());
        }
        while (st.size() > 0) {
            q.add(st.pop());
        }
        for (int i = 0; i < q.size() - k; i++) {
            q.add(q.remove());
        }
        return q;
    }

    public static void main(String[] args) {
        // Create a queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        // Create an instance of reverseFirsrtKelementsOfQueue
        reverseFirsrtKelementsOfQueue obj = new reverseFirsrtKelementsOfQueue();

        // Reverse the first k elements of the queue
        int k = 4; // Example: Reverse the first 3 elements
        Queue<Integer> modifiedQueue = obj.modifyQueue(queue, k);

        // Print the modified queue
        System.out.println("Modified Queue:");
        while (!modifiedQueue.isEmpty()) {
            System.out.print(modifiedQueue.poll() + " ");
        }
    }
}
