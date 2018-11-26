package by.matrosov.algorithms;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 0; i <= n; i++) {
            System.out.println(i + "::" + fibonacci(i));
        }
    }

    private static int fibonacci(int n){
        if (n <= 1){
            return 1;
        }else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}