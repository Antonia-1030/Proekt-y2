package figures;

import game.GameTile;

import java.awt.*;

public class Dwarf extends Piece {
    public static int HP=12;
    public static int ATTACK=6;
    public static int DEFENCE=2;
    public static int SPEED=2;
    public static int RANGE=2;
    public static boolean isDead;

    public Dwarf(int row, int col, Color color) {
        super(row, col, color, "D");
        this.ATTACK=ATTACK;
        this.DEFENCE=DEFENCE;
        this.HP=HP;
        this.RANGE=RANGE;
    }

    //render piece
    public void render(Graphics g) {
        int x = this.col * GameTile.TILE_SIZE;
        int y = this.row * GameTile.TILE_SIZE;

        g.setColor(this.color);
        g.fillRect(x, y, 50, 50);

        g.setColor(Color.BLACK);
        g.drawString(this.id, x + 25, y + 25);
    }

    @Override
    public boolean isMoveValid(int moveRow, int moveCol) {
        int rowCoeficient = Math.abs(moveRow - this.row);
        int colCoeficient = moveCol - this.col;

        return  (rowCoeficient == SPEED ||
                colCoeficient == SPEED||
                rowCoeficient==-SPEED||
                colCoeficient==-SPEED);
    }

    public boolean isAttackValid(int attackRow, int attackCol) {
        return this.isMoveValid(attackRow, attackCol);
    }

    @Override
    public boolean isPieceDead(boolean isDead) {
        if (HP<=0){
            return true;
        }
        return false;
    }
}