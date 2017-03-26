package main.swingGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This class is used to display a simple settings window,
 * in which the user can change preferences for his game.
 *
 * @author      Agustin Bettati
 * @author      Marcos Khabie
 * @version     1.0
 */
public class SettingsFrame extends JFrame {

    private JCheckBox shadows;
    private JCheckBox antiAliasing;
    private ButtonGroup soundGroup;
    private ButtonGroup musicGroup;

    /**
     * This constructor creates a new frame that represents the SettingsFrame window using the according Action Listeners.
     * @param goBack
     * The Action Listener used to go back to the main menu window used by the the button "back".
     * @param settingsChange
     * The Action Listener used to show to update the state settings state and print it.
     */
    public SettingsFrame(ActionListener goBack, ActionListener settingsChange){

        super("SettingsFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(340, 240);
        setLocationRelativeTo(null);
        setResizable(false);
        

        JPanel settingPanel = new JPanel();
        settingPanel.setLayout(new BoxLayout(settingPanel, BoxLayout.PAGE_AXIS));

        JPanel soundPanel=new JPanel();
        soundPanel.setLayout(new FlowLayout());

        JPanel musicPanel=new JPanel();
        musicPanel.setLayout(new FlowLayout());

        JPanel graphicsPanel=new JPanel();
        graphicsPanel.setLayout(new FlowLayout());


        JLabel title = new JLabel("SettingsFrame");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));

        JLabel sound = new JLabel("Sound:");
        sound.setAlignmentX(Component.LEFT_ALIGNMENT);

        JRadioButton soundOn= new JRadioButton("On");
        JRadioButton  soundOff= new JRadioButton("Off");
        soundOn.setActionCommand("On");
        soundOff.setActionCommand("Off");
        soundGroup = new ButtonGroup();
        soundGroup.add(soundOn);
        soundGroup.add(soundOff);
        soundOn.setSelected(true);

        JLabel music = new JLabel("Music:");
        music.setAlignmentX(Component.LEFT_ALIGNMENT);

        JRadioButton musicOn= new JRadioButton("On");
        JRadioButton musicOff= new JRadioButton("Off");
        musicOn.setActionCommand("On");
        musicOff.setActionCommand("Off");
        musicGroup = new ButtonGroup();
        musicGroup.add(musicOn);
        musicGroup.add(musicOff);
        musicOff.setSelected(true);


        JLabel graphics = new JLabel("Graphics:");
        graphics.setAlignmentX(Component.LEFT_ALIGNMENT);

        shadows = new JCheckBox("Shadows");
        antiAliasing = new JCheckBox("Anti-aliasing");
        shadows.setSelected(true);

        soundOn.addActionListener(settingsChange);
        soundOff.addActionListener(settingsChange);
        musicOn.addActionListener(settingsChange);
        musicOff.addActionListener(settingsChange);
        shadows.addActionListener(settingsChange);
        antiAliasing.addActionListener(settingsChange);

        JButton backButton = new JButton("back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(goBack);

        soundPanel.add((Box.createRigidArea(new Dimension(10,0))));
        soundPanel.add(sound);
        soundPanel.add((Box.createRigidArea(new Dimension(10,0))));
        soundPanel.add(soundOn);
        soundPanel.add((Box.createRigidArea(new Dimension(10,0))));
        soundPanel.add(soundOff);

        musicPanel.add((Box.createRigidArea(new Dimension(10,0))));
        musicPanel.add(music);
        musicPanel.add((Box.createRigidArea(new Dimension(10,0))));
        musicPanel.add(musicOn);
        musicPanel.add((Box.createRigidArea(new Dimension(10,0))));
        musicPanel.add(musicOff);

        graphicsPanel.add((Box.createRigidArea(new Dimension(10,0))));
        graphicsPanel.add(graphics);
        graphicsPanel.add((Box.createRigidArea(new Dimension(10,0))));
        graphicsPanel.add(shadows);
        graphicsPanel.add((Box.createRigidArea(new Dimension(10,0))));
        graphicsPanel.add(antiAliasing);

        settingPanel.add(Box.createRigidArea(new Dimension(0,20)));
        settingPanel.add(title);
        settingPanel.add(Box.createRigidArea(new Dimension(0,20)));
        settingPanel.add(soundPanel);
        settingPanel.add(musicPanel);
        settingPanel.add(graphicsPanel);
        settingPanel.add(Box.createRigidArea(new Dimension(0,10)));
        settingPanel.add(backButton);

        add(settingPanel);
    }

    public String soundSetting(){
        return soundGroup.getSelection().getActionCommand();
    }

    public String musicSetting(){
        return musicGroup.getSelection().getActionCommand();
    }

    public String shadowSetting(){
        if(shadows.isSelected())
            return "On";
        else return "Off";
    }

    public String antiAliasingSetting(){
        if(antiAliasing.isSelected())
            return "On";
        else return "Off";
    }
}
