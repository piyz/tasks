package by.matrosov.vigenerecipher;

import java.util.ArrayList;
import java.util.List;

public class Vigenere {

    private static final String KEY = "симулякр";
    private static List<String> table = new ArrayList<>();

    public static void main(String[] args) {
        String encryptedText = "щмсез лщуэи ноюы хбсъххлю бщдияу фж юэячц ющзнщ, яч яо ынцдисеп юнцмьч йёф зьёамъор гкюядс: ёьз,отс,шлёз,нощя,цыяз,цпгмщс 40,20,5,26,25,28. гълпюрт хи шдьгсхх ь нрэруе о юъг.";

        createVigenereTable(table);
        encryptedText = removeNonLetterChars(encryptedText);
        String keyString = createKeyString(encryptedText);

        System.out.println(keyString);
        System.out.println(encryptedText);

        decryptedText(encryptedText, keyString);
    }

    private static List<String> createVigenereTable(List<String> table){
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

        for (int i = 0; i < abc.length(); i++) {
            String s = abc.substring(i) + abc.substring(0, i);
            table.add(s);
        }

        return table;
    }

    private static String removeNonLetterChars(String s){
        return s.replaceAll(" ", "")
                .replaceAll("\\d", "")
                .replaceAll(",", "")
                .replaceAll(":", "")
                .replaceAll("\\.", "");
    }

    private static String createKeyString(String encryptedText){
        StringBuilder sbKey = new StringBuilder(KEY);
        while (sbKey.length() < encryptedText.length()){
            sbKey.append(KEY);
        }
        return sbKey.toString();
    }

    private static void decryptedText(String encryptedText, String keyString){
        for (int i = 0; i < encryptedText.length(); i++) {

            int j = 0;
            while (keyString.charAt(i) != table.get(j).charAt(0)){
                j++;
            }

            int index = table.get(j).indexOf(encryptedText.charAt(i));
            System.out.print(table.get(0).charAt(index));
        }
    }
}
