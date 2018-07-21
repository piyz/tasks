package by.matrosov.tasks.chess.figures;

import by.matrosov.tasks.chess.board.Board;
import by.matrosov.tasks.chess.board.Cell;

public abstract class Figure {
    Color color;
    public abstract void move(Cell from, Cell to, Board board);
    abstract boolean isValidMove(Cell from, Cell to, Board board);
}