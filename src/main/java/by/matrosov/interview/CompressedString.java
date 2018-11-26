package by.matrosov.interview;

public class CompressedString {
    public static void main(String[] args) {
        String s = "aaabbacdddd";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            sb.append(s.charAt(i));

            int count = 1;
            while (s.charAt(i) == s.charAt(i + 1)){
                count++;
                i++;

                if (i + 1 > s.length() - 1)
                    break;
            }

            sb.append(count);
        }

        System.out.println(sb.toString());
    }
}