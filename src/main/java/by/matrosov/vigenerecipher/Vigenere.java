package by.matrosov.vigenerecipher;

import java.util.ArrayList;
import java.util.List;

public class Vigenere {

    private static final String KEY = "симулякр";
    private static List<String> table = new ArrayList<>();

    public static void main(String[] args) {
        createVigenereTable(table);

        String encryptedText = "щмсез лщуэи ноюы хбсъххлю бщдияу фж юэячц ющзнщ, яч яо ынцдисеп юнцмьч йёф зьёамъор гкюядс: ёьз,отс,шлёз,нощя,цыяз,цпгмщс 40,20,5,26,25,28. гълпюрт хи шдьгсхх ь нрэруе о юъг.";

        encryptedText = encryptedText.replaceAll(" ", "")
                .replaceAll("\\d", "")
                .replaceAll(",", "")
                .replaceAll(":", "")
                .replaceAll("\\.", "");

        StringBuilder sbKey = new StringBuilder(KEY);
        while (sbKey.length() < encryptedText.length()){
            sbKey.append(KEY);
        }

        System.out.println(sbKey.toString());
        System.out.println(encryptedText);

        for (int i = 0; i < encryptedText.length(); i++) {

            int j = 0;
            while (sbKey.charAt(i) != table.get(j).charAt(0)){
                j++;
            }

            int index = table.get(j).indexOf(encryptedText.charAt(i));
            System.out.println(table.get(0).charAt(index));
        }
    }

    private static List<String> createVigenereTable(List<String> table){
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

        for (int i = 0; i < abc.length(); i++) {
            String s = abc.substring(i) + abc.substring(0, i);
            table.add(s);
        }

        return table;
    }

    private String removeNonLetterChars(String s){
        return s.replaceAll(" ", "")
                .replaceAll("\\d", "")
                .replaceAll(",", "")
                .replaceAll(":", "")
                .replaceAll("\\.", "");
    }

    //int[] arr2 = {3, 2, 5, 1, 0, 4};
    //int[] arr1 = {40, 20, 5, 26, 25, 28};
    //
    //        Optional<String> sequence = Stream.iterate(0, i -> arr2[i])
    //                .map(res -> arr1[res])
    //                .skip(1)
    //                .limit(arr2.length)
    //                .map(Object::toString)
    //                .reduce((a, b) -> a + ", " + b);
    //
    //        if (sequence.isPresent()){
    //            sequence.map(s -> new StringBuilder(s).reverse().toString());
    //        }
    //
    //        System.out.println(String.format("%s-%s-%s-%s-%s-%s", sequence.get().split(",")));
    //
    //
}
