package by.matrosov.bst;

import java.util.Stack;

public class Tree {
    private Node root;

    static class Node{
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node add(Node current, int value){
        if (current == null){
            return new Node(value);
        }

        if (value < current.value){
            current.left = add(current.left, value);
        }else if (value > current.value){
            current.right = add(current.right, value);
        }else {
            return current;
        }

        return current;
    }

    private void add(int value){
        root = add(root, value);
    }

    private void printUtil(Node node){
        if (node == null){
            return;
        }
        System.out.print(node.value + " ");
        printUtil(node.left);
        printUtil(node.right);
    }

    private void print(){
        printUtil(root);
    }

    private void printPathsUtil(Node node, Stack<Integer> path, int k){
        if (node == null){
            return;
        }

        path.push(node.value);

        printPathsUtil(node.left, path, k);
        printPathsUtil(node.right, path, k);

        int sum = 0;
        for (int i = path.size() - 1; i > -1; i--) {
            sum = sum + path.get(i);
            if (sum == k){
                for (int j = i; j < path.size(); j++) {
                    System.out.print(path.get(j) + " ");
                }
                System.out.println();
            }
        }
        
        path.pop();
    }

    private void printPaths(int k){
        Stack<Integer> stack = new Stack<>();
        printPathsUtil(root, stack, k);
    }

    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.root = new Node(1);
        tree.root.left = new Node(3);
        tree.root.right = new Node(-1);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(1);
        tree.root.left.right.left = new Node(1);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(5);
        tree.root.right.right.right = new Node(6);
        tree.root.right.left.left = new Node(1);
        tree.root.right.left.right = new Node(2);

        //tree.print();

        tree.printPaths(5);
    }

}