package by.matrosov.interview.arraytasks;

import java.util.*;

/**
 * If an array contained [1, 10, 3, 5, 2, 7] and k = 2,
 * combine the set as {110, 35, 27}, sort the set {27, 35, 110}
 * and split the set into array as [2, 7, 3, 5, 1, 10]
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] arr = {1, 10, 3, 5, 2, 7};
        int k = 2;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i+=2) {
            list.add(Integer.valueOf(String.valueOf(arr[i]) + arr[i + k - 1]));
        }
        Collections.sort(list);
        System.out.println(list);

        List<Integer> result = new ArrayList<>();
        for (Integer a : list) {
            String s = String.valueOf(a);
            for (int j = 0; j < s.length(); j++) {
                result.add(Integer.parseInt(String.valueOf(s.charAt(j))));
            }
        }
        System.out.println(result);

    }
}