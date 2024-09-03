import java.util.*;

public class constructBstFromPreOrder {
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

    public static Node bstFromPreorder(int A[]) {
        return bstFromPreorder(A, Integer.MAX_VALUE, new int[] { 0 });
    }

    public static Node bstFromPreorder(int A[], int bound, int i[]) {
        if (i[0] == A.length || A[i[0]] > bound) {
            return null;
        }
        Node root = new Node(A[i[0]++]);
        root.left = bstFromPreorder(A, root.data, i);
        root.right = bstFromPreorder(A, bound, i);
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int A[] = { 8, 5, 1, 7, 10, 12 };
        Node root = bstFromPreorder(A);
        inorder(root); // Output should be: 1 5 7 8 10 12
    }
}
