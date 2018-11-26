package by.matrosov.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution1 {
    public static void main(String[] args) {
        //I/P: [‘l’, ‘a’, ‘p’, ‘t’, ‘o’, ‘p’], [3, 1, 2, 5]
        List<String> stringList = new ArrayList<>();
        stringList.add("l");
        stringList.add("a");
        stringList.add("p");
        stringList.add("t");
        stringList.add("o");
        stringList.add("p");

        List<Integer> integerList = new ArrayList<>();
        integerList.add(3);
        integerList.add(1);
        integerList.add(2);
        integerList.add(5);


        for (Integer a : integerList) {
            stringList.set(a, null);
        }

        stringList.removeIf(Objects::isNull);

        System.out.println(stringList);


    }
}
