package by.matrosov.algorithms.matrixes;

public class MatrixSearch {
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };
        int x = 29;

        int n = matrix[0].length;
        int m = matrix.length;

        System.out.println(matrix[0][m - 1]);

        int i = 0;
        int j = m - 1;
        while (true){
            if (matrix[i][j] == x){
                System.out.println("Found at (" + i + ", " + j + ")");
                return;
            }else if (matrix[i][j] > x){
                j--;
            }else if (matrix[i][j] < x){
                i++;
            }
        }
    }
}
