package by.matrosov.algorithms.kadane;

/**
 * Largest Sum Contiguous Subarray
 */
public class Kadane {
    public static void main(String[] args) {
        int [] input = {-2, -3, 4, -1, -2, 1, 5, -3};

        int maxSoFar = 0;
        int maxEndingHere = 0;

        for (int a : input) {
            maxEndingHere = maxEndingHere + a;

            if (maxEndingHere < 0){
                maxEndingHere = 0;
            }

            if (maxSoFar < maxEndingHere){
                maxSoFar = maxEndingHere;
            }
        }

        System.out.println(maxSoFar); // 4 -1 -2 1 5 = 7
    }
}