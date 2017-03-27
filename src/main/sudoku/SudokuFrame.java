package main.sudoku;

import javax.swing.*;
import java.awt.*;

/**
 * Created by agustin on 26/3/17.
 */
public class SudokuFrame extends JFrame {
    private JTextField f[][]= new JTextField[9][9] ;
    private JPanel board[][]= new JPanel [3][3];

    public SudokuFrame() {

     /*   super("Sudoku");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(285,230);
        setLocationRelativeTo(null);
        setResizable(false);




        JPanel board=new JPanel();
        board.setLayout(new GridLayout(9,9));
        */
        JPanel panel= new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JPanel sudokuPanel= new JPanel();




            for(int x=0; x<=8; x++){
                for(int y=0; y<=8; y++){
                    f[x][y]=new JTextField(1);
                    f[x][y].setText("1");
                }
            }

            for(int x=0; x<=2; x++){
                for(int y=0; y<=2; y++){
                    board[x][y]=new JPanel(new GridLayout(3,3));
                }
            }
            sudokuPanel.setLayout(new GridLayout(3,3,5,5));

            for(int u=0; u<=2; u++){
                for(int i=0; i<=2; i++){
                    for(int x=0; x<=2; x++ ){
                        for(int y=0; y<=2; y++){
                            board[u][i].add(f[y][x]);
                        }
                    }
                    sudokuPanel.add(board[u][i]);
                }
            }


            panel.add(sudokuPanel);



        setVisible(true);


    }
}
