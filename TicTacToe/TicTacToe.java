
package TicTacToe;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe implements ActionListener{

    static Random random = new Random();
    static JFrame frame = new JFrame("Tic Tac Toe");
    static JButton[] buttons = new JButton[9];
    static JPanel buttonPanel = new JPanel();
    static JPanel textPanel = new JPanel();
    static JLabel text = new JLabel();
    static boolean p1Turn;

    
    public TicTacToe() {
        frame.setSize(640, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.black);

        text.setText("Have Fun!");
        text.setFont(new Font("sansSerif", Font.BOLD, 65));
        text.setForeground(Color.green);
        text.setOpaque(true);
        text.setHorizontalAlignment(JLabel.CENTER);
        
        textPanel.setBounds(0, 0, 640, 95);
        textPanel.setLayout(new BorderLayout());

        buttonPanel.setLayout(new GridLayout(3, 3));

        for(int i=0; i<9; i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,75));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}

        textPanel.add(text);
        frame.add(textPanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstTurn();
    }
@Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < 9; i++) {
            if(e.getSource()==buttons[i]) {
                if(p1Turn) {
                    if(buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(156, 158, 65));
                        buttons[i].setText("X");
                        p1Turn = false;
                        text.setText("O turn!");
                        check();
                    }
                    
                    }
                    else {
                        buttons[i].setForeground(new Color(60, 95, 55));
                        buttons[i].setText("O");
                        p1Turn = true;
                        text.setText("X turn!");
                        check();
            
                    
                }
            }
        }
        
    }

    public static void xWins(int a, int b, int c) {
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        text.setText("X Won!");
        text.setForeground(Color.green);
    }

    public static void oWins(int a, int b, int c) {
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        text.setText("O Won!");
        text.setForeground(Color.green);
    }

    public static void check() {

        //X win conditions

        if (buttons[0].getText() == "X" &&
        buttons[1].getText() == "X" &&
        buttons[2].getText() == "X") {
            xWins(0, 1, 2);
        }
        if (buttons[3].getText() == "X" &&
        buttons[4].getText() == "X" &&
        buttons[5].getText() == "X") {
            xWins(3, 4, 5);
        }
        if (buttons[6].getText() == "X" &&
        buttons[7].getText() == "X" &&
        buttons[7].getText() == "X") {
            xWins(6, 7, 8);
        }
        if (buttons[0].getText() == "X" &&
        buttons[3].getText() == "X" &&
        buttons[6].getText() == "X") {
            xWins(0, 3, 6);
        }
        if (buttons[1].getText() == "X" &&
        buttons[4].getText() == "X" &&
        buttons[7].getText() == "X") {
            xWins(1, 4, 7);
        }
        if (buttons[2].getText() == "X" &&
        buttons[5].getText() == "X" &&
        buttons[8].getText() == "X") {
            xWins(2, 5, 8);
        }
        if (buttons[0].getText() == "X" &&
        buttons[4].getText() == "X" &&
        buttons[8].getText() == "X") {
            xWins(0, 4, 8);
        }
        if (buttons[2].getText() == "X" &&
        buttons[4].getText() == "X" &&
        buttons[6].getText() == "X") {
            xWins(2, 4, 6);
        }

        //O win conditions

        if (buttons[0].getText() == "O" &&
        buttons[1].getText() == "O" &&
        buttons[2].getText() == "O") {
            oWins(0, 1, 2);
        }
        if (buttons[3].getText() == "O" &&
        buttons[4].getText() == "O" &&
        buttons[5].getText() == "O") {
            oWins(3, 4, 5);
        }
        if (buttons[6].getText() == "O" &&
        buttons[7].getText() == "O" &&
        buttons[7].getText() == "O") {
            oWins(6, 7, 8);
        }
        if (buttons[0].getText() == "O" &&
        buttons[3].getText() == "O" &&
        buttons[6].getText() == "O") {
            oWins(0, 3, 6);
        }
        if (buttons[1].getText() == "O" &&
        buttons[4].getText() == "O" &&
        buttons[7].getText() == "O") {
            oWins(1, 4, 7);
        }
        if (buttons[2].getText() == "O" &&
        buttons[5].getText() == "O" &&
        buttons[8].getText() == "O") {
            oWins(2, 5, 8);
        }
        if (buttons[0].getText() == "O" &&
        buttons[4].getText() == "O" &&
        buttons[8].getText() == "O") {
            oWins(0, 4, 8);
        }
        if (buttons[2].getText() == "O" &&
        buttons[4].getText() == "O" &&
        buttons[6].getText() == "O") {
            oWins(2, 4, 6);
        }

    } 

    public static void firstTurn() {

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException f) {
            f.printStackTrace();
        } 

        if (random.nextInt(2) == 0) {
            p1Turn = true;
            text.setText("X turn!");
        }
        else {
            p1Turn = false;
            text.setText("O turn!");
        }
    }


    public static void main(String[] args) {
        new TicTacToe();
    }

    
}
