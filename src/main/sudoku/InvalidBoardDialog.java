package main.sudoku;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by agustin on 30/3/17.
 */
public class InvalidBoardDialog extends JDialog {

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
