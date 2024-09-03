import java.util.*;

public class cloneLL {

    public static class Node {
        int data;
        Node next;
        Node random;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.random = null;
        }
    }

    public static void insertCopyInBetween(Node head) {
        Node temp = head;

        while (temp != null) {
            Node nextElement = temp.next;
            Node copy = new Node(temp.data);

            copy.next = nextElement;
            temp.next = copy;
            temp = nextElement;
        }
    }

    public static void connectRandomPointers(Node head) {
        Node temp = head;

        while (temp != null) {
            Node copyNode = temp.next;

            if (temp.random != null) {
                copyNode.random = temp.random.next;
            } else {
                copyNode.random = null;
            }

            temp = temp.next.next;
        }
    }

    public static Node getDeepCopyList(Node head) {
        Node temp = head;
        Node dummyNode = new Node(-1);
        Node res = dummyNode;

        while (temp != null) {
            res.next = temp.next;
            res = res.next;

            // Disconnecting and going back to initial state of the original list
            temp.next = temp.next.next;
            temp = temp.next;
        }

        return dummyNode.next;
    }

    public static Node cloneLL(Node head) {
        insertCopyInBetween(head);
        connectRandomPointers(head);
        return getDeepCopyList(head);
    }

    // Utility function to print the list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print("Data: " + temp.data + ", Random: " + (temp.random != null ? temp.random.data : "null")
                    + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method to test the cloning function
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next;
        head.next.next.next.random = head.next.next;

        System.out.println("Original list:");
        printList(head);

        Node clonedHead = cloneLL(head);

        System.out.println("Cloned list:");
        printList(clonedHead);
    }
}
