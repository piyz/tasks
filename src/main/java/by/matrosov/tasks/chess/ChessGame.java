package by.matrosov.tasks.chess;

import by.matrosov.tasks.chess.board.Board;
import by.matrosov.tasks.chess.board.Cell;
import by.matrosov.tasks.chess.figures.Figure;

public class ChessGame {

    private static Board board = new Board();

    public static void main(String[] args) {

        //step(new Cell(6, 0), new Cell(5, 0));
        //step(new Cell(6, 1), new Cell(5, 2));

        board.printBoard();
    }

    private static void step(Cell from, Cell to){
        Figure figure = board.getBoard().get(from);
        figure.move(from, to, board);
    }
}