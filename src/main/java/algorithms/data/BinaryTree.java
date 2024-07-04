package algorithms.data;

public class BinaryTree {

    static class Node {

        int root;
        Node left;
        Node right;

        public Node(int root) {
            this.root = root;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        Node root = new Node(5);
        System.out.println("Binary Tree Example: ");
        System.out.printf("Building binary tree with root value: %d%n", root.root);
        binaryTree.insert(root, 2);
        binaryTree.insert(root, 4);
        binaryTree.insert(root, 8);
        binaryTree.insert(root, 6);
        binaryTree.insert(root, 7);
        binaryTree.insert(root, 3);
        binaryTree.insert(root, 9);

        System.out.println("Traversing tree in order: ");
        binaryTree.traverseInOrder(root);
        System.out.println();
        System.out.println("Traversing tree pre order: ");
        binaryTree.traversePreOrder(root);
        System.out.println();
        System.out.println("Traversing tree post order: ");
        binaryTree.traversePostOrder(root);

    }

    public void insert(Node node, int value) {
        if (node.root > value) {
            if (node.left == null) {
                System.out.printf("Inserted value: %d to left of %d%n", value, node.root);
                node.left = new Node(value);
            } else {
                insert(node.left, value);
            }
        } else {
            if (node.right == null) {
                System.out.printf("Inserted value: %d to right of %d%n", value, node.root);
                node.right = new Node(value);
            } else {
                insert(node.right, value);
            }
        }
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.printf("%d ", node.root);
            traverseInOrder(node.right);
        }
    }

    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.printf("%d ", node.root);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.printf("%d ", node.root);
        }
    }
}
