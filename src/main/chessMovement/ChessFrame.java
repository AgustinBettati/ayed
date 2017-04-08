package main.chessMovement;

import struct.impl.LinkedStack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class is window which displays a chess board and the movement of the horse with a button to display the next path.
 *
 * @author Marcos Khabie
 * @author Agustin Bettati
 * @version     1.0
 *
 */
public class ChessFrame extends JFrame {

    private JLabel[][] board = new JLabel[8][8];
    private JPanel[] stackPanels;
    private ArrayList<PositionInBoard> positionsThatArePainted = new ArrayList<>();

    private int amountOfMovements;

    /**
     * This constructor creates a new frame that represents the chess view .
     *
     * @param amountOfMovements      The amount of movements that will be asked to do to the horse.
     * @param NextPathButtonListener The Action Listener used to display the next path view.
     */
    public ChessFrame(int amountOfMovements, ActionListener NextPathButtonListener) {
        super("Chess");
        this.amountOfMovements = amountOfMovements;
        stackPanels = new JPanel[amountOfMovements];

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 670);
        setLocationRelativeTo(null);
        setResizable(false);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));


        JPanel chessBoard = new JPanel(new GridLayout(9, 9));

        JPanel stacksPanel = new JPanel();
        stacksPanel.setLayout(new BoxLayout(stacksPanel, BoxLayout.X_AXIS));


        for (int i = 0; i < stackPanels.length; i++) {
            stackPanels[i] = new JPanel();
            stackPanels[i].setLayout(new BoxLayout(stackPanels[i], BoxLayout.PAGE_AXIS));
            stackPanels[i].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
            stackPanels[i].setAlignmentX(Component.BOTTOM_ALIGNMENT);
            stacksPanel.add(stackPanels[i]);
            stacksPanel.add(Box.createRigidArea(new Dimension(15, 130)));
        }
        Font font = new Font("Arial", Font.PLAIN, 15);

        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {

                if (j == 0) {
                    JLabel number = new JLabel();
                    number.setText(""+ (i+1));
                    chessBoard.add(number);
                    number.setHorizontalAlignment(SwingConstants.CENTER);
                    number.setFont(font);

                }


                    board[i][j] = new JLabel();
                    board[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

                    if ((i + j) % 2 == 0) {
                        board[i][j].setBackground(Color.BLACK);
                    } else {
                        board[i][j].setBackground(Color.WHITE);
                    }
                    board[i][j].setOpaque(true);
                    chessBoard.add(board[i][j]);
                }
            }


        chessBoard.add(Box.createRigidArea(new Dimension(1,1)));


            for (int i=1;i<9;i++){
                String character = "";
                switch (i){
                    case 1:
                        character = "A";
                        break;

                    case 2:
                        character = "B";
                        break;
                    case 3:
                        character = "C";
                        break;
                    case 4:
                        character = "D";
                        break;
                    case 5:
                        character = "E";
                        break;
                    case 6:
                        character = "F";
                        break;
                    case 7:
                        character = "G";
                        break;
                    case 8:
                        character = "H";
                        break;
                }
                JLabel letter= new JLabel();
                letter.setText(character);
                letter.setHorizontalAlignment(SwingConstants.CENTER);
                letter.setFont(font);
                chessBoard.add(letter);

        }


        JButton nextButton = new JButton("Next path");
        nextButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        nextButton.setSize(30,25);
        nextButton.addActionListener(NextPathButtonListener);

        mainPanel.add(chessBoard);
        mainPanel.add(stacksPanel);
        mainPanel.add(nextButton);
        mainPanel.add(stacksPanel.add(Box.createRigidArea(new Dimension(0,10))));

        add(mainPanel);
        setVisible(true);
    }

    /**
     * Displays a list of stacks in the view.
     * @param listOfStacks
     */
    public void displayStacks(ArrayList<ArrayList<PositionInBoard>> listOfStacks){

        for(int i = 0; i< listOfStacks.size(); i++){
            stackPanels[i].removeAll();
            ArrayList<PositionInBoard> aStack = listOfStacks.get(i);

            for (PositionInBoard position : aStack){
                stackPanels[i].add(new JLabel("" + position));
            }
        }
    }

    /**
     *
     *  A method that paints red a square of the chess board with the corresponding number representing which number of movement is.
     * @param position
     * The position in board which will be painted
     * @param numberOfMovement
     * The number that will be shown inside the square.
     */
    private void paintSquare(PositionInBoard position, int numberOfMovement){
        board[position.row()][position.column()].setBackground(Color.red);
        board[position.row()][position.column()].setText(""+numberOfMovement);

        Font font = new Font("Arial", Font.PLAIN, 30);
        board[position.row()][position.column()].setFont(font);
        board[position.row()][position.column()].setHorizontalAlignment(SwingConstants.CENTER);
    }

    /**
     * A method that paints the horse in the indicated position square
     * @param position
     * The position where the horse will be painted.
     */
    private void paintHorse(PositionInBoard position){
        Image image = new ImageIcon(this.getClass().getResource("/main/chessMovement/images/10_Silueta_Caballo_Rojo_by_DG-RA.png")).getImage();
        ImageIcon icon = new ImageIcon(image);
        board[position.row()][position.column()].setIcon(icon);
    }

    /**
     * A method that cleans the board leaving it empty.
     */
    public void cleanBoard(){

        for(PositionInBoard position : positionsThatArePainted){
            int i = position.row();
            int j = position.column();
            if ((i+j)%2==0) {
                board[i][j].setBackground(Color.BLACK);
            }
            else {
                board[i][j].setBackground(Color.WHITE);
            }

            board[i][j].setText(null);
            board[i][j].setIcon(null);
        }
        positionsThatArePainted.clear();
    }

    /**
     * A method  paints red squares of the chess board and paint the correct horses showing the horse's path and thr number of movements.
     * @param movements
     * An ArrayList that contains the positions in board of the path that will be painted.
     */
    public void displayPathOfMovements(ArrayList<PositionInBoard> movements){

        cleanBoard();

        paintSquare(new PositionInBoard(0,0), 0);

        for (int i = 0; i < amountOfMovements - 1; i++){
            paintSquare(movements.get(i), i+1);
            positionsThatArePainted.add( movements.get(i) );
        }

        for(int j = amountOfMovements -1; j < movements.size(); j++) {
            paintHorse(movements.get(j));
            positionsThatArePainted.add( movements.get(j) );
        }

    }
}



