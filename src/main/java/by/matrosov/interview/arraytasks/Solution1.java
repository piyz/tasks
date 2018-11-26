package by.matrosov.interview.arraytasks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given as set [1, 5, 7, 3, 2, 9], make subsets of 2 and 3 elements each and
 * such that sum of each set was a multiple of 3.
 * i.e [1, 5][7, 2][3, 9][1, 2][1, 5, 3][7, 2, 3] etc.,
 */
public class Solution1 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        initSet(set);
        List<Integer> list = new ArrayList<>(set);

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                System.out.println(list.get(i) + " and " + list.get(j));
            }
        }

        for (int i = 0; i < list.size() - 2; i++) {
            for (int j = i + 1; j < list.size() - 1; j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    System.out.println(list.get(i) + " and "
                            + list.get(j) + " and " + list.get(k));
                }
            }
        }
    }

    private static void initSet(Set<Integer> set){
        set.add(1);
        set.add(5);
        set.add(7);
        set.add(3);
        set.add(2);
        set.add(9);
    }
}
