package by.matrosov.tasks.miner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JPanel {

    private final int COLUMNS = 10;
    private final int ROWS = 10;
    private final int CELL_SIZE = 50; //1 cell in pxl

    private Cell [][] gameField;

    Game() {
        initGameField();
        addMouseListener(new MouseListener());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[0].length; j++) {
                g.drawImage(getImageFromGameField(i,j,gameField), i*CELL_SIZE,j*CELL_SIZE, this);
            }
        }
    }

    private Image getImageByName(String name){
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/" + name + ".png"));
        return icon.getImage();
    }

    private Image getImageFromGameField(int i, int j, Cell[][] gameField){
        Type type = gameField[i][j].getType();
        return getImageByName(type.name().toLowerCase());
    }

    private void initGameField(){
        gameField = new Cell[COLUMNS][ROWS];
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[0].length; j++) {
                gameField[i][j] = new Cell(Type.CLOSED);
            }
        }
    }

    class MouseListener extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX() / CELL_SIZE;
            int y = e.getY() / CELL_SIZE;
            if (e.getButton() == MouseEvent.BUTTON1){
                gameField[x][y] = new Cell(Type.BOMB);
            }
            repaint();
        }
    }
}