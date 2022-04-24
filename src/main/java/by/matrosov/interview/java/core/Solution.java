package by.matrosov.interview.java.core;

import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf(100) == 100);
        System.out.println(new Integer(100) == 100);
        System.out.println(new Integer(100) == new Integer(100));
        System.out.println(Integer.valueOf(100) == Integer.valueOf(100));
        Stream.of("1", "2", "3")
                .map(v-> {
                    System.out.println(v);
                    return v;
                }).findFirst();
        String a = "a";
        String a1 = new String("a");
        System.out.println(a == a1.intern());
        System.out.println(a == a1);
        Boolean someCondition = null;
        if (someCondition) {
            System.out.println("someCondition");
        } else {
            System.out.println("not someCondition");
        }
    }
}
