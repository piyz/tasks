package by.matrosov.algorithms.lastdigitpowab;

/**
 * Count the number of times a appears as the last digit
 * in a^b where b is from 1 to n
 */
public class Solution {

    private static final String a = "11798374329042424237";
    private static final String b = "38923839433";

    public static void main(String[] args) {
        int base = Integer.parseInt(String.valueOf(a.charAt(a.length() - 1)));
        int mod = mod(b, 4);
        int exponent = mod == 0 ? 4 : mod;

        double result = Math.pow(base, exponent) % 10;
        System.out.println(result);
    }

    private static int mod(String number, int a){
        int mod = 0;
        for (int i = 0; i < number.length(); i++) {
            mod = (mod * 10 + Integer.parseInt(String.valueOf(number.charAt(i)))) % a;
        }
        return mod;
    }
}