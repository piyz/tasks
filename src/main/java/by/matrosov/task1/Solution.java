package by.matrosov.task1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Solution {

    private static final String INPUT = "D://input.txt";
    private static final String OUTPUT = "D://result.txt";

    private static int safeAdd(int left, int right){
        if (right > 0 ? left > Integer.MAX_VALUE - right : left < Integer.MIN_VALUE - right) {
            throw new ArithmeticException("Integer overflow");
        }
        return left + right;
    }

    private static String[] readFromFileToArray(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null){
            String[] lineArr = line.split(";");
            boolean flag = false;
            try{
                Integer.parseInt(lineArr[0]);
                Integer.parseInt(lineArr[1]);
            }catch (NumberFormatException e){
                flag = true;
            }
            if (line.trim().length() != 0 && !flag && lineArr.length == 3){
                sb.append(line).append(" ");
            }
        }
        reader.close();
        return sb.toString().split(" ");
    }

    private static void writeToFileFromArray(String[] array, String path) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        for (int i = 0; i < array.length; i++) {
            String[] line = array[i].split(";"); //current line
            String country = line[2];

            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (array[j].contains(country)){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                //write to output
                int sumCount = Integer.parseInt(line[1]);
                for (int j = i + 1; j < array.length; j++) {
                    String[] s = array[j].split(";");
                    if (s[2].equals(country)){
                        try{
                            sumCount = safeAdd(sumCount, Integer.parseInt(s[1])); //overflow
                        }catch (ArithmeticException ignore){}
                    }
                }

                StringBuilder sb = new StringBuilder();
                int sumUniqId = 0; //line[0]
                for (int j = i; j < array.length; j++) {
                    String[] s = array[j].split(";");
                    if (s[2].equals(country)){
                        sb.append(s[0].trim()).append(";");
                    }
                }
                String s = sb.toString();
                String[] sArray = s.split(";");
                for (int j = 0; j < sArray.length; j++) {
                    int count = 0;
                    for (int k = j + 1; k < sArray.length; k++) {
                        if (sArray[j].equals(sArray[k])){
                            count++;
                        }
                    }
                    if (count == 0){
                        try{
                            sumUniqId = safeAdd(sumUniqId, 1); //overflow
                        }catch (ArithmeticException ignore){}
                    }
                }
                writer.write(country + ";" + sumCount + ";" + sumUniqId);
                writer.newLine();
            }
        }
        writer.close();
    }

    private static String[] readUnsortedDataToArray(String path) throws IOException {
        String unsorted = String.valueOf(Files.readAllLines(Paths.get(path)));
        return unsorted
                .replaceAll("\\[", "")
                .replaceAll("]", "")
                .split(",");
    }

    private static String[] sort(String[] arr){
        Arrays.sort(arr, (o1, o2) -> {
            int ADIN = Integer.parseInt(o1.split(";")[1]);
            int DVA = Integer.parseInt(o2.split(";")[1]);
            if (ADIN < DVA) {
                return 1;
            } else if (ADIN == DVA) {
                int one = Integer.parseInt(o1.split(";")[2].trim());
                int two = Integer.parseInt(o2.split(";")[2].trim());
                return Integer.compare(two, one);
            } else {
                return -1;
            }
        });
        return arr;
    }

    private static void writeSortedArrayToFile(String[] arr, String path) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        for (String a : arr) {
            writer.write(a.trim());
            writer.newLine();
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        writeToFileFromArray(readFromFileToArray(INPUT), OUTPUT);
        writeSortedArrayToFile(sort(readUnsortedDataToArray(OUTPUT)), OUTPUT);
    }
}
