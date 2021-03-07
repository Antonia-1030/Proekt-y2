package figures;

import java.awt.*;

public class Dwarf extends Piece {
    public static int HP=12;
    public static int ATTACK=6;
    public static int DEFENCE=2;
    public static int SPEED=2;
    public static int RANGE=2;
    public static boolean isDead=false;

    public Dwarf(int row, int col, Color color) {
        super(row, col, color, "D");
    }

    @Override
    public boolean isMoveValid(int moveRow, int moveCol) {
        int rowCoeficient = Math.abs(moveRow - this.row);
        int colCoeficient = moveCol - this.col;

        return  (rowCoeficient == 2 ||
                colCoeficient == 2||
                rowCoeficient==-2||
                colCoeficient==-2);
    }

    public void healPiece(int HP){
        if (HP+chance>12){
            HP=15;
        }
        if (HP+chance<=12){
            HP=HP+chance;
        }
    }

    @Override
    public boolean isAttackValid(int attackRow, int attackCol) {
        return this.isMoveValid(attackRow, attackCol);
    }
}
