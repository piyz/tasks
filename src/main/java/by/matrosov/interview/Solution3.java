package by.matrosov.interview;

public class Solution3 {
    public static void main(String[] args) {
        //abcd * 4 = dcba;
        //4000a + 400b + 40c + 4d = 1000d + 100c + 10b + a
        //3999a + 390b - 60c - 996d = 0
        //1333a + 130b - 20c - 332d = 0
        //1333a + 2(65b - 10c -166d) = 0

        double d;
        for (double a = 0; a < 10; a++) {
            for (double b = 0; b < 10; b++) {
                for (double c = 0; c < 10; c++) {
                    d = 1333*a/332 + 65*b/166 - 5*c/83;
                    if (d > -1 && d < 10){
                        if (d - (long)d == 0){
                            System.out.println(" a=" + a +" b=" + b + " c=" + c + "::" + d);
                        }
                    }
                }
            }
        }
    }
}
