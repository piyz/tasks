package by.matrosov.tasks.snake;

import javax.swing.*;

public class Window extends JFrame {

    public Window() {
        setTitle("Snake");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(320,345);
        setVisible(true);
        setLocation(500, 300);
        add(new Game());
        setResizable(false);
    }

    public static void main(String[] args) {
        Window window = new Window();
    }
}
