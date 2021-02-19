package game;

import java.awt.*;

public class GameTile {
    public static final int TILE_SIZE = 50;
    private int row;
    private int col;

    public GameTile(){
        this.row=row;
        this.col=col;
    }

    public void render(Graphics g){
        tilesPainter(g);
        boardGrid(g);
    }

    //draw border between different squares
    private void boardGrid(Graphics g){
        g.setColor(Color.BLACK);
        for(int i = 0; i <=400; i+= 50){
            for (int j = 20; j<= 320; j += 50){
                g.drawRect(i,j,50,50);
            }
        }
    }
    //draw tiles
    public void tilesPainter(Graphics g){
        for (int x = 0; x<9;x++){
            for (int y = 0; y<7;y++){
                g.fillRect(x*TILE_SIZE,(y*TILE_SIZE)+20,TILE_SIZE,TILE_SIZE);
                tileSeter(g,x,y);
            }
        }
    }

    public void tileSeter(Graphics g, int row, int col){
        if (isTileBlack(row,col)) {
            g.setColor(Color.BLACK);
        }
        else if (isTileGray(row,col)){
            g.setColor(Color.LIGHT_GRAY);
        }
        else tileWhile(g);
    }

    //white tile
    public void tileWhile(Graphics g){
        g.setColor(Color.WHITE);
    }
    //black tile
    private boolean isTileBlack(int row, int col){
        return ((row == 1 && col == 0) ||
                (row == 3 && col == 0) ||
                (row == 5 && col == 0) ||
                (row == 7 && col == 0) ||
                (row == 0 && col == 1)||
                (row == 2 && col == 1)||
                (row == 4 && col == 1)||
                (row == 6 && col == 1)||
                (row == 8 && col == 1)||
                (row == 0 && col == 5)||
                (row == 2 && col == 5)||
                (row == 4 && col == 5)||
                (row == 6 && col == 5)||
                (row == 8 && col == 5)||
                (row == 1 && col == 6) ||
                (row == 3 && col == 6) ||
                (row == 5 && col == 6) ||
                (row == 7 && col == 6));
    }

    //gray tile
    private boolean isTileGray(int row, int col){
        return ((row == 0 && col == 0) ||
                (row == 2 && col == 0) ||
                (row == 4 && col == 0) ||
                (row == 6 && col == 0) ||
                (row == 8 && col == 0)||
                (row == 1 && col == 1)||
                (row == 3 && col == 1)||
                (row == 5 && col == 1)||
                (row == 7 && col == 1)||

                (row == 1 && col == 5)||
                (row == 3 && col == 5)||
                (row == 5 && col == 5)||
                (row == 7 && col == 5)||
                (row == 0 && col == 6)||
                (row == 2 && col == 6) ||
                (row == 4 && col == 6) ||
                (row == 6 && col == 6) ||
                (row == 8 && col == 6));
    }
}
