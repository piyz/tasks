package by.matrosov.tasks.chess;

import by.matrosov.tasks.chess.board.Board;
import by.matrosov.tasks.chess.board.Cell;
import by.matrosov.tasks.chess.figures.Figure;
import by.matrosov.tasks.chess.figures.Soldier;

public class ChessGame {
    public static void main(String[] args) {
        Board board = new Board();

        //board.printBoard();

        //move like this
        Figure figure = board.getBoard().get(new Cell(1, 0));

        figure.move(new Cell(1, 0), new Cell(2, 0), board);

        board.printBoard();

    }
}
