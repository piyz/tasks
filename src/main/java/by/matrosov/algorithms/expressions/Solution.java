package by.matrosov.algorithms.expressions;


public class Solution {
    public static void main(String[] args) {
        String expression = "- 2 + 5 * 2 / 10";

        expression = expression.replaceAll(" ", "");
        expression = checkFirstSymbol(expression);

        while (expression.contains("+") || expression.contains("-") || expression.contains("*") || expression.contains("/")){
            int i = 0;
            if (expression.contains("*") || expression.contains("/")){
                while (expression.charAt(i) != '*' && expression.charAt(i) != '/'){
                    i++;
                }
            }else {
                while (expression.charAt(i) != '+' && expression.charAt(i) != '-'){
                    i++;
                }
            }

            int j = i - 1;   //go to left
            while (expression.charAt(j) != '+' && expression.charAt(j) != '-'){
                j--;
                if (j == -1){
                    break;
                }
            }

            int k = i + 1;   //go to right
            while (expression.charAt(k) != '+' && expression.charAt(k) != '-' && expression.charAt(k) != '/' && k < expression.length() - 1){
                k++;
                if (k == expression.length() - 1){ //>=
                    k++;
                    break;
                }
            }

            int x;
            if (k == expression.length() - 1){
                x = build(Integer.parseInt(expression.substring(j + 1, i)), Integer.parseInt(expression.substring(i + 1)), expression.charAt(i));
                expression = String.valueOf(x);
                //System.out.println(expression);
            }else {
                x = build(Integer.parseInt(expression.substring(j + 1, i)), Integer.parseInt(expression.substring(i + 1, k)), expression.charAt(i));
                expression = expression.substring(0, j + 1) + x + expression.substring(k);
                //System.out.println(expression);
            }

            if (expression.charAt(0) == '-'){
                System.out.println(expression);
                return;
            }
        }
    }

    private static int build(int left, int right, char operand){
        if (operand == '*'){
            return left * right;
        }else if (operand == '/'){
            return left / right;
        }else if (operand == '-'){
            return left - right;
        }else if (operand == '+'){
            return left + right;
        }
        return -1;
    }

    private static String checkFirstSymbol(String s){
        while (s.charAt(0) == '-' || s.charAt(0) == '+'){
            if (s.charAt(0) == '-'){
                int i = 1;
                while (s.charAt(i) != '*' && s.charAt(i) != '/' && s.charAt(i) != '+' && s.charAt(i) != '-'){
                    i++;
                    if (i > s.length() - 1){
                        return s;
                    }
                }
                String number = s.substring(1, i);
                s = s.substring(i) + "-" + number;
            }else if (s.charAt(0) == '+'){
                s = s.substring(1);

            }
        }
        return s;
    }
}