package main.chessMovement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChessFrame extends JFrame {

    private JLabel[][] board= new JLabel[8][8];

    private int amountOfMovements;

    public ChessFrame(int amountOfMovements,ActionListener NextPathButtonListener){
        super("Chess");
        this.amountOfMovements = amountOfMovements;

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
                board[i][j].setBackground(Color.BLACK);
            }
            else {
                board[i][j].setBackground(Color.WHITE);
            }
                board[i][j].setOpaque(true);
                chessBoard.add(board[i][j]);
            }
        }

        JButton nextButton = new JButton("Next path");
        nextButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        nextButton.setSize(30,25);
        nextButton.addActionListener(NextPathButtonListener);

        mainPanel.add(chessBoard);
        mainPanel.add(nextButton);
        add(mainPanel);
        setVisible(true);
    }

    private void paintSquare(PositionInBoard position, int numberOfMovement){
        board[position.row()][position.column()].setBackground(Color.red);
        board[position.row()][position.column()].setText(""+numberOfMovement);

        Font font = new Font("Arial", Font.PLAIN, 30);
        board[position.row()][position.column()].setFont(font);
        board[position.row()][position.column()].setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void paintHorse(PositionInBoard position){
        Image image = new ImageIcon(this.getClass().getResource("/main/chessMovement/images/10_Silueta_Caballo_Rojo_by_DG-RA.png")).getImage();
        ImageIcon icon = new ImageIcon(image);
        board[position.row()][position.column()].setIcon(icon);
    }

    public void cleanBoard(){
        for(int i= 7; i >=0; i--) {
            for(int j = 0; j < 8; j++) {

                if ((i+j)%2==0) {
                    board[i][j].setBackground(Color.BLACK);
                }
                else {
                    board[i][j].setBackground(Color.WHITE);
                }

                board[i][j].setText(null);
                board[i][j].setIcon(null);
            }

        }
    }

    public void displayPathOfMovements(ArrayList<PositionInBoard> movements){

        cleanBoard();

        paintSquare(new PositionInBoard(0,0), 0);

        for (int i = 0; i < amountOfMovements - 1; i++){
            paintSquare(movements.get(i), i+1);
        }

        for(int j = amountOfMovements -1; j < movements.size(); j++) {
            paintHorse(movements.get(j));
        }

    }




}



