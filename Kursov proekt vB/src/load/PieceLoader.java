package load;

import game.GameBoard;
import figures.*;

import java.awt.*;

public class PieceLoader {
    public Piece[][] load() {
        Piece[][] pieceCollection = new Piece[GameBoard.WIDTH][GameBoard.HEIGHT];

        //Red
        pieceCollection[0][0] = (new Knight(0, 0, Color.RED));
        pieceCollection[0][1] = (new Knight(0, 1, Color.RED));
        pieceCollection[0][2] = (new Dwarf(0, 2, Color.RED));
        pieceCollection[0][3] = (new Dwarf(0, 3, Color.RED));
        pieceCollection[0][4] = (new Elf(0, 4, Color.RED));
        pieceCollection[0][5] = (new Elf(0, 5, Color.RED));

        //Blue
        pieceCollection[6][0] = (new Knight(6, 0, Color.BLUE));
        pieceCollection[6][1] = (new Knight(6, 1, Color.BLUE));
        pieceCollection[6][2] = (new Dwarf(6, 2, Color.BLUE));
        pieceCollection[6][3] = (new Dwarf(6, 3, Color.BLUE));
        pieceCollection[6][4] = (new Elf(6, 4, Color.BLUE));
        pieceCollection[6][5] = (new Elf(6, 5, Color.BLUE));

        return pieceCollection;
    }
}