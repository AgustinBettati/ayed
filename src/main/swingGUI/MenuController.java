package main.swingGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class handles all interactions made in the menu window.
 *
 * @author      Agustin Bettati
 * @author      Marcos Khabie
 * @version     1.0
 */
public class MenuController {
    private MenuFrame mainMenu;
    private GameFrame startGameMenu;
    private SettingsController settingsController;

    /**
     * This constructor creates a MenuFrame and a settingsController using that MenuFrame as parameter.
     */
    public MenuController(){
        mainMenu = new MenuFrame( new OpenStartGame(), new OpenSettings(), new Exit() );
        settingsController = new SettingsController(mainMenu);
    }

    public class OpenStartGame implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            startGameMenu = new GameFrame(new GoBackFromGame());
            mainMenu.dispose();
        }
    }

    public class GoBackFromGame implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            mainMenu.setVisible(true);
            startGameMenu.dispose();
        }
    }

    public class OpenSettings implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            settingsController.showWindow();
        }
    }

    public class Exit implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}
