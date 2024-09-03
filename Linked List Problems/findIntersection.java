import org.w3c.dom.Node;

public class findIntersection {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node findIntersection(Node firstHead, Node secondHead) {
        if (firstHead == null || secondHead == null) {
            return null;
        }

        Node temp1 = firstHead;
        Node temp2 = secondHead;

        while (temp1 != temp2) {
            temp1 = (temp1 == null) ? secondHead : temp1.next;
            temp2 = (temp2 == null) ? firstHead : temp2.next;
        }

        return temp1;
    }

    public static void main(String[] args) {
        // Create first linked list: 1 -> 3 -> 5 -> 7 -> 9
        Node firstHead = new Node(1);
        firstHead.next = new Node(3);
        firstHead.next.next = new Node(5);
        firstHead.next.next.next = new Node(7);
        firstHead.next.next.next.next = new Node(9);

        // Create second linked list: 2 -> 4 -> 6 -> 7 -> 9
        Node secondHead = new Node(2);
        secondHead.next = new Node(4);
        secondHead.next.next = new Node(6);
        secondHead.next.next.next = firstHead.next.next.next; // Intersect at node with data 7
        secondHead.next.next.next.next = firstHead.next.next.next.next; // Intersect at node with data 9

        Node intersectionNode = findIntersection(firstHead, secondHead);

        if (intersectionNode != null) {
            System.out.println("Intersection at node with data: " + intersectionNode.data);
        } else {
            System.out.println("No intersection found.");
        }
    }
}
