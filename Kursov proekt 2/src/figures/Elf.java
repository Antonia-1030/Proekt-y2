package figures;

import game.GameTile;
import java.awt.*;

public class Elf extends Figure{
    public static int HP=10;
    public static int ATTACK=5;
    public static int DEFENCE=1;
    public static int SPEED=3;
    public static int RANGE=3;

    public Elf(int row, int col, Color color, String id) {
        super(row, col, color, "E");
    }

    @Override
    public boolean isMoveValid(int moveRow, int moveCol) {
        return false;
    }

    @Override
    public boolean isAttackValid(int attackRow, int attackCol) {
        return false;
    }
}
