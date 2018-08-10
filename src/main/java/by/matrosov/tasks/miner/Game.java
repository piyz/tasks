package by.matrosov.tasks.miner;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {

    private final int COLUMNS = 10;
    private final int ROWS = 10;
    private final int CELL = 50; //1 cell in pxl

    private Matrix bompMap;

    public Game() {
        Ranges.setSize(new Coordinate(COLUMNS, ROWS));
        //start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Coordinate coordinate : Ranges.getAllCoordinate()) {
            g.drawImage(getImage("flaged"), coordinate.x * CELL, coordinate.y * CELL, this);
        }
    }

    private Image getImage(String name){
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/" + name + ".png"));
        return icon.getImage();
    }

    private void start(){
        bompMap = new Matrix(Type.BOMB);
    }
}