package figures;

import game.GameTile;
import java.awt.*;

public abstract class Piece {
    protected int row;
    protected int col;
    protected Color color;
    protected int point;
    protected String id;

    //public static int chance=(int)(Math.random()*6+1);
    public static int HP;
    public static int ATTACK;
    public static int DEFENCE;
    public static int SPEED;
    public static int RANGE;
    public static boolean isDead;


    public Piece(int row, int col, Color color, String id) {
        this.row = row;
        this.col = col;
        this.color = color;
        this.id = id;
        this.ATTACK=ATTACK;
        this.HP=HP;
        this.DEFENCE=DEFENCE;
    }
//set values
    public Piece(int row, int col, Color color) {
        this(row, col, Color.BLUE, "K");
        this.point = 50;
        this.row = row;
        this.col = col;
        this.color = color;
        this.ATTACK=ATTACK;
        this.DEFENCE=DEFENCE;
        this.HP=HP;
        this.RANGE=RANGE;
    }

    // get row & col
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    //get values
    public int getAttack(){return ATTACK;}
    public int getDefence(){return DEFENCE;}
    public int getHP(){return HP;}
    public int getRange(){return RANGE;}

    public void setHealth(int health) {
        this.HP = HP;
    }

    public void move(int row, int col) {
        this.row = row;
        this.col = col;
    }
// render piece
    public void render(Graphics g) {
        int x = this.col * GameTile.TILE_SIZE;
        int y = this.row * GameTile.TILE_SIZE;

        g.setColor(this.color);
        g.fillRect(x, y, 50, 50);

        g.setColor(Color.BLACK);
        g.drawString(this.id, x + 25, y + 25);
    }

    //move & attack
    public abstract boolean isMoveValid(int moveRow, int moveCol);
    public abstract boolean isAttackValid(int attackRow, int attackCol);
    public abstract boolean isPieceDead(boolean isDead);
}