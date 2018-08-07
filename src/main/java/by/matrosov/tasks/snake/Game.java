package by.matrosov.tasks.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game extends JPanel implements ActionListener {

    private final int SIZE = 320; //window
    private final int ONE_CELL_SIZE = 16;
    private final int GRID_CELLS = 400;//  (320/16)^2

    private int appleX;
    private int appleY;
    private int[] x = new int[GRID_CELLS];
    private int[] y = new int[GRID_CELLS];
    private int currentCellSize; //snake size

    private boolean left;
    private boolean right = true;
    private boolean up;
    private boolean down;

    private boolean inGame = true;
    private Timer timer;

    private Image cell;
    private Image apple;

    public Game() {
        setBackground(Color.GRAY);
        initImage();
        initGame();
    }

    private void initGame(){
        currentCellSize = 3;
        for (int i = 0; i < currentCellSize; i++) {
            x[i] = 160 - i * ONE_CELL_SIZE;
            y[i] = 160;
        }

        timer = new Timer(250, this);
        timer.start();

        createApple();
    }

    private void createApple(){
        appleX = new Random().nextInt(20) * ONE_CELL_SIZE;
        appleY = new Random().nextInt(20) * ONE_CELL_SIZE;
    }

    private void initImage(){
        ImageIcon icon1 = new ImageIcon("apple.png");
        apple = icon1.getImage();

        ImageIcon icon2 = new ImageIcon("cell.png");
        cell = icon2.getImage();
    }

    private void move(){
        for (int i = currentCellSize; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        if (left){
            x[0] = x[0] - ONE_CELL_SIZE;
        }else if (right){
            x[0] = x[0] + ONE_CELL_SIZE;
        }else if (up){
            y[0] = y[0] - ONE_CELL_SIZE;
        }else if (down){
            y[0] = y[0] + ONE_CELL_SIZE;
        }
    }

    private void checkApple(){
        if (x[0] == appleX && y[0] == appleY){
            currentCellSize++;
            createApple();
        }
    }

    private void checkBoard() {
        for (int i = currentCellSize; i > 0; i--) {
            if (i > 4 && x[i] == x[0] && y[i] == y[0]){
                inGame = false;
            }
        }

        if (x[0] > SIZE || x[0] < 0 || y[0] > SIZE || y[0] < 0){
            inGame = false;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (inGame){
            g.drawImage(apple, appleX, appleY,this);
            for (int i = 0; i < currentCellSize; i++) {
                g.drawImage(cell, x[i], y[i], this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame){
            checkApple();
            checkBoard();
            move();
        }
        repaint();
    }
}