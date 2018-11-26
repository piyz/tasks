package by.matrosov.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Input a number (say N), find out the number with same digits
 * , just/immediately greater than N. For e.g., following
 * are the outputs of the given inputs:
 */
public class Solution4 {
    public static void main(String[] args) {
        //int n = 253986321;
        //int n = 123;
        int n = 1368;

        List<String> digits = new ArrayList<>(); //1, 2, 3
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            digits.add(String.valueOf(s.charAt(i)));
        }

        while (true){
            n++;
            String temp = String.valueOf(n);

            int count = 0;
            for (String digit : digits) {
                if (temp.contains(digit)) {
                    //remove this digit from temp
                    temp = temp.replaceFirst(digit, "");
                    count++;
                }
            }

            if (count == digits.size()){
                System.out.println(n);
                return;
            }
        }
    }
}
