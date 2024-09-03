import java.util.*;
import java.util.LinkedList;

import org.w3c.dom.Node;

public class mergeTwoSortedLinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedList {
        public Node head;
        public Node tail;
        public int size;

        public void addFirst(int data) {
            // Step 1 - create new node
            Node newNode = new Node(data);
            size++;
            if (head == null) {
                head = tail = newNode;
                return;
            }
            // Step 2 - newNode next=head
            newNode.next = head; // link

            // Step 3 - head=newNode
            head = newNode;
        }

        public void print() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    public static Node mergeLL(Node list1, Node list2) {
        Node t1 = list1;
        Node t2 = list2;
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;
        while (t1 != null && t2 != null) {
            if (t1.data < t2.data) {
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            } else {
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }
        if (t1 != null) {
            temp.next = t1;
        } else {
            temp.next = t2;
        }
        return mergeLL.next;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();

        ll1.addFirst(10);
        ll1.addFirst(8);
        ll1.addFirst(4);
        ll1.addFirst(2);
        ll1.print();

        ll2.addFirst(14);
        ll2.addFirst(11);
        ll2.addFirst(6);
        ll2.addFirst(3);
        ll2.addFirst(3);
        ll2.addFirst(1);
        ll2.print();

        Node mergedList = mergeLL(ll1.head, ll2.head);
        printList(mergedList);

    }
}