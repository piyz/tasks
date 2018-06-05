package by.matrosov.bst.buildtree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BinaryTree {
    private static Set<TreeNode> set = new HashSet<>();
    private static Stack<TreeNode> stack = new Stack<>();

    private TreeNode buildTree(int[] preorder, int[] inorder){
        TreeNode root = null;
        for(int pre = 0, in = 0; pre < preorder.length;) {

            TreeNode node;
            do {
                node = new TreeNode(preorder[pre]);
                if(root == null) {
                    root = node;
                }
                if(!stack.isEmpty()) {
                    if(set.contains(stack.peek())) {
                        set.remove(stack.peek());
                        stack.pop().right = node;
                    } else {
                        stack.peek().left = node;
                    }
                }
                stack.push(node);
            } while(preorder[pre++] != inorder[in] && pre < preorder.length);

            node = null;
            while(!stack.isEmpty() && in < inorder.length && stack.peek().value == inorder[in]) {
                node = stack.pop();
                in++;
            }

            if(node != null) {
                set.add(node);
                stack.push(node);

            }
        }
        return root;
    }

    private void printInOrder(TreeNode node){
        if (node == null){
            return;
        }
        printInOrder(node.left);
        System.out.print(node.value + " ");
        printInOrder(node.right);
    }

    private void printPostOrder(TreeNode node){
        if (node == null){
            return;
        }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.value + " ");
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        int in[] = new int[]{9, 8, 4, 2, 10, 5, 10, 1, 6, 3, 13, 12, 7};
        int pre[] = new int[]{1, 2, 4, 8, 9, 5, 10, 10, 3, 6, 7, 12, 13};

        TreeNode root = tree.buildTree(pre, in);

        tree.printPostOrder(root);
    }
}
