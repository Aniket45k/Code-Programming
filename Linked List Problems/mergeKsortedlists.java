import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.*;

import org.w3c.dom.Node;

public class mergeKsortedlists {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node mergeKLists(Node[] listArray) {
        // Comparator to compare nodes based on their data
        Comparator<Node> nodeComparator = new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return Integer.compare(n1.data, n2.data);
            }
        };

        // Priority queue to hold the nodes
        PriorityQueue<Node> pq = new PriorityQueue<>(nodeComparator);

        // Add the head of each list to the priority queue
        for (Node node : listArray) {
            if (node != null) {
                pq.offer(node);
            }
        }

        // Dummy node to help with the result list
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        // Process the nodes in the priority queue
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            temp.next = current;
            temp = temp.next;

            if (current.next != null) {
                pq.offer(current.next);
            }
        }

        // Return the merged list
        return dummyNode.next;
    }

    // Utility function to print the list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method to test the merging function
    public static void main(String[] args) {
        Node[] listArray = new Node[3];

        listArray[0] = new Node(1);
        listArray[0].next = new Node(4);
        listArray[0].next.next = new Node(5);

        listArray[1] = new Node(1);
        listArray[1].next = new Node(3);
        listArray[1].next.next = new Node(4);

        listArray[2] = new Node(2);
        listArray[2].next = new Node(6);

        System.out.println("Merged list:");
        Node mergedHead = mergeKLists(listArray);
        printList(mergedHead);
    }
}
