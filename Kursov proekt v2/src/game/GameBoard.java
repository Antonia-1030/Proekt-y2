package game;

import figures.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameBoard extends JFrame implements MouseListener {
    public static final int WIDTH = 9;
    public static final int HEIGHT = 7;
    private Piece[][] pieceCollection;
    private Piece selectedPiece;

    public static boolean isGameOver=false;
    public int score=0;
    public boolean isPlayerBlue=true;

    public GameBoard(){
        this.setSize(700, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Great Cheese Wars");
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        this.addMouseListener(this);
        this.pieceCollection = pieceCollection;

        this.setVisible(true);
    }

    public Piece getSelectedPiece() {
        return selectedPiece;
    }

    public void setSelectedPiece(Piece selectedPiece) {
        this.selectedPiece = selectedPiece;
    }
//move piece on board
    public void movePiece(int row, int col, Piece p) {
        int initialRow = p.getRow();
        int initialCol = p.getCol();

        p.move(row, col);

        this.pieceCollection[p.getRow()][p.getCol()] = this.selectedPiece;
        this.pieceCollection[initialRow][initialCol] = null;

        this.selectedPiece = null;
    }

    public Piece getBoardPiece(int row, int col) {
        return this.pieceCollection[row][col];
    }

    public boolean hasBoardPiece(int row, int col) {
        return this.getBoardPiece(row, col) != null;
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

    public void renderGamePiece(Graphics g, int row, int col) {

        if(this.hasBoardPiece(row, col)) {

            Piece p = this.getBoardPiece(row, col);
            p.render(g);
        }
    }

    public int getBoardDimention(int coordinates) {
        return coordinates / GameTile.TILE_SIZE;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
