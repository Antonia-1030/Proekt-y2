package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen extends JFrame implements ActionListener {
    JButton startButton;
    JLabel BackGr;

    public StartScreen(){
        this.setSize(550, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Great Cheese Wars");
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        startButton=new JButton();
        startButton.setText("Start");
        startButton.setSize(200,100);
        startButton.setLocation(250,450);
        startButton.addActionListener(this);

        setContentPane(new JLabel(new ImageIcon("src/images/cw background.png")));
        BackGr=new JLabel();
        this.add(BackGr);


        this.add(startButton);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==startButton){
            this.setVisible(false);
            new GameBoard();
        }
    }
}
