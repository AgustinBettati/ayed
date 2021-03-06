package main.studentManagmentBinaryFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class NewStudentFrame extends JFrame{
    private JTextField dni;
    private JTextField surname;
    private JTextField name;
    private JTextField average;

    public NewStudentFrame(ActionListener newStudentButton, ActionListener backButtonListener) {

        super("");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(340,320);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        JLabel title = new JLabel("Register new student");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));

        JPanel dniPanel = new JPanel();
        dniPanel.setLayout(new BoxLayout(dniPanel, BoxLayout.LINE_AXIS));
        dniPanel.setMaximumSize(new Dimension(290,35));

        JLabel dniLabel = new JLabel("Enter DNI: ");

        dni = new JTextField();

        dniPanel.add(dniLabel);
        dniPanel.add(dni);

        JPanel surnamePanel = new JPanel();
        surnamePanel.setLayout(new BoxLayout(surnamePanel, BoxLayout.LINE_AXIS));
        surnamePanel.setMaximumSize(new Dimension(290,35));

        JLabel surnameLabel = new JLabel("Enter surname: ");

        surname = new JTextField();

        surnamePanel.add(surnameLabel);
        surnamePanel.add(surname);


        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.LINE_AXIS));
        namePanel.setMaximumSize(new Dimension(290,35));

        JLabel nameLabel = new JLabel("Enter name: ");

        name = new JTextField();

        namePanel.add(nameLabel);
        namePanel.add(name);

        JPanel averagePanel = new JPanel();
        averagePanel.setLayout(new BoxLayout(averagePanel, BoxLayout.LINE_AXIS));
        averagePanel.setMaximumSize(new Dimension(290,35));

        JLabel averageLabel = new JLabel("Enter average: ");

        average = new JTextField();

        averagePanel.add(averageLabel);
        averagePanel.add(average);


        JButton submitValues = new JButton("Submit");
        submitValues.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitValues.addActionListener(newStudentButton);

        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(backButtonListener);


        mainPanel.add(Box.createRigidArea(new Dimension(0,10)));
        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0,20)));
        mainPanel.add(dniPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0,15)));
        mainPanel.add(surnamePanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0,15)));
        mainPanel.add(namePanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0,15)));
        mainPanel.add(averagePanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0,15)));
        mainPanel.add(submitValues);
        mainPanel.add(Box.createRigidArea(new Dimension(0,15)));
        mainPanel.add(backButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0,15)));

        add(mainPanel);
    }


    public Student getStudent(){
        Student student = new Student(Integer.parseInt(dni.getText()), surname.getText(),
                name.getText(),Double.parseDouble(average.getText()),true);
        freeFields();
        return student;
    }

    private void freeFields(){
        dni.setText("");
        name.setText("");
        surname.setText("");
        average.setText("");
    }
}
