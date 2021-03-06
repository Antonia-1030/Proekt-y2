package figures;

import game.GameTile;
import java.awt.*;

public class Dwarf extends Figure{
    public static int HP=12;
    public static int ATTACK=6;
    public static int DEFENCE=2;
    public static int SPEED=2;
    public static int RANGE=2;

    public Dwarf(int row, int col, Color color, String id) {
        super(row, col, color, "D");
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
