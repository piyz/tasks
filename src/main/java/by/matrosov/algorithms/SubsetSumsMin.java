package by.matrosov.algorithms;

/**
 * Given a set of integers, the task is to divide
 * it into two sets S1 and S2 such that the absolute
 * difference between their sums is minimum.
 */
public class SubsetSumsMin {
    public static void main(String[] args) {
        int arr[] = {3, 1, 4, 2, 2, 1};

        System.out.println(findMin(arr, arr.length));
    }

    private static int findMin(int[] arr, int n){
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        boolean matrix[][] = new boolean[n + 1][sum + 1];

        /*
                         (sum + 1)
                t f f f f
                t
                t
                t
        (n + 1) t

                 init step
         */

        for (int i = 0; i < n + 1; i++) {
            matrix[i][0] = true;
        }

        for (int i = 1; i < sum + 1; i++) {
            matrix[0][i] = false;
        }

        /*
                0 1 2 3 4 5 6 7 8 9 10 11 12 (j = sum)

                t f f f f f f f f f  f  f  f
            3   t t f|t f f f f f f  f  f  f
            1   t|t t f t f f f f f  f  f  f
            4   t t t t|t t t f t f  f  f  f
            2   t t|t t t t t t t f  t  f  f
            2   t t|t t t t t t t t  t  f  t
            1   t|t t t t t t t t t  t  t  f      result = sum - 2j = 13 - 2*6
          (i-1)                                  /
                                                /(j=x) from sum/2 to 0 -> find matrix[n][j] = true
          x (1st subarray sum)                 /
          s - x (2nd subarray sum)            /
          need to min{abs(s-x-x)} -> min{s-2x} -> max{x} (x <= s/2)

         */


        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                matrix[i][j] = matrix[i - 1][j];

                if (arr[i - 1] <= j){
                    matrix[i][j] = matrix[i][j] | matrix[i - 1][j - arr[i - 1]]; //from [i-1][0->]
                }
            }
        }

        return -1;
    }

    private static void print(boolean[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + "::");
            }
            System.out.println();
        }
    }
}
