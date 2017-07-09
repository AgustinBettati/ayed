package main.binaryFiles;

import main.chessMovement.AllPathsShownDialog;

import main.swingGUI.GameFrame;
import main.swingGUI.SettingsController;
import struct.impl.lists.DynamicList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class MenuController {
    private MenuFrame view;
    private ListStudentsFrame studentsFrame;
    private StudentFile file;

    public MenuController(){
        view = new MenuFrame(new AddNewStudent(), new RemoveStudent(),
                new ModifyAverage(), new ListAllStudents(), new ListSpecificStudents(), null);
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
        public void actionPerformed(ActionEvent e) {int dniToAdd;
//            amountOfMovements = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the amount of movements:",
//                    "Horse Movements",
//                    JOptionPane.INFORMATION_MESSAGE));
//            chessWindow = new ChessFrame(amountOfMovements,new ChessController.NextPathButtonListener());
//            horseMovement = new HorseMovement(amountOfMovements);
//            allPathsShownWindow = new AllPathsShownDialog(new ChessController.ResetButtonListener())





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

            try {

                DynamicList<Student> listAllStudents = file.studentsList();
                String[] list= new String[listAllStudents.size()];
                for (int i = 0; i <listAllStudents.size(); i++) {
                    listAllStudents.goTo(i);
                    list[i]=listAllStudents.getActual().toString();
                }
                studentsFrame= new ListStudentsFrame(new GoBack(), list);
                view.dispose();
            } catch (IOException e1) {
                e1.printStackTrace();
            }



        }
    }
    public class ListSpecificStudents implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                double minAverage= Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Enter the minimum Average to create the list:",
                    "Specific Average",
                    JOptionPane.INFORMATION_MESSAGE));
                DynamicList<Student> listSomeStudents = file.listOfStudentsAbove(minAverage);
                String[] list= new String[listSomeStudents.size()];

                for (int i = 0; i <listSomeStudents.size(); i++) {
                    listSomeStudents.goTo(i);
                    list[i]=listSomeStudents.getActual().toString();
                }
                studentsFrame= new ListStudentsFrame(new GoBack(), list);
                view.dispose();
            } catch (IOException e1) {
                e1.printStackTrace();
            }


        }
    }
        public class GoBack implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(true);
                studentsFrame.dispose();

        }
    }



}
