package by.matrosov.interview.arraytasks;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution5 {
    public static void main(String[] args) {

        String[][] arr = {
                {"A", "1,3,4,2", "2,2,1,1,1", "3,4,4,6,8"},
                {"B", "2,3,10,1"},
                {"C", "3,9,2,1"},
                {"D", "4,4,4,3,9"},
                {"E", "5,1,4,3,4,2"},
                {"F", "5,9,9,9,9,1", "3,3,9,9"},
                {"G", "10,2,2"},
                {"H", "1,2,5,7"},
                {"I", "5,8"},
        };

        Map<String, Float> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String name = arr[i][0];

            float count = 0;
            for (int j = 1; j < arr[i].length; j++) {

                String[] marks = arr[i][j].split(",");
                float sum = 0;
                for (String mark : marks) {
                    sum = sum + Integer.parseInt(mark);
                }

                count = count + sum / marks.length;
            }
            float result = count / (arr[i].length - 1);
            //System.out.println(result);
            map.put(name, result);
        }

        map.entrySet().forEach(System.out::println);

        Object maxEntry = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();

        System.out.println("maxEntry = " + maxEntry);
    }
}
