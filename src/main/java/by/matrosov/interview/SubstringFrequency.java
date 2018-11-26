package by.matrosov.interview;

import java.util.ArrayList;
import java.util.List;

public class SubstringFrequency {
    public static void main(String[] args) {
        String s = "abababab";

        List<String> list = new ArrayList<>();
        for (int j = 2; j < s.length(); j++) {
            for (int i = 0; i < s.length() - 1; i++) {
                if (j + i < s.length() + 1){
                    //System.out.println(s.substring(i, j + i));
                    list.add(s.substring(i, j + i));
                }
            }
        }

        int maxCount = 0;
        for (int i = 0; i < list.size(); i++) {
            int tempCount = 1;
            for (int j = 0; j < list.size(); j++) {
                if (i != j){
                    if (list.get(i).equals(list.get(j))){
                        tempCount++;
                    }
                }
            }

            if (tempCount > maxCount){
                maxCount = tempCount;
            }
        }
        System.out.println(maxCount);
    }
}
