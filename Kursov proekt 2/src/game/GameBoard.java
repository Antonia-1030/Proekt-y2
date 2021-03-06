package game;

import message.Message;
import figures.*;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JFrame{
    public static final int WIDTH = 9;
    public static final int HEIGHT = 7;
    public static boolean isGameOver=false;
    public int score=0;

    public GameBoard(){
        this.setSize(600, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Great Cheese Wars of Switzerland");

        setVisible(true);
    }

    public void paint(Graphics g) {
        //visualize board
        super.paint(g);
        for (int row = 0; row < WIDTH; row++) {
            for (int col = 0; col < HEIGHT; col++) {
                GameTile tile = new GameTile(row,col);
                tile.render(g);
            }
        }

    }
}
