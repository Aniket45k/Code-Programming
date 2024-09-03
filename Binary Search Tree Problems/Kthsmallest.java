public class KthSmallest {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int Smallest(Node root, int k) {
        // Array to store the result
        int[] result = new int[1];
        // Counter to keep track of number of nodes visited
        int[] count = new int[1];
        // Perform inorder traversal to find the kth smallest value
        inorder(root, k, count, result);
        return result[0];
    }

    // Helper method for inorder traversal
    public static void inorder(Node node, int k, int[] count, int[] result) {
        // Base case: if node is null or kth smallest value found, return
        if (node == null || count[0] >= k) {
            return;
        }
        // Traverse left subtree
        inorder(node.left, k, count, result);
        // Increment count after visiting left subtree
        count[0]++;
        // If kth smallest value found, update result
        if (count[0] == k) {
            result[0] = node.data;
            return;
        }
        // Traverse right subtree
        inorder(node.right, k, count, result);
    }

    public static void main(String[] args) {
        // Construct a binary search tree
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(7);

        // Initialize k
        int k = 1;

        // Find the kth smallest value in the binary search tree
        int kthSmallest = Smallest(root, k);

        // Print the result
        System.out.println("The " + k + "th smallest value in the binary search tree is: " + kthSmallest);
    }
}
