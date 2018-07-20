package by.matrosov.algorithms.rpn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReversePolishNotation {
    public static void main(String[] args) {
        //15 7 1 1 + − ÷ 3 × 2 1 1 + + −
        String[] inputArr = {"15", "7", "1", "1", "+", "-", "÷", "3", "×", "2", "1", "1", "+", "+", "-"};
        List<String> input = new ArrayList<>(Arrays.asList(inputArr));

        while (true){
            int i = 0;
            outer: while (true){
                if (input.get(i).equals("+") || input.get(i).equals("-") || input.get(i).equals("×") || input.get(i).equals("÷")){
                    int j = i + 1;
                    while (true){
                        if (!input.get(j).equals("+") && !input.get(j).equals("-") && !input.get(j).equals("×") && !input.get(j).equals("÷")){
                            List<String> list = new ArrayList<>();
                            while (true){
                                for (int k = 0; ;k++) {
                                    list.add(input.get(i-1-k));
                                    if (i-1-k-1 < 0){
                                        //System.out.println(list);
                                        String n = calculatePartOfArr(list);
                                        for (int l = 0; l < j; l++) {
                                            input.remove(0);
                                        }

                                        if (input.isEmpty()){
                                            System.out.println(n);
                                            return;
                                        }

                                        input.add(0, n);
                                        break outer;
                                    }
                                    list.add(input.get(i+k));
                                }
                            }
                        }else {
                            j++;
                        }
                    }
                }else {
                    i++;
                }
            }
        }

    }

    private static String calculatePartOfArr(List<String> list){
        while (true){
            int n = operation(Integer.parseInt(list.get(2)), Integer.parseInt(list.get(0)), list.get(1));
            for (int i = 0; i < 3; i++) {
                list.remove(0);
            }

            if (list.isEmpty()){
                return String.valueOf(n);
            }

            list.add(0, String.valueOf(n));
        }
    }

    private static int operation(int operand1, int operand2, String operator){
        switch (operator) {
            case "+":
                return operand1 + operand1;
            case "-":
                return operand1 - operand2;
            case "×":
                return operand1 * operand2;
            case "÷":
                return operand1 / operand2;
        }
        return Integer.parseInt(null);
    }
}
