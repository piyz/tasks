package by.matrosov.tasks.miner;

import by.matrosov.tasks.miner.types.Inner;
import by.matrosov.tasks.miner.types.Outer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Game extends JPanel {

    private static final int BOMB_NUMBER = 10;
    private static final int COLUMNS = 10;
    private static final int ROWS = 10;
    private static final int CELL_SIZE = 50; //1 cell in pxl
    private Cell [][] gameField;
    private boolean inGame = true;

    Game() {
        setBackground(Color.orange);
        initGameField();
        addMouseListener(new MouseListener());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[0].length; j++) {
                g.drawImage(getImageFromGameField(i,j,gameField),i*CELL_SIZE,j*CELL_SIZE,this);
            }
        }
    }

    private Image getImageByName(String name){
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/" + name + ".png"));
        return icon.getImage();
    }

    private Image getImageFromGameField(int i, int j, Cell[][] gameField){
        //Inner innerType = gameField[i][j].getInner();
        Outer outer = gameField[i][j].getOuter();
        return getImageByName(outer.name().toLowerCase());
    }

    private void initGameField(){
        gameField = new Cell[COLUMNS][ROWS];
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[0].length; j++) {
                gameField[i][j] = new Cell(Inner.CLEAR, Outer.CLOSED);
            }
        }
        initBombs();
        initNumbers();
    }

    private void initBombs(){
        Random random = new Random();
        for (int i = 0; i < BOMB_NUMBER; i++) {
            int x = random.nextInt(COLUMNS);
            int y = random.nextInt(ROWS);
            if (gameField[x][y].getInner() != Inner.BOMB){
                gameField[x][y].setInner(Inner.BOMB);
            }else {
                i--;
            }
        }
    }

    private void initNumbers(){
        for (int j = 0; j < gameField.length; j++) {
            for (int i = 0; i < gameField[0].length; i++) {
                if (gameField[i][j].getInner() == Inner.CLEAR){
                    int count = 0;
                    if (i-1 >-1 && i-1 < ROWS && j-1>-1 && j-1<COLUMNS){
                        if (gameField[i-1][j-1].getInner() == Inner.BOMB){
                            count++;
                        }
                    }
                    if (i-1 >-1 && i-1 < ROWS){
                        if (gameField[i-1][j].getInner() == Inner.BOMB){
                            count++;
                        }
                    }
                    if (i - 1 > -1 && i - 1 < ROWS && j + 1 < COLUMNS){
                        if (gameField[i-1][j+1].getInner() == Inner.BOMB){
                            count++;
                        }
                    }
                    if (j + 1 < COLUMNS){
                        if (gameField[i][j+1].getInner() == Inner.BOMB){
                            count++;
                        }
                    }
                    if (j-1>-1 && j-1<COLUMNS){
                        if (gameField[i][j-1].getInner() == Inner.BOMB){
                            count++;
                        }
                    }
                    if (i + 1 < ROWS && j - 1 > -1 && j - 1 < COLUMNS){
                        if (gameField[i+1][j-1].getInner() == Inner.BOMB){
                            count++;
                        }
                    }
                    if (i + 1 < ROWS){
                        if (gameField[i+1][j].getInner() == Inner.BOMB){
                            count++;
                        }
                    }
                    if (i + 1 < ROWS && j + 1 < COLUMNS){
                        if (gameField[i+1][j+1].getInner() == Inner.BOMB){
                            count++;
                        }
                    }
                    setNumber(i,j,count);
                }
            }
        }
    }

    private void setNumber(int i, int j, int count){
        if (count == 0){
            gameField[i][j].setInner(Inner.CLEAR);
        }else if (count == 1){
            gameField[i][j].setInner(Inner.ONE);
        }else if (count == 2){
            gameField[i][j].setInner(Inner.TWO);
        }else if (count == 3){
            gameField[i][j].setInner(Inner.THREE);
        }else if (count == 4){
            gameField[i][j].setInner(Inner.FOUR);
        }else if (count == 5){
            gameField[i][j].setInner(Inner.FIVE);
        }else if (count == 6){
            gameField[i][j].setInner(Inner.SIX);
        }else if (count == 7){
            gameField[i][j].setInner(Inner.SEVEN);
        }else if (count == 8){
            gameField[i][j].setInner(Inner.EIGHT);
        }
    }

    class MouseListener extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX() / CELL_SIZE;
            int y = e.getY() / CELL_SIZE;
            if (e.getButton() == MouseEvent.BUTTON1){
                if (inGame){
                    if (gameField[x][y].getOuter() == Outer.CLOSED){
                        if (gameField[x][y].getInner() == Inner.CLEAR){
                            gameField[x][y].setOuter(Outer.OPENED);
                        }else if (gameField[x][y].getInner() == Inner.ONE){
                            gameField[x][y].setOuter(Outer.ONE);
                        }else if (gameField[x][y].getInner() == Inner.TWO){
                            gameField[x][y].setOuter(Outer.TWO);
                        }else if (gameField[x][y].getInner() == Inner.THREE){
                            gameField[x][y].setOuter(Outer.THREE);
                        }else if (gameField[x][y].getInner() == Inner.FOUR){
                            gameField[x][y].setOuter(Outer.FOUR);
                        }else if (gameField[x][y].getInner() == Inner.FIVE){
                            gameField[x][y].setOuter(Outer.FIVE);
                        }else if (gameField[x][y].getInner() == Inner.SIX){
                            gameField[x][y].setOuter(Outer.SIX);
                        }else if (gameField[x][y].getInner() == Inner.SEVEN){
                            gameField[x][y].setOuter(Outer.SEVEN);
                        }else if (gameField[x][y].getInner() == Inner.EIGHT){
                            gameField[x][y].setOuter(Outer.EIGHT);
                        }else if (gameField[x][y].getInner() == Inner.BOMB){
                            gameField[x][y].setOuter(Outer.BOMBED);
                            inGame = false;
                        }
                    }
                }
            }
            if (e.getButton() == MouseEvent.BUTTON3){
                if (gameField[x][y].getOuter() == Outer.CLOSED){
                    gameField[x][y].setOuter(Outer.FLAGED);
                }
            }
            repaint();
        }
    }
}