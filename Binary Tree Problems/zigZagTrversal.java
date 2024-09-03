import java.util.*;

public class zigZagTrversal {
    static class Node {
        int data;
        Node left;
        Node right;

        // Constructor to initialize
        // the node with a value
        Node(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    // Function to perform zigzag level
    // order traversal of a binary tree
    public static List<List<Integer>> ZigZagLevelOrder(Node root) {
        // List to store the
        // result of zigzag traversal
        List<List<Integer>> result = new ArrayList<>();

        // Check if the root is null,
        // return an empty result
        if (root == null) {
            return result;
        }

        // Queue to perform
        // level order traversal
        Queue<Node> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);

        // Flag to determine the direction of
        // traversal (left to right or right to left)
        boolean leftToRight = true;

        // Continue traversal until
        // the queue is empty
        while (!nodesQueue.isEmpty()) {
            // Get the number of nodes
            // at the current level
            int size = nodesQueue.size();

            // List to store the values
            // of nodes at the current level
            List<Integer> row = new ArrayList<>();

            // Traverse nodes at
            // the current level
            for (int i = 0; i < size; i++) {
                // Get the front node
                // from the queue
                Node node = nodesQueue.poll();

                // Determine the index to insert the node's
                // value based on the traversal direction
                int index = leftToRight ? i : (nodesQueue.size() - 1 - i);

                // Insert the node's value at
                // the determined index
                row.add(index, node.data);

                // Enqueue the left and right
                // children if they exist
                if (node.left != null) {
                    nodesQueue.add(node.left);
                }
                if (node.right != null) {
                    nodesQueue.add(node.right);
                }
            }

            // Switch the traversal
            // direction for the next level
            leftToRight = !leftToRight;

            // Add the current level's
            // values to the result list
            result.add(row);
        }

        // Return the final result of
        // zigzag level order traversal
        return result;
    }

    public static void printResult(List<List<Integer>> result) {
        for (List<Integer> row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Get the zigzag level order traversal
        List<List<Integer>> result = ZigZagLevelOrder(root);

        // Print the result
        printResult(result);
    }
}
