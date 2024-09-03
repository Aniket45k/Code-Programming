import java.util.*;

public class constructBtFromInorderAndPreorder {
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

    public static Node buildTree(Vector<Integer> preorder, Vector<Integer> inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.size(); i++) {
            inMap.put(inorder.get(i), i);
        }
        Node root = buildTree(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1, inMap);
        return root;
    }

    public static Node buildTree(Vector<Integer> preorder, int preStart, int preEnd,
            Vector<Integer> inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        Node root = new Node(preorder.get(preStart));
        int inRoot = inMap.get(root.data);
        int numsLeft = inRoot - inStart;

        // Recursively build the left subtree
        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft,
                inorder, inStart, inRoot - 1, inMap);

        // Recursively build the right subtree
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd,
                inorder, inRoot + 1, inEnd, inMap);

        // Return the current root node
        return root;
    }

    public static void printInorder(Node root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }

    public static void printVector(Vector<Integer> vec) {
        for (int i = 0; i < vec.size(); i++) {
            System.out.print(vec.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Vector<Integer> inorder = new Vector<>(java.util.Arrays.asList(40, 20, 50, 10, 60, 30));
        Vector<Integer> preorder = new Vector<>(java.util.Arrays.asList(10, 20, 40, 50, 30, 60));

        System.out.print("Inorder Vector: ");
        printVector(inorder);

        System.out.print("Preorder Vector: ");
        printVector(preorder);

        Node root = buildTree(preorder, inorder);

        System.out.println("Inorder of Unique Binary Tree Created:");
        printInorder(root);
        System.out.println();
    }
}
