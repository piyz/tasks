package by.matrosov.algorithms.matrixes;

public class MaxPathSum {
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 10, 2, 0, 20, 4},
                {1, 0, 0, 30, 2, 5},
                {0, 10, 4, 0, 2, 0},
                {1, 0, 2, 20, 0, 4},
        };

        findPath(matrix);

        //System.out.println(matrix.length);
        //System.out.println(matrix[0].length);
    }

    private static void findPath(int[][] matrix){

        int sum = -1;
        for (int i = 1; i < matrix.length; i++) {

            sum = -1;
            for (int j = 0; j < matrix[0].length; j++) {

                if (j > 0 && j < matrix[0].length - 1){
                    matrix[i][j] += max(matrix[i-1][j-1], max(matrix[i-1][j], matrix[i-1][j+1]));
                }else if (j > 0){ //last
                    matrix[i][j] += max(matrix[i-1][j-1], matrix[i-1][j]);
                }else if (j < matrix[0].length - 1){ //first
                    matrix[i][j] += max(matrix[i-1][j], matrix[i-1][j+1]);
                }

                sum = max(sum, matrix[i][j]);
            }
        }
        System.out.println(sum);
    }

    private static int max(int a, int b){
        if (a >= b){
            return a;
        }else {
            return b;
        }
    }
}