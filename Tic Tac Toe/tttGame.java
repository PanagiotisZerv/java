import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class tttGame extends JPanel implements ActionListener{
    static JButton[] buttons = new JButton[9];
    
    static int turn = 1;
    static JPanel panel = new JPanel();
    static JTextField panelText = new JTextField();
    static boolean vert = false;
    static boolean hor = false;
    static boolean dia = false;
    static String winner = "";
    static Font myFont = new Font("Ink Free", Font.ITALIC, 70);
    static JPanel keyPad = new JPanel();


    tttGame(){
        panelText.setFont(myFont);
        panelText.setFocusable(false);
        panelText.setBorder(null);
        panelText.setBackground(Color.black);
        panelText.setForeground(Color.white);
        panelText.setBounds(100,20,800,100);
        if(turn % 2 != 0){
            panelText.setText("Player X is Playing");
        }else{
            panelText.setText("Player O is Playing");
        }

        keyPad.setLayout(new GridLayout(3,3,15,15));
        keyPad.setBounds(0, 100, 800, 700);
        keyPad.setBackground(Color.BLACK);

        for(int i = 0; i <= 8; i++){
            buttons[i] = new JButton();
            buttons[i].setBackground(Color.white);
            buttons[i].setFont(myFont);
            buttons[i].addActionListener(this);
            buttons[i].setFocusable(false);
            keyPad.add(buttons[i]);
        }

        panel.setFont(myFont);
        panel.add(panelText);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        panel.setBounds(0,0,800,100);

        JFrame window = new JFrame("Tic Tac Toe");
        window.setSize(800, 800);
        window.add(panel, BorderLayout.NORTH);
        window.add(keyPad, BorderLayout.CENTER);
        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        for (int i = 0; i <= 8; i++){
            if(e.getSource() == buttons[i]){
                if(turn % 2 != 0){
                    panelText.setText("Player O is Playing");
                    if(buttons[i].getText() == ""){
                        buttons[i].setText("X");
                        turn++;
                    }
                }else{
                    panelText.setText("Player X is Playing");
                    if(buttons[i].getText() == ""){
                        buttons[i].setText("O");
                        turn++;
                    }
                }
            }
        }
        CheckForWin();
        if(vert || hor || dia){
            JOptionPane.showMessageDialog(null, "Player " + "tttGame win " + winner + " has won.", winner, JOptionPane.PLAIN_MESSAGE);
            vert = false;
            hor = false;
            dia = false;
            for(int i = 0; i <= 8; i++){
                buttons[i].setText("");
            }
            if(turn % 2 != 0){
                panelText.setText("Player X is Playing");
            }else{
                panelText.setText("Player O is Playing");
            }
        }
        if(buttons[0].getText() != "" && buttons[1].getText() != "" && buttons[2].getText() != "" && buttons[3].getText() != "" && buttons[4].getText() != "" && buttons[5].getText() != "" && buttons[6].getText() != "" && buttons[7].getText() != "" && buttons[8].getText() != "" &&
        vert == false && hor == false && dia == false){
            JOptionPane.showMessageDialog(null, "This round was a draw.", "tttGame draw", JOptionPane.PLAIN_MESSAGE);
            for(int i = 0; i <= 8; i++){
                buttons[i].setText("");
            }
            if(turn % 2 != 0){
                panelText.setText("Player X is Playing");
            }else{
                panelText.setText("Player O is Playing");
            }
        }
    }
    private static void CheckForWin(){
        String symbol1 = "X";
        String symbol2 = "O";
        String symbol = "";
        for(int i = 0;i <= 1; i++){
            if(i == 0){
                symbol = symbol1;
            }else{
                symbol  = symbol2;
            }
            for(int k = 0; k <= 8; k += 3){
                if(buttons[k].getText() == symbol && buttons[k + 1].getText() == symbol && buttons[k + 2].getText() == symbol){
                    vert = true;
                    winner = symbol;
                }
            }
            for(int k = 0; k <= 2; k ++){
                if(buttons[k].getText() == symbol && buttons[k + 3].getText() == symbol && buttons[k + 6].getText() == symbol){
                    hor = true;
                    winner = symbol;
                }
            }
            if(buttons[0].getText() == symbol && buttons[4].getText() == symbol && buttons[8].getText() == symbol){
                dia = true;
                winner = symbol;
            }else if(buttons[2].getText() == symbol && buttons[4].getText() == symbol && buttons[6].getText() == symbol){
                dia = true;
                winner = symbol;
            }
        }
    }
    public static void main(String[] args) {
        new tttGame();
    }
}
