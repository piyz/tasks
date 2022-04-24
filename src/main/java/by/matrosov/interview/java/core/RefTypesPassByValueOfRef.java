package by.matrosov.interview.java.core;

import java.util.ArrayList;
import java.util.List;

public class RefTypesPassByValueOfRef {

    public static void main(String[] args) {
        String comparedString = "abc";
        ArrayList<Object> strings = new ArrayList<>();
        strings.add("abc");
        strings.forEach(s -> {
            if (s == comparedString) {
                System.out.println(comparedString);
            }
        });

    }

    public static void changeList(List<String> list) {
        String newString = new String("abc");
        list.add(newString);
        list.add("abc");
        list = new ArrayList<>();
        list.add("abc");
    }
}
