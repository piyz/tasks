package by.matrosov.algorithms;

import java.util.Arrays;

public class ThreeColours {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};

        System.out.println(Arrays.toString(foo(arr)));
    }

    private static int[] foo(int[] arr){
        int l = 0;
        int m = 0;
        int h = arr.length - 1;

        while (m <= h){
            if (arr[m] == 0){
                swap(m, l, arr);
                m++;
                l++;
            }else if (arr[m] == 1){
                m++;
            }else if (arr[m] == 2){
                swap(m, h, arr);
                h--;
            }
        }
        return arr;
    }

    private static void swap(int a, int b, int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /*
            0 1 1 0 1 2 1 2 0 0 0 1
            l                     h     m = 0 -> swap(m,l) -> m++, l++
            m

            0 1 1 0 1 2 1 2 0 0 0 1
              l                   h
              m                         m = 1 -> m++

            0 1 1 0 1 2 1 2 0 0 0 1
              l   m               h     m = 0 -> swap(m,l) -> m++, l++

            0 0 1 1 1 2 1 2 0 0 0 1
                l   m             h     m = 1 -> m++

            0 0 1 1 1 2 1 2 0 0 0 1
                l     m           h     m = 2 -> swap(m,h) -> h--

            ...

         */
}