package by.matrosov.interview;


public class Solution2 {
    public static void main(String[] args) {

        String pattern = "1001";
        String s = "100100100100100100111111001011101100001111001";
        //String s = "1001";

        //System.out.println(s.substring(0,4)); //1001
        //System.out.println(s.substring(3,7)); //1001
        //System.out.println(s.substring(41, 45));
        //System.out.println(s.substring(4, 8));


        if (s.equals(pattern)){
            System.out.println("1");
        }else {
            int j = 0;
            int count = 0;
            while (j < 4){
                for (int i = j; i < s.length() - 4 - j; i = i + 4) {
                    if (s.substring(i, i + 4).equals(pattern)){
                        count++;
                    }
                }
                j++;
            }
            System.out.println(count);
        }
    }
}
