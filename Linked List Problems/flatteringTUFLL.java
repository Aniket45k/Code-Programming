import org.w3c.dom.Node;

public class flatteringTUFLL {
    public static class Node {
        int data;
        Node child;
        Node next;

        public Node(int data) {
            this.data = data;
            this.child = null;
            this.next = null;
        }
    }

    public static Node merge(Node list1, Node list2) {
        Node dummyNode = new Node(-1);
        Node res = dummyNode;

        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                res.child = list1;
                res = list1;
                list1 = list1.child;
            } else {
                res.child = list2;
                res = list2;
                list2 = list2.child;
            }
        }

        if (list1 != null) {
            res.child = list1;
        } else {
            res.child = list2;
        }

        return dummyNode.child;
    }

    public static Node flattenLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mergedHead = flattenLinkedList(head.next);
        head.next = null; // Disconnect the next pointer
        head = merge(head, mergedHead);

        return head;
    }

    // Utility function to print the list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.child;
        }
        System.out.println();
    }

    // Main method to test the merging and flattening functions
    public static void main(String[] args) {
        Node head = new Node(5);
        head.child = new Node(7);
        head.child.child = new Node(8);
        head.child.child.child = new Node(30);

        head.next = new Node(10);
        head.next.child = new Node(20);

        head.next.next = new Node(19);
        head.next.next.child = new Node(22);
        head.next.next.child.child = new Node(50);

        head.next.next.next = new Node(28);
        head.next.next.next.child = new Node(35);
        head.next.next.next.child.child = new Node(40);
        head.next.next.next.child.child.child = new Node(45);

        System.out.println("Original list:");
        printList(head);

        Node flattenedHead = flattenLinkedList(head);

        System.out.println("Flattened list:");
        printList(flattenedHead);
    }
}
