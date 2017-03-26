package main.swingGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This class is used to display a menu window, through which
 * the user can navigate to several other windows.
 *
 * @author      Agustin Bettati
 * @author      Marcos Khabie
 * @version     1.0
 */

public class MenuFrame extends JFrame {
    /**
     * This constructor creates a new frame that represents the Main MenuFrame window using the according Action Listeners.
     * @param startGame
     * The Action Listener used to open the Start Game window on  the button "Start Game".
     * @param settings
     * The Action Listener used to open the settings window on  the button "SettingsFrame".
     * @param exit
     * The Action Listener used to close the program called bi the "Exit" button.
     */
    public MenuFrame(ActionListener startGame, ActionListener settings, ActionListener exit){

        super("Main MenuFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(285,230);
        setLocationRelativeTo(null);
        setResizable(false);

        Image image = new ImageIcon(this.getClass().getResource("/main/swingGUI/images/background.png")).getImage();

        JPanel mainPanel= new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));



        JLabel title = new JLabel("Trabajo Practico Swing");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));

        JLabel names = new JLabel("Marcos Khabie & Agustin Bettati");
        names.setAlignmentX(Component.CENTER_ALIGNMENT);
        names.setFont(new Font(names.getFont().getName(), Font.ITALIC, 17));

        JButton startGameButton = new JButton("Start Game");
        startGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startGameButton.addActionListener(startGame);

        JButton settingsButton = new JButton("SettingsFrame");
        settingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        settingsButton.addActionListener(settings);

        JButton exitButton = new JButton("Exit");
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.addActionListener(exit);

        mainPanel.add(Box.createRigidArea(new Dimension(0,20)));
        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0,20)));
        mainPanel.add(names);
        mainPanel.add(Box.createRigidArea(new Dimension(0,20)));
        mainPanel.add(startGameButton);
        mainPanel.add(settingsButton);
        mainPanel.add(exitButton);

        add(mainPanel);

        setVisible(true);
    }
}
