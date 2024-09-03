import java.util.ArrayList;
import java.util.Collections;

public class BinaryTreeToBST {

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

    static void inorderTree(Node root, ArrayList<Integer> v) {
        if (root == null) return;
        
        inorderTree(root.left, v);
        v.add(root.data);
        inorderTree(root.right, v);
    }

    static void inorderBST(Node root, ArrayList<Integer> v, int[] i) {
        if (root == null) return;
        
        inorderBST(root.left, v, i);
        root.data = v.get(i[0]);
        i[0]++;
        inorderBST(root.right, v, i);
    }

    static Node binaryTreeToBST(Node root) {
        if (root == null) return null;
        
        ArrayList<Integer> v = new ArrayList<>();
        inorderTree(root, v);
        Collections.sort(v);
        
        int[] i = {0};
        inorderBST(root, v, i);

        return root;
    }

    // Additional method to print inorder traversal of the tree
    static void printInorder(Node root) {
        if (root == null) return;
        
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(30);

        System.out.println("Inorder traversal of original binary tree:");
        printInorder(root);

        root = binaryTreeToBST(root);

        System.out.println("\nInorder traversal of binary search tree (BST) after conversion:");
        printInorder(root);
    }
}


