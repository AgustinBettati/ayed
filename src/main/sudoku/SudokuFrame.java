package main.sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SudokuFrame extends JFrame {

    private JTextField[][] board= new JTextField[9][9];

    public SudokuFrame(ActionListener ResolveButtonListener) {

       super("Sudoku");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,330);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel= new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        JPanel sudokuBoard = new JPanel(new GridLayout(9, 9));


        for(int i= 0; i < 9; i++) {

            for(int j = 0; j < 9; j++) {

                board[i][j] = new JTextField();

                int number1 = i;
                int number2 = j;
                board[i][j].addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        if (board[number1][number2].getText().length() >= 1 ||
                                !Character.isDigit( e.getKeyChar() ))
                            e.consume();
                    }
                });
                board[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));


                Font font = new Font("Arial", Font.PLAIN, 20);

                board[i][j].setFont(font);

                board[i][j].setForeground(Color.BLACK);

                board[i][j].setBackground(Color.WHITE);


                board[i][j].setOpaque(true);

                board[i][j].setHorizontalAlignment(JTextField.CENTER);

                sudokuBoard.add(board[i][j]);

            }
        }

        JButton resolveButton = new JButton("Resolve");
        resolveButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        resolveButton.setSize(30,25);
        resolveButton.addActionListener(ResolveButtonListener);

        mainPanel.add(sudokuBoard);
        mainPanel.add(resolveButton);
        add(mainPanel);
        setVisible(true);
    }

    public int[][] getValues(){
        int [][] result= new int[9][9];
        for(int i= 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (board[i][j].getText().isEmpty()){
                    result[i][j]=0;
                }
                else {
                    result[i][j] = Integer.parseInt(board[i][j].getText());
                }
            }
        }
       return result;
   }

    public void setValuesToWindow(int [][] solvedBoard){
        for(int i= 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                board[i][j].setText(Integer.toString(solvedBoard[i][j]));
            }
        }
    }
}


