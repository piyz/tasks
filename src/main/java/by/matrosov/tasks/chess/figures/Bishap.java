package by.matrosov.tasks.chess.figures;

import by.matrosov.tasks.chess.board.Board;
import by.matrosov.tasks.chess.board.Cell;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Bishap extends Figure {

    public Bishap(Color color) {
        this.color = color;
    }

    @Override
    boolean isValidMove(Cell from, Cell to, Board board) {
        if (to.getY() > -1 && to.getY() < 8 && to.getX() > -1 && to.getX() < 8){
            Set<Cell> moves = new HashSet<>();

            int i = 1;
            while (from.getX() + i < 8) {
                if (board.getBoard().get(new Cell(from.getX() + i, from.getY())) == null) {
                    moves.add(new Cell(from.getX() + i, from.getY()));
                    i++;
                } else if (board.getBoard().get(new Cell(from.getX() + i, from.getY())).color != this.color) {
                    moves.add(new Cell(from.getX() + i, from.getY()));
                    break;
                } else {
                    break;
                }

            }
            i = 1;
            while (from.getX() - i > - 1){
                if (board.getBoard().get(new Cell(from.getX() - i, from.getY())) == null){
                    moves.add(new Cell(from.getX() - i, from.getY()));
                    i++;
                }else if (board.getBoard().get(new Cell(from.getX() - i, from.getY())).color != this.color){
                    moves.add(new Cell(from.getX() + i, from.getY()));
                    break;
                }else {
                    break;
                }

            }
            int j = 1;
            while (from.getY() + j < 8){
                if (board.getBoard().get(new Cell(from.getX(), from.getY() + j)) == null){
                    moves.add(new Cell(from.getX(), from.getY() + j));
                    j++;
                }else if (board.getBoard().get(new Cell(from.getX(), from.getY() + j)).color != this.color){
                    moves.add(new Cell(from.getX(), from.getY() + j));
                    break;
                }else {
                    break;
                }

            }
            j = 1;
            while (from.getY() - j > - 1){
                if (board.getBoard().get(new Cell(from.getX(), from.getY() - j)) == null){
                    moves.add(new Cell(from.getX(), from.getY() - j));
                    j++;
                }else if (board.getBoard().get(new Cell(from.getX(), from.getY() - j)).color != this.color){
                    moves.add(new Cell(from.getX(), from.getY() - j));
                    break;
                }else {
                    break;
                }
            }

            Optional<Cell> found = moves.stream()
                    .filter(cell -> cell.getX() == to.getX() && cell.getY() == to.getY()).findFirst();
            if (found.isPresent()){
                Figure figure = board.getBoard().get(to);

                return figure == null || figure.color != this.color;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "Bishap::" + color;
    }
}
