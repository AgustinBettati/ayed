package main.sudoku;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 *
 * This class contains a window that states a invalid board was entered.
 */
public class InvalidBoardDialog extends JDialog {


    /**
     * Creates a dialog view that tells the user that a invalid board was entered.
     * @param backButtonListener
     */
    public InvalidBoardDialog(ActionListener backButtonListener){

       // super("Invalid Board Entry");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModal(true);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setSize(400,120);
        setLocationRelativeTo(null);
        setResizable(false);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));



        JLabel title = new JLabel("The board entered is not valid.");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));


        JButton backButton = new JButton("Try Again");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(backButtonListener);



        mainPanel.add(Box.createRigidArea(new Dimension(0,20)));
        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0,20)));
        mainPanel.add(backButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0,17)));

        add(mainPanel);
    }
}
