package by.matrosov.tasks.parkingproblem;

import java.util.*;

public class Parking {

    class Place implements Comparable<Place>{
        int l;
        int w;
        int f;

        Place(int l, int w, int f) {
            this.l = l;
            this.w = w;
            this.f = f;
        }

        int getL() {
            return l;
        }

        int getW() {
            return w;
        }

        int getF() {
            return f;
        }

        @Override
        public String toString() {
            return "Place{" +
                    "l=" + l +
                    ", w=" + w +
                    ", f=" + f +
                    '}';
        }

        @Override
        public int compareTo(Place o) {
            return Comparator.comparing(Place::getF)
                    .thenComparing(Place::getL)
                    .thenComparing(Place::getW)
                    .compare(this, o);
        }
    }

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
        //cars.removeIf(car -> car.equals(new Place(i, j, k)));
        //else error
    }

    private void park(){

        //for (Map.Entry<Place, Boolean> pair : map.entrySet()) {
        //    if (pair.getValue()) {
        //        pair.setValue(false);
        //        break;
        //    }
        //}

        map.entrySet().stream()
                .filter(Map.Entry::getValue)
                .findFirst()
                .map(entry -> entry.setValue(false));


        //map.forEach((key, value) -> {
        //    if (value) {
        //        map.replace(key, true, false);
        //    }
        //});
    }

    public static void main(String[] args) {
        Parking parking = new Parking();

        parking.park();
        parking.park();
        parking.park();
        parking.park();

        parking.map.forEach((place, aBoolean) -> System.out.println(place + "::" + aBoolean));

        //System.out.println(parking.parking.length); 200
        //System.out.println(parking.parking[0].length); 100
        //System.out.println(parking.parking[0][0].length); 5
    }
}