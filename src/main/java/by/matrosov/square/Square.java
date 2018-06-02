package by.matrosov.square;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Square {
    public static void main(String[] args) {
        List<Point> pointList = new ArrayList<>();

        initPoints(pointList);

        findQuadruplets(pointList);
    }

    private static boolean isSquare(List<Point> pointList){
        Set<Double> distSet = new HashSet<>();
        for (int i = 0; i < pointList.size(); i++) {
            double x1 = pointList.get(i).getX();
            double y1 = pointList.get(i).getY();

            for (int j = 0; j < pointList.size(); j++) {
                if (i != j){
                    double x2 = pointList.get(j).getX();
                    double y2 = pointList.get(j).getY();

                    double dist = Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
                    distSet.add(dist);
                }
            }
        }

        return distSet.size() == 2;
    }

    private static void initPoints(List<Point> pointList){
        Point point1 = new Point(2.5, 0);
        Point point2 = new Point(-2.5, 0);
        Point point3 = new Point(5, 0);
        Point point4 = new Point(-5, 0);
        Point point5 = new Point(10, 20);
        Point point6 = new Point(20, 20);
        Point point7 = new Point(10, 10);
        Point point8 = new Point(20, 10);
        Point point9 = new Point(-10, -10);
        Point point10 = new Point(-20, -20);

        pointList.add(point1);
        pointList.add(point2);
        pointList.add(point3);
        pointList.add(point4);
        pointList.add(point5);
        pointList.add(point6);
        pointList.add(point7);
        pointList.add(point8);
        pointList.add(point9);
        pointList.add(point10);
    }

    private static void findQuadruplets(List<Point> pointList){
        for (int i = 0; i < pointList.size() - 4; i++) {
            for (int j = i + 1; j < pointList.size() - 3; j++) {
                for (int k = j + 1; k < pointList.size() - 2; k++) {
                    for (int l = k + 1; l < pointList.size() - 1; l++) {
                        List<Point> tempPointList = new ArrayList<>();
                        tempPointList.add(pointList.get(i));
                        tempPointList.add(pointList.get(j));
                        tempPointList.add(pointList.get(k));
                        tempPointList.add(pointList.get(l));

                        if (isSquare(tempPointList)){
                            System.out.println(tempPointList);
                        }
                    }
                }
            }
        }
    }
}
