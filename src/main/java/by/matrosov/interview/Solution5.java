package by.matrosov.interview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 1. If the unit’s digit is less than 5 return the nearest multiple of 10 smaller
 * than the given number and if it is greater than or equal to 5, return the nearest
 * multiple of 10 greater than the given number.
 */
public class Solution5 {
    public static void main(String[] args) {
        int input = 144;
        //int input = 156;

        //    0 <-  1 2 3 4
        //                  5 6 7 8 9 -> 0

        System.out.println(nearestMultipleOfTen(input));
    }

    private static String nearestMultipleOfTen(int x){
        String s = String.valueOf(x);

        StringBuilder sb = new StringBuilder(s);
        if (s.length() < 5){ //check for 0

            if (stringContainsNumber(String.valueOf(s.charAt(s.length() - 1)))){ //1-4
                sb = sb.replace(s.length() - 1, s.length(), "0");
            }else { //4-9
                int i = Integer.parseInt(String.valueOf(s.charAt(s.length() - 2))) + 1;
                sb = sb.replace(s.length() - 1, s.length(), "0");
                sb = sb.replace(s.length() - 2, s.length() - 1, String.valueOf(i));
            }

        }else {

        }

        return sb.toString();
    }

    private static boolean stringContainsNumber(String s){
        Pattern p = Pattern.compile("[1-4]");
        Matcher m = p.matcher(s);

        return m.find();
    }
}
