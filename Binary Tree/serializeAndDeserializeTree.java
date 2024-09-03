import java.util.*;

public class serializeAndDeserializeTree {
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

    public static String serialize(Node root) {
        if (root == null) {
            return "";
        }

        Queue<Node> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        q.add(root);

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node == null) {
                res.append("n ");
                continue;
            }
            res.append(node.data + " ");
            q.add(node.left);
            q.add(node.right);

        }
        return res.toString();
    }

    public static Node deserialize(String data) {
        if (data == "") {
            return null;
        }

        Queue<Node> q = new LinkedList();

        String[] values = data.split(" ");

        Node root = new Node(Integer.parseInt(values[0]));

        q.add(root);

        for (int i = 1; i < values.length; i++) {

            Node parent = q.poll();

            if (!values[i].equals("n")) {
                Node left = new Node(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }

            if (!values[++i].equals("n")) {
                Node right = new Node(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(13);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        String serializedTree = serialize(root);
        System.out.println("Serialized Tree: " + serializedTree);

    }

}
