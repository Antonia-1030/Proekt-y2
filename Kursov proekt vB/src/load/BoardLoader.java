package load;

import game.GameBoard;
import figures.Piece;
import message.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardLoader extends JFrame implements MouseListener{
    GameBoard gameBoardLogic;

    public BoardLoader(GameBoard gameBoardLogic) {
        this.gameBoardLogic = gameBoardLogic;

        this.setSize(700, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Great Cheese Wars");
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        this.addMouseListener(this);

        this.setVisible(true);
    }

    public void paint(Graphics g) {

        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 6; col++) {
                this.gameBoardLogic.renderGamePiece(g, row, col);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = this.gameBoardLogic.getBoardDimention(e.getY());
        int col = this.gameBoardLogic.getBoardDimention(e.getX());

        if(this.gameBoardLogic.getSelectedPiece() != null) {
            Piece p = this.gameBoardLogic.getSelectedPiece();

            if(p.isMoveValid(row, col)) {

                this.gameBoardLogic.movePiece(row, col, p);
                this.repaint();
                return;
            }
            else {
                Message.render(this, "Error", "Invalid move");
                return;
            }
        }
        if(this.gameBoardLogic.hasBoardPiece(row, col)) {
            this.gameBoardLogic.setSelectedPiece(this.gameBoardLogic.getBoardPiece(row, col));
        }
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
