package by.matrosov.tasks.chess.board;

import java.util.Comparator;

public final class Cell implements Comparable<Cell>{
    private int x;
    private int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Cell o) {
        return Comparator.comparing(Cell::getX)
                .thenComparing(Cell::getY)
                .compare(this, o);
    }
}
