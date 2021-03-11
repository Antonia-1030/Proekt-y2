package game;

import figures.*;
import message.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameBoard extends JFrame implements MouseListener {
    public static final int WIDTH = 9;
    public static final int HEIGHT = 7;
    private Piece[][] pieceCollection;
    private Piece selectedPiece;
    private Piece attackedPiece;

    public static boolean isGameOver=false;
    public int playerScore=0;
    public int enemyScore=0;
    public int movesCount=0;
    public boolean isPlayerBlue=true;
    private boolean isMoving;
    private boolean isAttacking;

    FontMetrics size;

    public GameBoard(){
        this.pieceCollection = new Piece[WIDTH][HEIGHT];

        //Red
        pieceCollection[0][0] = (new Knight(0, 0, Color.RED));
        pieceCollection[0][1] = (new Knight(0, 1, Color.RED));
        pieceCollection[0][2] = (new Dwarf(0, 2, Color.RED));
        pieceCollection[0][3] = (new Dwarf(0, 3, Color.RED));
        pieceCollection[0][4] = (new Elf(0, 4, Color.RED));
        pieceCollection[0][5] = (new Elf(0, 5, Color.RED));

        //Blue
        pieceCollection[6][0] = (new Knight(0, 0, Color.BLUE));
        pieceCollection[6][1] = (new Knight(0, 1, Color.BLUE));
        pieceCollection[6][2] = (new Dwarf(0, 2, Color.BLUE));
        pieceCollection[6][3] = (new Dwarf(0, 3, Color.BLUE));
        pieceCollection[6][4] = (new Elf(0, 4, Color.BLUE));
        pieceCollection[6][5] = (new Elf(0, 5, Color.BLUE));

        this.setSize(700, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Great Cheese Wars");
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        menu();

        addMouseListener(this);

        this.setVisible(true);
    }

    //menu panel
    public void menu(){
        JButton atk=new JButton("Attack");
        JButton move=new JButton("Move");
        JButton heal=new JButton("Heal");
        JButton restart=new JButton("Restart");

        atk.setSize(100,30);
        atk.setLocation(520,20);
        move.setSize(100,30);
        move.setLocation(520,60);
        heal.setSize(100,30);
        heal.setLocation(520,100);
        restart.setSize(100,30);
        restart.setLocation(520,400);

        this.add(atk);
        this.add(move);
        this.add(heal);
        this.add(restart);

        heal.addActionListener(e->{healPiece();});
        move.addActionListener(e->isAttacking=false);
        atk.addActionListener(e->isMoving=false);
        restart.addActionListener(e->new GameBoard());

        this.setLayout(null);
        this.setVisible(true);
    }

    public Piece getSelectedPiece() {
        return selectedPiece;
    }

    public void setSelectedPiece(Piece selectedPiece) {
        this.selectedPiece = selectedPiece;
    }

    //move piece on board
    public void movePiece(int row, int col, Piece p) {
        int initialRow = p.getRow();
        int initialCol = p.getCol();

        p.move(row, col);

        this.pieceCollection[p.getRow()][p.getCol()] = this.selectedPiece;
        this.pieceCollection[initialRow][initialCol] = null;

        this.selectedPiece = null;
    }

    public Piece getBoardPiece(int row, int col) {
        return this.pieceCollection[row][col];
    }

    public boolean hasBoardPiece(int row, int col) {
        return this.getBoardPiece(row, col) != null;
    }

    public void paint(Graphics g) {
        //visualize board
        super.paint(g);
        if (!isGameOver){
            playerTurn();
            for(int row = 0; row < WIDTH; row++) {
                for(int col = 0; col < HEIGHT; col++) {
                    this.renderGameTile(g,row, col);
                    obstacleGenerator(g);
                    this.renderGamePiece(g, row, col);
                }
            }
        }
        else {
            gameOver(g);
        }
    }

    //renders the tiles and figures
    public void renderGamePiece(Graphics g, int row, int col) {
            if(this.hasBoardPiece(row, col)) {
                Piece p = this.getBoardPiece(row, col);
                p.render(g);
            }
    }

    private void renderGameTile(Graphics g, int row, int col){
        GameTile tile= new GameTile(row, col);
        tile.render(g);
    }

    public void obstacleGenerator (Graphics g) {
        int  randomizer= (int)(Math.random()*4+1);
        g.setColor(Color.PINK);
        for (int obstacle = 0; obstacle < randomizer; obstacle++) {
            int obstacle_row = randomizer;
            int obstacle_col = randomizer;
            g.fillRect(obstacle_row,obstacle_col,50,50 );
        }
    }

    public int chosenFigure () {
        Piece p = (Piece) this.selectedPiece;
        this.pieceCollection[p.getRow()][p.getCol()] = this.selectedPiece;
        int atk = p.getAttack();
        return atk;
    }

    public int enemyFigure (int row, int col) {
        this.pieceCollection[row][col] = this.attackedPiece;
        Piece p = (Piece) this.attackedPiece;
        int defence = p.getDefence();
        int health = p.getHP();
        int healthRemaining = health - (chosenFigure() - defence);
        return healthRemaining;
    }

    public void gameOver(Graphics g){
        size = getFontMetrics(g.getFont());
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Serif Plain",Font.ITALIC,20));
        g.drawString("Score: "+playerScore+"/1200", 100,10);
        g.drawString("Enemy score: "+enemyScore+"/1200", 100,50);
        g.drawString("Moves: "+movesCount, 100,100);

        if (isGameOver && playerScore==1200){
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Serif Italic",Font.BOLD,90));
            g.drawString("You win! Congrats!",120,HEIGHT/2);
        }
        if (isGameOver && enemyScore==1200){
            g.setColor(Color.RED);
            g.setFont(new Font("Serif Plain",Font.BOLD,90));
            g.drawString("Enemy wins!",120,HEIGHT/2);
        }
    }

    public void playerTurn(){
        while (isPlayerBlue){
            movesCount++;

            isPlayerBlue=!isPlayerBlue;
        }
    }

    //try healing piece
    private void healPiece(){
        int dice=(int)(Math.random()*6+1);
        Piece p = this.selectedPiece;
        int health = p.getHP();

        if (health+dice<=health){
            health=health+dice;
        }
        health=health;
    }

    //check if a tile is empty
    private boolean isTileEmpty(int row, int col) {
        if(this.pieceCollection[row][col] != null) {
            return false;
        }
        return true;
    }

    public int getBoardDimention(int coordinates) {
        return coordinates / GameTile.TILE_SIZE;
    }

    // check if piece is already selected and moves
    public void mouseClicked(MouseEvent e) {
        int row = this.getBoardDimention(e.getY());
        int col = this.getBoardDimention(e.getX());
        if(this.selectedPiece != null) {
            Piece p = this.selectedPiece;

            if(p.isMoveValid(row, col) && isTileEmpty(row,col) && isMoving) {
                int initialRow = p.getRow();
                int initialCol = p.getCol();

                movePiece(row, col, p);
                this.pieceCollection[initialRow][initialCol] = null;
                this.pieceCollection[row][col] = this.selectedPiece;
                this.repaint();
                return;
            }
            if (p.isAttackValid(row,col) && !isTileEmpty(row,col) && isAttacking){
                p.setHealth(enemyFigure(row,col));

                if (p.isPieceDead(true) && isPlayerBlue){
                    playerScore=playerScore+200;
                }
                if (p.isPieceDead(true) && !isPlayerBlue){
                    enemyScore=enemyScore+200;
                }
            }
        }
        else {
            Message.render(this, "Error", "Invalid move!");
            return;
        }

        if(this.hasBoardPiece(row, col)) {
            this.selectedPiece = this.getBoardPiece(row, col);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    //action listler
    public class buttonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}