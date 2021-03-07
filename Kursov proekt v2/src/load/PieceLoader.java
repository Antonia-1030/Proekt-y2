package load;

import game.GameBoard;
import figures.*;

import java.awt.*;

public class PieceLoader {
    public Piece[][] load() {
        Piece[][] pieceCollection = new Piece[GameBoard.WIDTH][GameBoard.HEIGHT];

        //Blue
        pieceCollection[0][0] = (new Knight(0, 0, Color.BLUE));
        pieceCollection[0][1] = (new Knight(0, 1, Color.BLUE));
        pieceCollection[0][2] = (new Dwarf(0, 2, Color.BLUE));
        pieceCollection[0][3] = (new Dwarf(0, 3, Color.BLUE));
        pieceCollection[0][4] = (new Elf(0, 4, Color.BLUE));
        pieceCollection[0][5] = (new Elf(0, 5, Color.BLUE));

        //Red
        pieceCollection[0][0] = (new Knight(0, 0, Color.RED));
        pieceCollection[0][1] = (new Knight(0, 1, Color.RED));
        pieceCollection[0][2] = (new Dwarf(0, 2, Color.RED));
        pieceCollection[0][3] = (new Dwarf(0, 3, Color.RED));
        pieceCollection[0][4] = (new Elf(0, 4, Color.RED));
        pieceCollection[0][5] = (new Elf(0, 5, Color.RED));

        return pieceCollection;
    }
}