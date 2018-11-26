package by.matrosov.interview;

import java.util.HashSet;
import java.util.Set;

public class AnagramSubstrings {
    public static void main(String[] args) {
        String s = "xyyx";

        //1  x y y x
        //2 xy yy yx
        //3 xyy yyx
        //4 xyyx

        //0 1 -> 1 2 -> 2 3 -> 3 4
        //0 2 -> 1 3 -> 1 4
        //0 3 -> 1 4
        //0 4

        //System.out.println(s.substring(0, 4));

        Set<String> anagrams = new HashSet<>();
        for (int j = 1; j < s.length() + 1; j++) {
            for (int i = 0; i < s.length(); i++) {
                if (s.length() + 1 > i + j){
                    if (isAnagram(s.substring(i, i + j))){
                        anagrams.add(s.substring(i, i + j));
                    }
                }
            }
        }
        System.out.println(anagrams); //[yy, x, xyyx, y] = 4
    }

    private static boolean isAnagram(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.toString().equals(sb.reverse().toString());
    }
}