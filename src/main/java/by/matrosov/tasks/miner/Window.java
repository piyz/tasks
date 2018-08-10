package by.matrosov.tasks.miner;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private Window() throws HeadlessException {
        setSize(506,525); //500x500 (+25 pix upper line, +6 right)
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new Game());
        setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
    }

    public static void main(String[] args) {
        Window window = new Window();
    }
}