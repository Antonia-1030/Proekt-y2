package figures;

import java.awt.*;

public class Elf extends Piece {
    public static int HP=10;
    public static int ATTACK=5;
    public static int DEFENCE=1;
    public static int SPEED=3;
    public static int RANGE=3;
    public static boolean isDead=false;

    public Elf(int row, int col, Color color) {
        super(row, col, color, "E");
    }

    @Override
    public boolean isMoveValid(int moveRow, int moveCol) {
        int rowCoeficient = Math.abs(moveRow - this.row);
        int colCoeficient = moveCol - this.col;

        boolean isDynamicByRow          = rowCoeficient == 3;
        boolean isDynamicByCol          = colCoeficient == 3;
        boolean isDynamicByDiagonal     = isDynamicByRow && isDynamicByCol;

        return  (isDynamicByRow ||
                isDynamicByCol  ||
                isDynamicByDiagonal);
    }

    public void healPiece(int HP){
        if (HP+chance>10){
            HP=15;
        }
        if (HP+chance<=10){
            HP=HP+chance;
        }
    }

    @Override
    public boolean isAttackValid(int attackRow, int attackCol) {
        return this.isMoveValid(attackRow, attackCol);
    }
}
