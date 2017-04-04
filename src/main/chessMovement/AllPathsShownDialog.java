package main.chessMovement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 *
 * This class contains a window that states that all paths of the horse have
 * been shown.
 */
public class AllPathsShownDialog extends JDialog {


    /**
     * created the Dialog.
     * @param restartButtonListener
     */
    public AllPathsShownDialog(ActionListener restartButtonListener){

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModal(true);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setSize(400,120);
        setLocationRelativeTo(null);
        setResizable(false);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));



        JLabel title = new JLabel("All paths have been showed.");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));


        JButton backButton = new JButton("Reset");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(restartButtonListener);



        mainPanel.add(Box.createRigidArea(new Dimension(0,20)));
        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0,20)));
        mainPanel.add(backButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0,17)));

        add(mainPanel);
    }
}
