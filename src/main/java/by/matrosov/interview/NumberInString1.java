package by.matrosov.interview;

public class NumberInString1 {
    public static void main(String[] args) {
        String s = "010203";

        for (int i = 1; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            int firstNumber = Integer.parseInt(s.substring(0, i));
            sb.append(firstNumber);

            while (sb.length() < s.length()){
                sb.append(++firstNumber);
            }
            //System.out.println(sb.toString());
            if (sb.toString().equals(s)){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
