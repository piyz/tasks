package by.matrosov.algorithms.brackets;

import java.util.Stack;

public class Brackets {
    public static void main(String[] args) {
        String str = "(((()()())))()(())";
        int n = 1;

        //System.out.println(findClosedBracket(str, n));
        //System.out.println(isBalanced(str));
    }

    private static int findClosedBracket(String s, int n){
        Stack<Character> brackets = new Stack<>();
        Stack<Integer> integers = new Stack<>();
        for (int i = n; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                brackets.push(s.charAt(i));
                integers.push(i);
            }else {
                if (brackets.pop() != '('){
                    //System.out.println("unbalanced");
                    return -1;
                }
                integers.pop();
            }

            if (integers.isEmpty()){
                return i;
            }
        }
        //System.out.println("unbalanced");
        return -1;
    }

    private static boolean isBalanced(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else {
                if (stack.pop() != '('){
                    //System.out.println("unbalanced");
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}