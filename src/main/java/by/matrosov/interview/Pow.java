package by.matrosov.interview;

/**
 * Write a program to calculate pow(x,n)
 */
public class Pow {

    //Input : x = 2, n = 3
    //Output : 8
    //
    //Input : x = 7, n = 2
    //Output : 49
    public static void main(String[] args) {
        System.out.println(pow(5,-4));
    }

    private static float pow(float base, int exp){
        if (exp == 0){
            return 1;
        }else if (exp % 2 == 0){
            return pow(base, exp/2) * pow(base, exp/2);
        }else {
            if (exp > 0){
                return base * pow(base, exp/2) * pow(base, exp/2);
            }else {
                return 1 / (base * pow(base, exp/2) * pow(base, exp/2));
            }
        }
    }
}
