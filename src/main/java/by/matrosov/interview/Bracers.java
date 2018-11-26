package by.matrosov.interview;

import java.util.Arrays;

public class Bracers {
    public static void main(String[] args) {
        String s = "[()]{}{[()()]()}";
        StringBuilder sb = new StringBuilder(s);

        while (true){
            foo(sb);
        }

    }

    private static void foo(StringBuilder s){
        // [ { (
        String first = String.valueOf(s.charAt(0));
        String last;
        switch (first) {
            case "[":
                last = "]";
                break;
            case "{":
                last = "}";
                break;
            default:
                last = ")";
                break;
        }
        int lastIndex = s.indexOf(last); //error catch = -1 unbalanced
        if (lastIndex == -1){
            return;
        }


        if (s.substring(0, lastIndex + 1).length() != 2){
            StringBuilder sb = new StringBuilder(s.substring(1, lastIndex));
            foo(sb);
        }else {
            System.out.println("balanced");
        }
    }
}