package by.matrosov.algorithms.binarysearch;

import java.util.Arrays;
import java.util.Collections;

/**
 * Search an element in a sorted and rotated array
 */
public class SearchElement {

    private static final int KEY = 9;

    public static void main(String[] args) {
        // 5 6 7 8 9 10 | 1 2 3 -> 2 sub arrays
        Integer[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int min = Collections.min(Arrays.asList(arr));
        int index = findIndexOfMinValue(min, arr);

        if (KEY == min){
            System.out.println("found at index " + index);
        }else if (KEY > arr[arr.length - 1]){
            binarySearch(arr, 0, index - 1);
        }else {
            binarySearch(arr, index, arr.length - 1);
        }
    }

    private static int findIndexOfMinValue(int min, Integer[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min){
                return i;
            }
        }
        return -1;
    }

    private static void binarySearch(Integer[] arr, int left, int right){
        BinarySearch binarySearch = new BinarySearch();

        int result = binarySearch.binarySearch(arr, left, right, KEY);
        if (result == -1){
            System.out.println("not found");
        }else {
            System.out.println("found at index " + result);
        }
    }
}
