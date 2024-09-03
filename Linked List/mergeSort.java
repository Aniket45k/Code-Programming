public class mergeSort {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {// O(1)
        // step1 - create new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // step2 - newNode next=head
        newNode.next = head;// link

        // step3 - head=newNode
        head = newNode;
    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;// mid Node;
    }

    private Node merge(Node head1, Node head2) {

        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;

    }

    public Node mergesort(Node head) {
        if ((head == null) || head.next == null) {
            return head;
        }
        // find mid
        Node mid = getMid(head);
        // left & right ms
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergesort(head);
        Node newRight = mergesort(rightHead);
        // merge
        return merge(newLeft, newRight);

    }

    public void print() {// O(n)

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        mergeSort ll = new mergeSort();
        ll.addFirst(1);
        ll.addFirst(5);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.print();
        ll.head = ll.mergesort(ll.head);
        ll.print();

    }
}