package by.matrosov.interview.arraytasks;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public static void main(String[] args) {
        byte[] arr = {0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0};

        List<Integer> list = new ArrayList<>();
        for (byte a : arr) {
            list.add(a ^ 1);
        }
        System.out.println(list);
    }
}
