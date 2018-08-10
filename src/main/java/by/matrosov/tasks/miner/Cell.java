package by.matrosov.tasks.miner;

import by.matrosov.tasks.miner.types.Inner;
import by.matrosov.tasks.miner.types.Outer;

public class Cell {
    private Inner inner;
    private Outer outer;

    public Cell(Inner inner, Outer outer) {
        this.inner = inner;
        this.outer = outer;
    }

    Inner getInner() {
        return inner;
    }

    Outer getOuter() {
        return outer;
    }

    void setInner(Inner inner) {
        this.inner = inner;
    }

    void setOuter(Outer outer) {
        this.outer = outer;
    }
}