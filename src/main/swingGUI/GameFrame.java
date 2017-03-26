package main.swingGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This class is window which displays a simple image simulating
 * a game, with a button to go back to the main menu.
 *
 * @author      Agustin Bettati
 * @author      Marcos Khabie
 * @version     1.0
 */
public class GameFrame extends JFrame {
    /**
     * This constructor creates a new frame that represents the Start Game window using the according Action Listeners.
     * @param goBack
     * The Action Listener used to go back to the main menu window used by the the button "back".
     */
    public GameFrame(ActionListener goBack)  {

        super("Start game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);




        JPanel panel= new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        Image image = new ImageIcon(this.getClass().getResource("/main/swingGUI/images/Pac-Man.jpg")).getImage();
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton backButton = new JButton("back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setSize(30,25);
        backButton.addActionListener(goBack);

        panel.add(imageLabel);
        panel.add(Box.createRigidArea(new Dimension(0,10)));
        panel.add(backButton);
        panel.add(Box.createRigidArea(new Dimension(0,10)));

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


}
