public class convertBinarytreeToDLL {
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

    static Node headLinkedList;
    static Node prev;

    public static void bstToDoublyLinkedList(Node node) {
        if (node == null) {
            return;
        }

        bstToDoublyLinkedList(node.left);

        if (prev == null) {
            headLinkedList = node;
            prev = node;
        } else {
            node.left = prev;
            prev.right = node;
            prev = node;
        }

        bstToDoublyLinkedList(node.right);
    }

    public static void printDLL(Node head) {
        System.out.println("Printing the doubly linked list:");
        while (head != null) {
            System.out.print(head.data + "<->");
            head = head.right; // Move to the next node
        }
    }

    public static void main(String[] args) {

        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         */

        Node root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(24);
        root.left.right = new Node(8);
        root.left.left = new Node(2);

        bstToDoublyLinkedList(root);
        printDLL(headLinkedList);
    }
}
