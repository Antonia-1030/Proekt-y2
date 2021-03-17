package figures;

import java.awt.*;

public class Knight extends Piece {
    public static int HP=15;
    public static int ATTACK=8;
    public static int DEFENCE=3;
    public static int SPEED=1;
    public static int RANGE=1;
    public static boolean isDead=false;

    public Knight(int row, int col, Color color) {
        super(row, col, color, "K");
    }

    @Override
    public boolean isMoveValid(int moveRow, int moveCol) {
        int rowCoeficient = Math.abs(moveRow - this.row);
        int colCoeficient = moveCol - this.col;

        return  (rowCoeficient == 1 ||
                colCoeficient == 1 ||
                rowCoeficient==-1||
                colCoeficient==-1);
    }

    public void healPiece(int HP){
        if (HP+chance>15){
            HP=15;
        }
        if (HP+chance<=15){
            HP=HP+chance;
        }
    }

    @Override
    public boolean isAttackValid(int attackRow, int attackCol) {
        return this.isMoveValid(attackRow, attackCol);
    }
}
