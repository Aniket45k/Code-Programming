import org.w3c.dom.Node;

public class SegregatEvenOdd {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node divide(int N, Node head) {
        // Pointers for even and odd lists
        Node even = null;
        Node odd = null;
        Node o = null;
        Node e = null;

        while (head != null) {
            if (head.data % 2 == 0) { // Even
                if (even == null) {
                    even = head;
                    e = head;
                } else {
                    e.next = head;
                    e = e.next;
                }
            } else { // Odd
                if (odd == null) {
                    odd = head;
                    o = head;
                } else {
                    o.next = head;
                    o = o.next;
                }
            }
            head = head.next;
        }

        // Connect even list to odd list
        if (e != null)
            e.next = odd;
        if (o != null)
            o.next = null;

        return (even != null) ? even : odd;
    }

    // Utility function to print the list
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method to test the dividing function
    public static void main(String[] args) {
        SegregatEvenOdd SegregatEvenOdd = new SegregatEvenOdd();

        Node head = new Node(8);
        head.next = new Node(12);
        head.next.next = new Node(10);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next = new Node(6);

        System.out.println("Original list:");
        SegregatEvenOdd.printList(head);

        head = SegregatEvenOdd.divide(6, head);

        System.out.println("Divided list (even followed by odd):");
        SegregatEvenOdd.printList(head);
    }
}
