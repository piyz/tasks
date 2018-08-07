package by.matrosov.algorithms;

import java.util.Random;

public class PrimeNumbers {
    public static void main(String[] args) {

        System.out.println(isPrime(15));
    }

    private static boolean isPrime(int n){
        if (n % 2 == 0){
            return false;
        }

        int a = getRandomNumber(n); //from [2, n-1]

        if (pow(a,n - 1) % n == 1){
            for (int i = 2; i < n; i++) {
                if (n % i == 0){
                    if (isPrime(i)){
                        if (pow(a, (n-1)/i) % n == 1){
                            return false;
                        }
                    }
                }
            }
        }else {
            return false;
        }

        return true;
    }

    private static int getRandomNumber(int n){
        Random random = new Random();

        return random.ints(2, n).findFirst().getAsInt();
    }

    private static int pow(int a, int b){
        if (b == 0){
            return 1;
        }

        if (b == 1){
            return a;
        }

        return a * pow(a, b - 1);
    }
}