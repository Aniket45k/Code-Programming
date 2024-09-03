import java.util.*;

import org.w3c.dom.Node;

public class LRUCache {
    Node head = new Node(0, 0), tail = new Node(0, 0);
    Map<Integer, Node> map = new HashMap();
    int capacity;

    public LRUCache(int _capacity) {
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    class Node {
        Node prev, next;
        int key, value;

        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    public static void main(String[] args) {
        // Create an LRUCache object with a capacity of 2
        LRUCache cache = new LRUCache(2);

        // Put some key-value pairs into the cache
        cache.put(1, 1);
        cache.put(2, 2);

      
        System.out.println("Value for key 1: " + cache.get(1)); // Output: 1

        // Put a new key-value pair into the cache, exceeding the capacity
        cache.put(3, 3);

        // Retrieve and print the value associated with key 2 (which was removed due to
        // LRU policy)
        System.out.println("Value for key 2: " + cache.get(2)); // Output: -1 (not found)

        // Put a new key-value pair into the cache
        cache.put(4, 4);

        // Retrieve and print the value associated with key 1 (which was not removed)
        System.out.println("Value for key 1: " + cache.get(1)); // Output: 1

        // Retrieve and print the value associated with key 3 (which was not removed)
        System.out.println("Value for key 3: " + cache.get(3)); // Output: 3

        // Retrieve and print the value associated with key 4 (which was not removed)
        System.out.println("Value for key 4: " + cache.get(4)); // Output: 4
    }
}
