package by.matrosov.tasks.parkingproblem;

import java.util.*;

public class Parking {

    private static final int length = 15; //2
    private static final int width = 10; //3
    private static final int floor = 5; //1

    private TreeMap<Place, Boolean> map;

    private Parking() {
        this.map = new TreeMap<>();
        for (int i = 1; i <= floor; i++) {
            for (int j = 1; j <= length; j++) {
                for (int k = 1; k <= width; k++) {
                    map.put(new Place(i, j, k), true);
                }
            }
        }
    }

    private void unpark(int i, int j, int k){
        map.replace(new Place(i, j, k), false, true);
    }

    private void park(){
        map.entrySet().stream()
                .filter(Map.Entry::getValue)
                .findFirst()
                .map(entry -> entry.setValue(false));
    }

    public static void main(String[] args) {
        Parking parking = new Parking();

        parking.park();
        parking.park();
        parking.park();
        parking.park();
        parking.unpark(1,1,1);
        parking.unpark(1,4,1);
        parking.park();

        parking.map.forEach((place, aBoolean) -> System.out.println(place + "::" + aBoolean));

        //Place{l=1, w=1, f=1}::false
        //Place{l=1, w=2, f=1}::false
        //Place{l=1, w=3, f=1}::false
        //Place{l=1, w=4, f=1}::false
        //Place{l=1, w=5, f=1}::true
        //Place{l=1, w=6, f=1}::true
    }
}