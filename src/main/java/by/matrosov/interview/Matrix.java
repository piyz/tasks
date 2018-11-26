package by.matrosov.interview;

public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                { 1, 2, 3, 4 },
                { 6, 5, 4, 3 }
        };

        // 6 1   [1][0]   [0][0]
        // 5 2   [1][1]   [0][1]
        // ...
        // 1 6

        //System.out.println(matrix[1][2]); = 4

        int j = matrix.length - 1;
        for (int i = 0; i < matrix[0].length; i++) {
            System.out.println(matrix[j][i] + ", " + matrix[j-1][i]);
        }
    }
}
