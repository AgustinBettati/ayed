package main.sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class SudokuFrame extends JFrame {

    private JTextField[][] board= new JTextField[9][9];
    private JPanel[][] panels = new JPanel [3][3];

    public SudokuFrame(ActionListener resolveButtonListener, ActionListener clearButtonListener) {

       super("Sudoku Solver");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,460);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel= new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        JPanel sudokuBoard = new JPanel(new GridLayout(3, 3));


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

                Font font = new Font("Arial", Font.PLAIN, 25);
                board[i][j].setFont(font);
                board[i][j].setForeground(Color.BLACK);
                board[i][j].setBackground(Color.WHITE);
                board[i][j].setOpaque(true);
                board[i][j].setHorizontalAlignment(JTextField.CENTER);
                sudokuBoard.add(board[i][j]);
            }
        }

        for(int x=0; x<=2; x++) {
            for (int y = 0; y <= 2; y++) {
                panels[x][y] = new JPanel(new GridLayout(3, 3));
            }
        }

        for(int u=0; u<3; u++){
            for(int i=0; i<3; i++){
                for(int x=0; x<3; x++ ){
                    for(int y=0; y<3; y++){
                        panels[u][i].add(board[x+u*3][y+i*3]);
                        panels[u][i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    }
                }
                sudokuBoard.add(panels[u][i]);
            }
        }
        JButton resolveButton = new JButton("Resolve");
        resolveButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        resolveButton.setSize(340,35);
        resolveButton.addActionListener(resolveButtonListener);

        JButton clearButton = new JButton("Clear board");
        clearButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        clearButton.setSize(340,35);
        clearButton.addActionListener(clearButtonListener);

        mainPanel.add(sudokuBoard);
        mainPanel.add(Box.createRigidArea(new Dimension(0,5)));
        mainPanel.add(resolveButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0,4)));
        mainPanel.add(clearButton);
        add(mainPanel);
        setVisible(true);
    }

    public void emptyBoard(){
        for(int i= 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j].setText("");
            }
        }
    }

    public int[][] getValues(){
        int [][] result= new int[9][9];
        for(int i= 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (board[i][j].getText().isEmpty() || board[i][j].getText().equals("")){
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


