package by.matrosov.tasks.task2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final String INPUT = "123";

    private static int calculateSizeOfArr(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < INPUT.length(); i++) {
            sb.append(INPUT.charAt(i)).append(" ");
        }
        String s = sb.toString().trim();
        int count = 0; //arr size
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                count++;
            }
        }
        return count;
    }

    private static void addAllArraysToList(List<String> list){
        char abc[] = new char[]{'t', 'f'};
        int size = calculateSizeOfArr();
        int arr[] = new int[size];
        outer: while(true){

            StringBuilder strb = new StringBuilder();
            for(int ndx : arr){
                strb.append(abc[ndx]);
            }
            list.add(strb.toString());

            int i = size - 1;
            while(arr[i] == abc.length - 1){
                arr[i] = 0;
                i--;
                if(i < 0)break outer;
            }
            arr[i]++;
        }
    }

    private static void decode(String s, List<String> list){
        String abc = "abcdefghijklmnopqrstuvwxyz";
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String a : arr) {
            try {
                sb.append(abc.charAt(Integer.parseInt(a) - 1));
            }catch (Exception ignored){}
        }
        if (!sb.toString().isEmpty()){
            list.add(sb.toString());
        }

    }

    private static void decodeToList(List<String> list, List<String> result){
        for (String a : list) {
            StringBuilder output = new StringBuilder();
            for (int j = 0; j < INPUT.length(); j++) {
                output.append(INPUT.charAt(j)).append(" ");
            }
            String str = output.toString().trim();

            for (int j = 0; j < a.length(); j++) {
                str = str.replaceFirst(" ", String.valueOf(a.charAt(j)));
            }

            str = str.replaceAll("t", "").replaceAll("f", " ");
            //System.out.println(str);
            decode(str, result);
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> result = new ArrayList<>();
        addAllArraysToList(list);
        decodeToList(list, result);
        System.out.println(result.size());
    }
}
