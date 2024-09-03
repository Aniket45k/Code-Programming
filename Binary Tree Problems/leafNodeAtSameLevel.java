public class leafNodeAtSameLevel {
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

    static int levelOfLeaf;

    public static boolean ifLeavesAtSameLevel(Node node, int level) {
        if (node == null) {
            return true;
        }

        if (node.left == null && node.right == null) {
            if (levelOfLeaf == 0) {
                levelOfLeaf = level;
                return true;
            }

            return levelOfLeaf == level;
        }

        return ifLeavesAtSameLevel(node.left, level + 1) && ifLeavesAtSameLevel(node.right, level + 1);
    }

    public static void main(String[] args) {
        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         * \
         * 8
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(8);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(ifLeavesAtSameLevel(root, 1));
    }
}
