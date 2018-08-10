package by.matrosov.tasks.miner;


import java.util.ArrayList;
import java.util.List;

public class Ranges {
    private static Coordinate size;
    private static List<Coordinate> allCoordinate;

    public static Coordinate getSize() {
        return size;
    }

    public static void setSize(Coordinate size) {
        Ranges.size = size;

        //init allCoordinate
        allCoordinate = new ArrayList<>();
        for (int i = 0; i < size.y; i++) {
            for (int j = 0; j < size.x; j++) {
                allCoordinate.add(new Coordinate(j,i));
            }
        }
    }

    public static List<Coordinate> getAllCoordinate() {
        return allCoordinate;
    }
}