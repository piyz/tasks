package by.matrosov.algorithms.linkedlist;

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        //a->b->c->d->e->f
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        //a->f->b->e->c->d.
        int size = list.size();

        for (int i = 0; i < size/2; i++) {
            list.add(list.get(i));
            list.add(list.get(size - 1 - i));
        }

        for (int i = 0; i < size; i++) {
            list.removeFirst();
        }

        System.out.println(list);
    }
}