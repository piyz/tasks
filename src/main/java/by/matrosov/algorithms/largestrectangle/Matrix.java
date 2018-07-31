package by.matrosov.algorithms.largestrectangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *             0 1 1 0 1    0 1 1 0 1    0 1 1 0 1   0 1 1 0 1   0 1 1 0 1
 *             1 1 0 1 0    1   0   0    1 1 0   0   1 1 0   0   1 1 0 1 0     max = 3
 *             0 1 1 1 0 -> 0       0 -> 0 1     0 ->0 1 1   0 ->0 1 1 1 0 ->  j max = 3;
 *             1 1 1 1 0    1       0    1 1     0   1 1 2   0   1 1 2 2 0     i max = 4;
 *             1 1 1 1 1    1            1 2         1 2 2       1 2 2 3 1
 *             0 0 0 0 0    0 0 0 0 0    0 0 0 0 0   0 0 0 0 0   0 0 0 0 0
 */
public class Matrix {
    public static void main(String[] args) {
        int inputMatrix[][] =  {
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };


        //print(buildFirstRowAndFirstColumn(inputMatrix));
        //01101
        //10000
        //00000
        //10000
        //10000
        //00000

        //print(buildResult(inputMatrix, buildFirstRowAndFirstColumn(inputMatrix)));

        //01101
        //11010
        //01110
        //11220
        //12231
        //00000

        printLargestRectangle(buildResult(inputMatrix, buildFirstRowAndFirstColumn(inputMatrix)), inputMatrix);

    }

    private static void printLargestRectangle(int[][] m, int[][] inputMatrix){
        int max = 0;
        int jMax = 0;
        int iMax = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] > max){
                    max = m[i][j];
                    jMax = j;
                    iMax = i;
                }
            }
        }

        for (int j = jMax; j > jMax - max ; j--) {
            for (int i = iMax; i > iMax - max; i--) {
                System.out.print(inputMatrix[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] buildResult(int matrix[][], int newmatrix[][]){
        for (int j = 1; j < newmatrix[0].length; j++) {
            for (int i = 1; i < newmatrix.length; i++) {
                if (matrix[i][j] != 0){
                    newmatrix[i][j] = min(newmatrix[i-1][j], newmatrix[i][j-1], newmatrix[i-1][j-1]) + 1;
                }
            }
        }
        return newmatrix;
    }

    private static int min(int a, int b, int c){
        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        return Collections.min(list);
    }

    private static int[][] buildFirstRowAndFirstColumn(int matrix[][]){
        int[][] newmatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0 ){ //|| matrix[i][j] == 0
                    newmatrix[i][j] = matrix[i][j];
                }
            }
        }
        return newmatrix;
    }

    private static void print(int m[][]){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
    }
}