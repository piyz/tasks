package by.matrosov.tasks.chess.figures;

import by.matrosov.tasks.chess.board.Board;
import by.matrosov.tasks.chess.board.Cell;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Horse extends Figure {

    public Horse(Color color) {
        this.color = color;
    }

    @Override
    boolean isValidMove(Cell from, Cell to, Board board) {
        if (to.getY() > -1 && to.getY() < 8 && to.getX() > -1 && to.getX() < 8){
            Set<Cell> moves = new HashSet<>();

            checkSingleCell(board, new Cell(from.getX() + 1, from.getY() + 2), moves);
            checkSingleCell(board, new Cell(from.getX() + 1, from.getY() - 2), moves);
            checkSingleCell(board, new Cell(from.getX() - 1, from.getY() + 2), moves);
            checkSingleCell(board, new Cell(from.getX() - 1, from.getY() - 2), moves);

            checkSingleCell(board, new Cell(from.getX() + 2, from.getY() + 1), moves);
            checkSingleCell(board, new Cell(from.getX() + 2, from.getY() - 1), moves);
            checkSingleCell(board, new Cell(from.getX() - 2, from.getY() + 1), moves);
            checkSingleCell(board, new Cell(from.getX() - 2, from.getY() - 1), moves);

            Optional<Cell> found = moves.stream()
                    .filter(cell -> cell.getX() == to.getX() && cell.getY() == to.getY()).findFirst();
            return found.isPresent();
        }
        return false;
    }

    @Override
    public String toString() {
        return "Horse::" + color;
    }

    private void checkSingleCell(Board board, Cell newCell, Set<Cell> set){
        if (board.getBoard().get(newCell) == null){
            set.add(newCell);
        }else if (board.getBoard().get(newCell).color != this.color){
            set.add(newCell);
        }
    }
}
