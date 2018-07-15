package by.matrosov.algorithms;

/**
 * Find the n-th closest palindromic number to a given number.
 * If number is 127 and n is 1, answer is 131. If n is 2, answer is 121.
 */
public class Solution {

    private static int NUMBER = 127;
    private static final int N = 2;

    public static void main(String[] args) {
        int numberUp = NUMBER, numberDown = NUMBER;
        int count = 0;
        while (true){
            if (isPalindrome(--numberDown) || isPalindrome(++numberUp)){
                count++;
            }
            if (count == N){
                if (isPalindrome(numberDown)){
                    System.out.println(numberDown);
                    return;
                }else {
                    System.out.println(numberUp);
                    return;
                }
            }
        }
    }

    private static boolean isPalindrome(int a){
        StringBuilder sb = new StringBuilder(String.valueOf(a));
        int b = Integer.parseInt(sb.reverse().toString());
        return a == b;
    }
}
