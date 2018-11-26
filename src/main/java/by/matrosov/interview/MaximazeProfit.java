package by.matrosov.interview;

import java.util.ArrayList;

public class MaximazeProfit {

    public static class Interval{
        int buy;
        int sell;
    }

    private static void buySell(int price[], int n){
        if (n == 1){
            return;
        }

        int count = 0;
        ArrayList<Interval> solution = new ArrayList<>();

        int i = 0;
        while (i < n - 1){
            while (i < n - 1 && price[i + 1] <= price[i]){
                i++;
            }

            if (i == n - 1){
                break;
            }

            Interval interval = new Interval();
            interval.buy = i++;

            while (i < n && price[i] >= price[i - 1]){
                i++;
            }

            interval.sell = i - 1;

            solution.add(interval);
            count++;
        }

        if (count == 0){
            System.out.println("NO");
        }else {
            for (int j = 0; j < count; j++) {
                System.out.println("buy on day " + solution.get(j).buy + " sell on day " + solution.get(j).sell);
            }
        }
    }

    public static void main(String[] args) {
        int price[] = {100, 180, 260, 310, 40, 535, 695};

        buySell(price, price.length);
    }
}
