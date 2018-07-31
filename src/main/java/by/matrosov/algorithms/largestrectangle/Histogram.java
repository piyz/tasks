package by.matrosov.algorithms.largestrectangle;

import java.util.Stack;

/**
 * Find the largest rectangular area possible in a given histogram where
 * the largest rectangle can be made of a number of contiguous bars.
 * For simplicity, assume that all bars have same width and the width is 1 unit.
 *
 * EXAMPLE:
 *             |
 *             |
 *           | | |     -->       | | |
 *           | | | |             | | |
 *
 *            input              output
 *          histogram      largest rectangle = 6
 */
public class Histogram {
    public static void main(String[] args) {
        //int[] input = {2, 4, 2, 1}; //6
        int[] input = {2, 4, 2, 1, 10, 6, 10}; //18
        System.out.println(findLargestRectangle(input));
    }

    private static int findLargestRectangle(int[] array){
        Stack<Integer> heights = new Stack<>();
        Stack<Integer> indexes = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < array.length; i++) {

            if (heights.isEmpty() || array[i] > heights.peek()){
                heights.push(array[i]);
                indexes.push(i);
            }else if (array[i] < heights.peek()){

                int prevIndex = 0;
                while (!heights.isEmpty() && array[i] < heights.peek()){
                    prevIndex = indexes.pop();
                    int area = heights.pop() * (i - prevIndex); //!
                    if (area > maxArea){
                        maxArea = area;
                    }
                }
                heights.push(array[i]);
                indexes.push(prevIndex); //!
            }
        }

        while (!heights.isEmpty()){
            int area = heights.pop() * (array.length - indexes.pop()); //!
            if (area > maxArea){
                maxArea = area;
            }
        }

        return maxArea;
    }
}