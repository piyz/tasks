package by.matrosov.tasks.chess.figures;

import by.matrosov.tasks.chess.board.Board;
import by.matrosov.tasks.chess.board.Cell;

import java.util.HashSet;
import java.util.Set;

public class Soldier extends Figure{

    public Soldier(Color color) {
        this.color = color;
    }

    @Override
    public void move(Cell from, Cell to, Board board) {
        if (isValidMove(from, to, board)){
            Figure figure = board.getBoard().get(from);

            board.getBoard().replace(to, figure);
            board.getBoard().replace(from, null); //from to null
        }else {
            System.out.println("can't move");
        }
    }

    @Override
    public boolean isValidMove(Cell from, Cell to, Board board) {
        if (to.getY() > -1 && to.getY() < 8 && to.getX() > -1 && to.getX() < 8){
            Set<Cell> moves = new HashSet<>();

            if (this.color == Color.WHITE){
                moves.add(new Cell(from.getX() - 1, from.getY()));
                moves.add(new Cell(from.getX() - 1, from.getY() - 1));
                moves.add(new Cell(from.getX() - 1, from.getY() + 1));
            }else {
                moves.add(new Cell(from.getX() + 1, from.getY()));
                moves.add(new Cell(from.getX() + 1, from.getY() - 1));
                moves.add(new Cell(from.getX() + 1, from.getY() + 1));
            }

            if (moves.contains(to)){ //equals?
                Figure figure = board.getBoard().get(to);

                return figure == null || figure.color != this.color;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "Soldier::" + color;
    }
}