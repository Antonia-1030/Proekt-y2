package game;

import java.awt.*;

public class GameTile {
    private int row;
    private int col;
    public static int TILE_SIZE=50;

    public int obstacle_row;
    public int obstacle_col;

    public GameTile(int row,int col){
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
            for (int j = 20; j<= 350; j += 50){
                g.drawRect(i,j,50,50);
            }
        }
    }
    //draw tiles
    public void tilesPainter(Graphics g){
        tileGray(g);
        tileBlack(g);
    }

    public void obstaclePosition(){
        obstacle_row=(int)(Math.random()*8+1);
        obstacle_col=(int)(Math.random()*7+1);
    }

    //black tile
    private void tileBlack(Graphics g){
        g.setColor(Color.BLACK);
        //player A
        g.fillRect(50,20,TILE_SIZE,TILE_SIZE);
        g.fillRect(150,20,TILE_SIZE,TILE_SIZE);
        g.fillRect(250,20,TILE_SIZE,TILE_SIZE);
        g.fillRect(350,20,TILE_SIZE,TILE_SIZE);
        //2 row
        g.fillRect(0,70,TILE_SIZE,TILE_SIZE);
        g.fillRect(100,70,TILE_SIZE,TILE_SIZE);
        g.fillRect(200,70,TILE_SIZE,TILE_SIZE);
        g.fillRect(300,70,TILE_SIZE,TILE_SIZE);
        g.fillRect(400,70,TILE_SIZE,TILE_SIZE);
        //Player B
        g.fillRect(0,270,TILE_SIZE,TILE_SIZE);
        g.fillRect(100,270,TILE_SIZE,TILE_SIZE);
        g.fillRect(200,270,TILE_SIZE,TILE_SIZE);
        g.fillRect(300,270,TILE_SIZE,TILE_SIZE);
        g.fillRect(400,270,TILE_SIZE,TILE_SIZE);
        //2 row
        g.fillRect(50,320,TILE_SIZE,TILE_SIZE);
        g.fillRect(150,320,TILE_SIZE,TILE_SIZE);
        g.fillRect(250,320,TILE_SIZE,TILE_SIZE);
        g.fillRect(350,320,TILE_SIZE,TILE_SIZE);
    }

    //gray tile
    private void tileGray(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        //Player A
        g.fillRect(0,20,TILE_SIZE,TILE_SIZE);
        g.fillRect(100,20,TILE_SIZE,TILE_SIZE);
        g.fillRect(200,20,TILE_SIZE,TILE_SIZE);
        g.fillRect(300,20,TILE_SIZE,TILE_SIZE);
        g.fillRect(400,20,TILE_SIZE,TILE_SIZE);
        //2 row
        g.fillRect(50,70,TILE_SIZE,TILE_SIZE);
        g.fillRect(150,70,TILE_SIZE,TILE_SIZE);
        g.fillRect(250,70,TILE_SIZE,TILE_SIZE);
        g.fillRect(350,70,TILE_SIZE,TILE_SIZE);
        //Player B
        g.fillRect(50,270,TILE_SIZE,TILE_SIZE);
        g.fillRect(150,270,TILE_SIZE,TILE_SIZE);
        g.fillRect(250,270,TILE_SIZE,TILE_SIZE);
        g.fillRect(350,270,TILE_SIZE,TILE_SIZE);
        //2 row
        g.fillRect(0,320,TILE_SIZE,TILE_SIZE);
        g.fillRect(100,320,TILE_SIZE,TILE_SIZE);
        g.fillRect(200,320,TILE_SIZE,TILE_SIZE);
        g.fillRect(300,320,TILE_SIZE,TILE_SIZE);
        g.fillRect(400,320,TILE_SIZE,TILE_SIZE);
    }
}