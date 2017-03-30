package main.chessMovement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChessFrame extends JFrame {

    private JLabel[][] board= new JLabel[8][8];

    public ChessFrame(ActionListener SolveButtonListener){

            super("Chess");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(450,480);
            setLocationRelativeTo(null);
            setResizable(false);


            JPanel mainPanel= new JPanel();
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

            JPanel chessBoard = new JPanel(new GridLayout(8, 8));


            for(int i= 7; i >=0; i--) {
                for(int j = 0; j < 8; j++) {


                    board[i][j] = new JLabel();
                    board[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));



             if ((i+j)%2==0) {
                 board[i][j].setBackground(Color.WHITE);
             }
             else {
                 board[i][j].setBackground(Color.BLACK);
             }

                    board[i][j].setOpaque(true);


                    chessBoard.add(board[i][j]);

                }
            }

        Image image = new ImageIcon(this.getClass().getResource("/main/chessMovement/images/10_Silueta_Caballo_Rojo_by_DG-RA.png")).getImage();
        ImageIcon icon = new ImageIcon(image);
        board[2][4].setIcon(icon);


            JButton resolveButton = new JButton("Resolve");
            resolveButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            resolveButton.setSize(30,25);
            resolveButton.addActionListener(SolveButtonListener);

            mainPanel.add(chessBoard);
            mainPanel.add(resolveButton);
            add(mainPanel);
            setVisible(true);
        }


}



