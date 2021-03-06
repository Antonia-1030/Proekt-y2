package figures;

import java.awt.*;

public abstract class Figure {
    protected int row;
    protected int col;
    protected Color color;
    protected int point;
    protected String id;

    public static int HP;
    public static int ATTACK;
    public static int DEFENCE;
    public static int SPEED;
    public static int RANGE;


    public Figure(int row, int col, Color color, String id) {
        this.row = row;
        this.col = col;
        this.color = color;
        this.id = id;
    }

    public Figure(int row, int col, Color color) {
        this(row, col, Color.BLACK, "K");
        this.point = 50;
        this.row = row;
        this.col = col;
        this.color = color;
    }

    // get row & col
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void move(int row, int col) {
        this.row = row;
        this.col = col;
    }
    //move & attack
    public abstract boolean isMoveValid(int moveRow, int moveCol);
    public abstract boolean isAttackValid(int attackRow, int attackCol);
}
