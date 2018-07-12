package by.matrosov.bst.validatetree;

public class BinaryTree {

    private Node root;

    static class Node{
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private boolean isBSTUtil(Node node, int min, int max){
        if (node == null){
            return true;
        }

        if (node.data < min || node.data > max){
            return false;
        }

        return isBSTUtil(node.left, min, node.data - 1) &&
                isBSTUtil(node.right, node.data + 1, max);
    }

    private boolean isBST(){
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(3);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(4);

        if (tree.isBST()){
            System.out.println("bst");
        }else {
            System.out.println("not a bst");
        }
    }
}
