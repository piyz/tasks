package by.matrosov.interview;

import java.util.Arrays;
import java.util.Stack;

/**
 * Input:  digits[] = "121"
 * Output: 3
 * The possible decodings are "ABA", "AU", "LA"
 *
 * Input: digits[] = "1234"
 * Output: 3
 * The possible decodings are "ABCD", "LCD", "AWD"
 */
public class StringDecoding {
    public static void main(String[] args) {
        int[] digits = {1, 2, 1};
        System.out.println(countDecoding(digits, digits.length));
    }

    private static int countDecoding(int[] digits, int n){
        if (n == 0 || n == 1){
            return 1;
        }

        int count = 0;

        if (digits[n - 1] != 0){
            count = count + countDecoding(digits, n - 1);
        }

        if (digits[n - 2] == 1 || (digits[n - 2] == 2 && digits[n - 1] < 7)){
            count = count + countDecoding(digits, n - 2);
        }

        return count;
    }
}