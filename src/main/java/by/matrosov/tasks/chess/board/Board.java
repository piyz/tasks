package by.matrosov.tasks.chess.board;

import by.matrosov.tasks.chess.figures.*;

import java.util.TreeMap;

public class Board {

    private TreeMap<Cell, Figure> board;

    public Board() {
        board = new TreeMap<>();
        initCells();
        initFigures();
    }

    public TreeMap<Cell, Figure> getBoard() {
        return board;
    }

    private void initCells(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board.put(new Cell(i, j), null);
            }
        }
    }

    private void initFigures(){
        initPawn();
        initBishap();
        initHorse();
        //initElephant();
        //initKing();
        //initQueen();
    }

    private void initPawn(){
        for (int i = 0; i < 8; i++) {
            board.put(new Cell(1, i), new Soldier(Color.BLACK));
            board.put(new Cell(6, i), new Soldier(Color.WHITE));
        }
    }

    private void initBishap(){
        board.put(new Cell(0,0), new Bishap(Color.BLACK));
        board.put(new Cell(0,7), new Bishap(Color.BLACK));
        board.put(new Cell(7,0), new Bishap(Color.WHITE));
        board.put(new Cell(7,7), new Bishap(Color.WHITE));
    }

    private void initHorse(){
        board.put(new Cell(0,1), new Horse(Color.BLACK));
        board.put(new Cell(0,6), new Horse(Color.BLACK));
        board.put(new Cell(7,1), new Horse(Color.WHITE));
        board.put(new Cell(7,6), new Horse(Color.WHITE));
    }



    /*
    private void initElephant(){
        board.put(new Cell(0,2), new Figure(Type.ELEP, Color.BLACK));
        board.put(new Cell(0,5), new Figure(Type.ELEP, Color.BLACK));
        board.put(new Cell(7,2), new Figure(Type.ELEP, Color.WHITE));
        board.put(new Cell(7,5), new Figure(Type.ELEP, Color.WHITE));
    }

    private void initKing(){
        board.put(new Cell(0,3), new Figure(Type.KING, Color.BLACK));
        board.put(new Cell(7,3), new Figure(Type.KING, Color.WHITE));
    }

    private void initQueen(){
        board.put(new Cell(0,4), new Figure(Type.QWEE, Color.BLACK));
        board.put(new Cell(7,4), new Figure(Type.QWEE, Color.WHITE));
    }
     */

    public void printBoard(){
        board.forEach((cell, figure) -> {
            System.out.print(cell.getX() + "," + cell.getY() + "::" + figure + "     ");
            if (cell.getY() == 7)
                System.out.println();
        });
    }
}