package by.matrosov.tasks.chess.figures;

import by.matrosov.tasks.chess.board.Board;
import by.matrosov.tasks.chess.board.Cell;

public abstract class Figure {

    Color color;

    public void move(Cell from, Cell to, Board board){
        if (isValidMove(from, to, board)){
            Figure figure = board.getBoard().get(from);

            board.getBoard().replace(to, figure);
            board.getBoard().replace(from, null);
        }else {
            System.out.println("can't move");
        }
    }

    abstract boolean isValidMove(Cell from, Cell to, Board board);
}