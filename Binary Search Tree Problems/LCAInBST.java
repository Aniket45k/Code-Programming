import java.util.*;

import javax.swing.plaf.synth.SynthStyle;

public class LCAInBST {
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

    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null) {
            return null;
        }
        int curr = root.data;
        if (curr < p.data && curr < q.data) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (curr > p.data && curr > q.data) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(4);
        root.left.left = new Node(3);
        root.left.left.left = new Node(1);
        root.left.left.left.right = new Node(2);

        root.left.right = new Node(8);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(9);
        root.left.right.left.left = new Node(5);
        root.left.right.left.right = new Node(7);

        root.right = new Node(13);
        root.right.left = new Node(11);
        root.right.right = new Node(15);

        Node p = root.left.right.left.left; // Node with value 5
        Node q = root.left.right.right; // Node with value 9
        Node lca = lowestCommonAncestor(root, p, q); // Finding LCA

        // Printing the value of the lowest common ancestor
        System.out.println("Lowest Common Ancestor: " + lca.data); // Output should be 10
    }
}
