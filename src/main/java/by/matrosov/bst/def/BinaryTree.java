package by.matrosov.bst.def;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        root = null;
    }

    private void printPostOrder(Node node){
        if (node == null){
            return;
        }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.println(node.value + " ");
    }

    private void printInOrder(Node node){
        if (node == null){
            return;
        }
        printPostOrder(node.left);
        System.out.println(node.value + " ");
        printPostOrder(node.right);
    }

    private void printPreOrder(Node node){
        if (node == null){
            return;
        }
        System.out.println(node.value + " ");
        printPostOrder(node.left);
        printPostOrder(node.right);
    }

    private void printPostOrder(){
        printPostOrder(root);
    }

    private void printPreOrder(){
        printPreOrder(root);
    }

    private void printInOrder(){
        printInOrder(root);
    }

    private static void initTree(BinaryTree tree){
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        initTree(tree);

        tree.printPostOrder();
        System.out.println("\n");
        tree.printInOrder();
        System.out.println("\n");
        tree.printPreOrder();
    }
}
