import java.util.*;

public class printPathsSumOfNodeEqualToPath {
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

    static List<Integer> elements = new ArrayList<Integer>();

    public static void printKPathEqualToSum(Node node, int val) {
        if (node == null) {
            return;
        }

        elements.add(node.data);

        printKPathEqualToSum(node.left, val);
        printKPathEqualToSum(node.right, val);

        int sum = 0;

        for (int i = elements.size() - 1; i >= 0; i--) {

            sum = sum + elements.get(i);

            if (sum == val) {

                for (int j = i; j < elements.size(); j++) {
                    System.out.print(elements.get(j) + " ");
                }

                System.out.println();
            }
        }

        elements.remove(elements.size() - 1);
    }

    public static void main(String[] args) {

        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         */

        Node root = new Node(2);
        root.left = new Node(-1);
        root.right = new Node(4);
        root.left.right = new Node(7);
        root.left.right.right = new Node(3);
        root.left.left = new Node(1);
        root.left.left.right = new Node(5);

        printKPathEqualToSum(root, 6);
    }
}
