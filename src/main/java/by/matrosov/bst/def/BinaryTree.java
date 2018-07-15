package by.matrosov.bst.def;

import java.util.HashSet;
import java.util.Set;

public class BinaryTree {
    private Node root;
    private int maxVisitedLevel = 0;

    private BinaryTree() {
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

    private static void initTree(BinaryTree tree){
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
    }

    private void printAllLevels(Node root){
        int h = height(root);
        for (int i = 1; i < h + 1; i++) {
            printLevel(root, i);
            System.out.println();
        }
    }

    private int height(Node root) {
        if (root == null){
            return 0;
        }else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            if (leftHeight > rightHeight){
                return leftHeight + 1;
            }else {
                return rightHeight + 1;
            }
        }
    }

    private void printLevel(Node root, int lvl) {
        if (root == null){
            return;
        }
        if (lvl == 1){
            System.out.println(root.value);
        }else if (lvl > 1){
            printLevel(root.left, lvl - 1);
            printLevel(root.right, lvl - 1);
        }
    }

    private boolean checkDuplicates(Node root){
        Set<Integer> set = new HashSet<>();
        return checkDuplicatesUtil(root, set);
    }

    private boolean checkDuplicatesUtil(Node root, Set<Integer> set){
        if (root == null){
            return false;
        }

        if (set.contains(root.value)){
            return true;
        }

        set.add(root.value);

        return checkDuplicatesUtil(root.left, set) || checkDuplicatesUtil(root.right, set);
    }

    private void printLeftViewUtil(Node node, int currentLevel){
        if (node == null){
            return;
        }

        if (currentLevel > maxVisitedLevel){
            System.out.println(node.value);
            maxVisitedLevel = currentLevel;
        }

        printLeftViewUtil(node.left, currentLevel + 1);
        printLeftViewUtil(node.right,currentLevel + 1);
    }

    private void printLeftView(){
        printLeftViewUtil(root, 1);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        initTree(tree);

        tree.printLeftView();
    }
}
