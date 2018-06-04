package by.matrosov.bst.buildtree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BinaryTree {
    private static Set<TreeNode> set = new HashSet<>();
    private static Stack<TreeNode> stack = new Stack<>();

    private TreeNode buildTree(int[] pre, int[]in){
        //impl build tree
    }

    private void printInOrder(TreeNode node){
        if (node == null){
            return;
        }
        printInOrder(node.left);
        System.out.print(node.value + " ");
        printInOrder(node.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        int in[] = new int[]{9, 8, 4, 2, 10, 5, 10, 1, 6, 3, 13, 12, 7};
        int pre[] = new int[]{1, 2, 4, 8, 9, 5, 10, 10, 3, 6, 7, 12, 13};

        TreeNode root = tree.buildTree(pre, in);

        tree.printInOrder(root);
    }
}
