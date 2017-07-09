package main.binaryFiles;

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
    private MenuFrame menu;
    private ListStudentsFrame studentsFrame;
    private StudentFile file;
    private NewStudentFrame newStudentView;

    public MenuController(){
        menu = new MenuFrame(new AddNewStudent(), new RemoveStudent(),
                new ModifyAverage(), new ListAllStudents(), new ListSpecificStudents(), new GenerateIndexFile());
        newStudentView = new NewStudentFrame(new RegisterNewStudent());
        try {
            file = new StudentFile("students");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public class AddNewStudent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            newStudentView.setVisible(true);
            menu.dispose();
        }
    }

    public class RegisterNewStudent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Student student = newStudentView.getStudent();
            newStudentView.dispose();
            menu.setVisible(true);
            try {
                file.writeNewStudent(student);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public class GenerateIndexFile implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            file.generateIndexFile();
        }
    }


    public class RemoveStudent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {int dniToAdd;
            try {

                DynamicList<Student> listAllStudents = file.studentsList();
                String[] list= new String[listAllStudents.size()];
                for (int i = 0; i <listAllStudents.size(); i++) {
                    listAllStudents.goTo(i);
                    list[i]=listAllStudents.getActual().toString();
                }
                studentsFrame= new ListStudentsFrame(new GoBack(), list,true, new Delete());
                menu.dispose();
            } catch (IOException e1) {
                e1.printStackTrace();
            }




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

                studentsFrame= new ListStudentsFrame(new GoBack(), list,false,null);
                menu.dispose();

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

                studentsFrame= new ListStudentsFrame(new GoBack(), list,false,null);
                menu.dispose();

            } catch (IOException e1) {
                e1.printStackTrace();
            }


        }
    }
        public class GoBack implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(true);
                studentsFrame.dispose();

        }
    }
    public class Delete implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            try {

                    file.deleteStudent(studentsFrame.getDniOfSelected());


                    DynamicList<Student> listAllStudents = file.studentsList();
                    String[] list= new String[listAllStudents.size()];
                    for (int i = 0; i <listAllStudents.size(); i++) {
                        listAllStudents.goTo(i);
                        list[i]=listAllStudents.getActual().toString();
                    }

                    studentsFrame.dispose();
                    studentsFrame= new ListStudentsFrame(new GoBack(),list,true,new Delete());

//                studentsFrame.refreshList(list);
            } catch (IOException e1) {

                e1.printStackTrace();
            }
        }
    }



}
