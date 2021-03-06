package figures;

import game.GameTile;
import java.awt.*;

public class Knight extends  Figure{
    public static int HP=15;
    public static int ATTACK=8;
    public static int DEFENCE=3;
    public static int SPEED=1;
    public static int RANGE=1;

    public Knight(int row, int col, Color color, String id) {
        super(row, col, color, "K");
    }

    @Override
    public boolean isMoveValid(int moveRow, int moveCol) {
        int rowCoeficient = Math.abs(moveRow - this.row);
        int colCoeficient = moveCol - this.col;

        return  rowCoeficient == 1 &&
                colCoeficient == 1;
    }

    @Override
    public boolean isAttackValid(int attackRow, int attackCol) {
        return true;
    }
}
