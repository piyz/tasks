package by.matrosov.datastructure.stack;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        initStack(stack);
        sortStack(stack);
        System.out.println(stack);
    }

    private static void initStack(Stack<Integer> stack){
        stack.add(30);
        stack.add(-5);
        stack.add(18);
        stack.add(14);
        stack.add(-3);
        stack.add(100);
        stack.add(-25);
    }

    private static void sortStack(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int curr = stack.peek();
        stack.pop();
        stack.push(sortStack(stack, curr));
    }

    private static int sortStack(Stack<Integer> stack, int min){
        if (stack.isEmpty()){
            return min;
        }
        int curr = stack.peek();
        stack.pop();

        if (curr > min){
            curr = sortStack(stack, curr);
        }else {
            min = sortStack(stack, min);
        }

        if (curr > min){
            stack.push(curr);
            return min;
        }else {
            stack.push(min);
            return curr;
        }
    }
}
