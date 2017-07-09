package main.binaryFiles;

import main.swingGUI.GameFrame;
import main.swingGUI.SettingsController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class MenuController {
    private MenuFrame view;
    private StudentFile file;

    public MenuController(){
        view = new MenuFrame(new AddNewStudent(), new RemoveStudent(),
                new ModifyAverage(), new ListAllStudents(), new ListSpecificStudents());
        try {
            file = new StudentFile("students");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public class AddNewStudent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


        }
    }

    public class RemoveStudent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class ModifyAverage implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class ListAllStudents implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    public class ListSpecificStudents implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


}
