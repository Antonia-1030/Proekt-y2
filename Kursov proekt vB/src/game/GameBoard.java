package game;

import figures.*;
import message.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JFrame implements ActionListener{
    public static final int WIDTH = 9;
    public static final int HEIGHT = 7;
    private Piece[][] pieceCollection;
    private Piece selectedPiece;

    public static boolean isGameOver=false;
    public int playerScore=0;
    public int enemyScore=0;
    public int movesCount=0;
    public boolean isPlayerBlue=true;

    FontMetrics size;
    JButton restartButton;

    public GameBoard(){
        do{
            if (isPlayerBlue){
                movesCount++;
            }
            isPlayerBlue = !isPlayerBlue;
        } while (!isGameOver);

        restartButton=new JButton();
        restartButton.setText("Restart");
        restartButton.setSize(100,50);
        restartButton.setLocation(120,80);
        restartButton.addActionListener(this);

        this.add(restartButton);
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

    public void gameOver(Graphics g){
        size = getFontMetrics(g.getFont());
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Serif Plain",Font.ITALIC,20));
        g.drawString("Score: "+playerScore+"/1200", 100,10);
        g.drawString("Enemy score: "+enemyScore+"/1200", 100,50);
        g.drawString("Moves: "+movesCount, 100,100);

        if (isGameOver && playerScore==1200){
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Serif Italic",Font.BOLD,90));
            g.drawString("You win! Congrats!",120,HEIGHT/2);
        }
        if (isGameOver && enemyScore==1200){
            g.setColor(Color.RED);
            g.setFont(new Font("Serif Plain",Font.BOLD,90));
            g.drawString("Enemy wins!",120,HEIGHT/2);
        }
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
        if (!isGameOver){
            for (int row = 0; row < WIDTH; row++) {
                for (int col = 0; col < HEIGHT; col++) {
                GameTile tile = new GameTile(row,col);
                tile.render(g);
                }
            }

        }
        else {
            gameOver(g);
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
    public void actionPerformed(ActionEvent e) {

    }
}
