import java.util.*;

public class LevelOrderTraversalInReverse {
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

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTrees(int nodes[]) {
            idx++;
            if (idx >= nodes.length || nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTrees(nodes);
            newNode.right = buildTrees(nodes);

            return newNode;
        }

        public void reverseLevelOrderTraversal(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            Stack<Node> s = new Stack<>();

            q.offer(root);
            while (!q.isEmpty()) {
                root = q.poll();
                if (root.right != null) {
                    q.offer(root.right);
                }
                if (root.left != null) {
                    q.offer(root.left);
                }
                s.push(root);
            }
            while (!s.isEmpty()) {
                System.out.print(s.pop().data + " ");
            }
        }
    }

    public static void main(String args[]) {

        int nodes[] = { 10, 20, 25, 35, -10, 0, -20, -15, 45 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTrees(nodes);
        tree.reverseLevelOrderTraversal(root);
    }
}
