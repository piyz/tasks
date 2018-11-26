package by.matrosov.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Input: Number of input : 4
 * 2*3
 * 2^2^2
 * 35
 * 3*1
 * Output:
 * 3*1
 * 2*3
 * 2^2^2
 * 35
 */
public class InputData {

    private static final int NUMBER_OF_INPUT = 4;

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputList = new ArrayList<>();

        int count = 0;
        while (count < NUMBER_OF_INPUT){
            try {
                inputList.add(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            count++;
        }

        System.out.println(inputList);
        calculate(inputList);
        System.out.println(inputList);
    }

    private static void calculate(List<String> list){
        for (int i = 0; i < list.size(); i++) {
            String[] arr;
            int sum = 0;
            if (list.get(i).contains("*")) {
                arr = list.get(i).split("\\*");
                for (String a : arr) {
                    sum = sum + Integer.parseInt(a);
                }
                list.set(i, String.valueOf(sum));
            }else if (list.get(i).contains("^")){
                arr = list.get(i).split("\\^");
                for (String a : arr) {
                    sum = sum + Integer.parseInt(a);
                }
                list.set(i, String.valueOf(sum));
            }
        }
    }
}
