package by.matrosov.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberInString {
    public static void main(String[] args) {
        String s = "010203";

        List<Integer> result = new ArrayList<>();
        int count = 0;
        while (count < s.length() - 1){
            for (int i = 0; i < s.length() - count; i++) {
                result.add(Integer.parseInt(s.substring(i, i + 1 + count)));
            }
            //System.out.println(result);
            if (result.stream().sorted().collect(Collectors.toList()).equals(result)){
                System.out.println("YES");
                return;
            }
            result.clear();
            count++;
        }
        System.out.println("NO");
    }
}