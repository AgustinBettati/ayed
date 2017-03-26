package main.swingGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class takes care of any interaction made to the
 * settings window, as well as making sure it open and closes
 * correctly.
 *
 * @author      Agustin Bettati
 * @author      Marcos Khabie
 * @version     1.0
 */
public class SettingsController {
    private SettingsFrame settingsWindow;
    private MenuFrame mainWindow;

    /**
     * This constructor creates a SettingsController using that MenuFrame as parameter.
     * @param mainWindow
     * Is a MenuFrame used for the SettingsController to interact with the main menu.
     */
    public SettingsController(MenuFrame mainWindow){
        this.mainWindow = mainWindow;
        settingsWindow = new SettingsFrame(new GoBackToMenu(), new SettingsChange());
    }


    public void showWindow(){

        settingsWindow.setVisible(true);
        mainWindow.dispose();
    }

    public class GoBackToMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            mainWindow.setVisible(true);
            settingsWindow.dispose();
        }
    }

    public class SettingsChange implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String settingState = "Sound: "+ settingsWindow.soundSetting()+
                    ", Music: "+ settingsWindow.musicSetting()+
                    ", Shadows: "+ settingsWindow.shadowSetting()+
                    ", Anti-aliasing: "+ settingsWindow.antiAliasingSetting();

            System.out.println(settingState);
        }
    }
}
