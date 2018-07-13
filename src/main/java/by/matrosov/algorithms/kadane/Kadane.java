package by.matrosov.algorithms.kadane;

import java.util.LinkedList;

/**
 * Largest Sum Contiguous Subarray
 */
public class Kadane {
    public static void main(String[] args) {
        int [] input = {-2, -3, 4, -1, -2, 1, 5, -3};

        LinkedList<Integer> list = new LinkedList<>();
        int maxSoFar = 0;
        int maxEndingHere = 0;

        for (int i = 0; i < input.length; i++) {
            list.add(i);

            maxEndingHere = maxEndingHere + input[i];

            if (maxEndingHere < 0){
                maxEndingHere = 0;
                list.clear();
            }

            if (maxSoFar < maxEndingHere){
                maxSoFar = maxEndingHere;
            }else {
                if (!list.isEmpty())
                    list.removeLast();
            }
        }
        System.out.println(list);
        System.out.println(maxSoFar); // 4 -1 -2 1 5 = 7
    }
}