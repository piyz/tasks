package by.matrosov.tasks.miner;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {

    private final int COLUMNS = 10;
    private final int ROWS = 10;
    private final int CELL = 50; //1 cell in pxl

    public Game() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                g.drawImage(getImage("closed"),j * CELL,i * CELL, this);
            }
        }
    }

    private Image getImage(String name){
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/" + name + ".png"));
        return icon.getImage();
    }
}