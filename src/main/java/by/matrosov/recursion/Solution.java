package by.matrosov.recursion;

public class Solution {
    public static void main(String[] args) {

        Bottle bottle1 = new Bottle(7, 0);
        Bottle bottle2 = new Bottle(10, 0);

        fromBottle1toBottle2(bottle1, bottle2);
    }

    private static void fromBottle1toBottle2(Bottle bottle1, Bottle bottle2){
        if (bottle1.getCurCapacity() == 0){
            bottle1.setCurCapacity(bottle1.getMaxCapacity());
        }

        bottle2.setCurCapacity(bottle2.getCurCapacity() + bottle1.getCurCapacity());
        bottle1.setCurCapacity(0);

        if (bottle2.getCurCapacity() > bottle2.getMaxCapacity()){
            bottle1.setCurCapacity(bottle2.getCurCapacity() - bottle2.getMaxCapacity()); //set diff
            bottle2.setCurCapacity(bottle2.getMaxCapacity()); //set max
            System.out.println(bottle1.getCurCapacity() + ", " + bottle2.getCurCapacity());
            //check1
            if (capasityOneIsExist(bottle1, bottle2)) return;

            bottle2.setCurCapacity(0);
            fromBottle1toBottle2(bottle1, bottle2);
        }

        //check?
        if (capasityOneIsExist(bottle1, bottle2)) return;
        System.out.println(bottle1.getCurCapacity() + ", " + bottle2.getCurCapacity());
        fromBottle1toBottle2(bottle1, bottle2);
    }


    private static boolean capasityOneIsExist(Bottle bottle1, Bottle bottle2){
        return bottle1.getCurCapacity() == 1 || bottle2.getCurCapacity() == 1;
    }
}
