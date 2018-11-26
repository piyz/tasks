package by.matrosov.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        //Integer[] arr = {1, 2, 3, 4, 5, 5, 5};
        Integer[] arr = {1, 2, 5, 7, 8, 8, 7};
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));

        List<Integer> result = new ArrayList<>();
        for (Integer a : list) {
            if (!result.contains(a)) {
                result.add(a);
            }else {
                while (result.contains(a)){
                    a++;
                }
                result.add(a);
            }
        }
        System.out.println(result);
    }
}
