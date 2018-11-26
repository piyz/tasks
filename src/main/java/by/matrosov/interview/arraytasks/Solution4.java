package by.matrosov.interview.arraytasks;

import java.util.Arrays;

/**
 * Check if reversing a sub array make the array sorted
 */
public class Solution4 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 5, 4, 3 };
        //int[] arr1 = { 1, 2, 4, 5, 3 };
        //int[] arr = {1, 2, 3, 4, 5};

        // 1 2 |5 4 3| -> unsorted
        // 1 2 |3 4 5| -> sorted

        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        int i = 0;
        while (arr[i] == sortedArr[i]){
            i++;
            if (i > arr.length - 1){
                System.out.println("No indices found");
                System.out.println("seems like");
                System.out.println("YES");
                return;
            }
        }

        int j = arr.length - 1;
        while (arr[j] == sortedArr[j]){
            j--;
        }

        System.out.println(i);
        System.out.println(j);

        //reverse subarray [i,j] and array.isSorted ? YES : NO
    }
}