public class isPalindrome {
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

    // slow-fast approach
    public Node findMid(Node head) {// helper
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;// +1
            fast = fast.next.next;
        }
        return slow;// slow is my midNode
    }

    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        // step1 - first mid
        Node midNode = findMid(head);
        // step2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;// right half head
        Node left = head;

        // step3 - check left half & right half
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;

        }
        return true;
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
        isPalindrome ll = new isPalindrome();

        ll.addFirst(3);
        ll.addFirst(1);
        ll.addFirst(1);
        ll.addFirst(3);
        ll.print();
        System.out.println(ll.checkPalindrome());

    }

}
