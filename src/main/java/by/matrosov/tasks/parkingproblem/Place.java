package by.matrosov.tasks.parkingproblem;

import java.util.Comparator;

public class Place implements Comparable<Place> {
    private int l;
    private int w;
    private int f;

    Place(int l, int w, int f) {
        this.l = l;
        this.w = w;
        this.f = f;
    }

    private int getL() {
        return l;
    }

    private int getW() {
        return w;
    }

    private int getF() {
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