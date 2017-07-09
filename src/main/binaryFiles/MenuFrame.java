package main.binaryFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class MenuFrame extends JFrame {

    public MenuFrame(ActionListener addNewStudent, ActionListener removeStudent,
                     ActionListener changeAverage, ActionListener listStudents,
                     ActionListener listSpecificStudents, ActionListener generateIndexFile){

        super("IO of binary file of students");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350,280);
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



        JLabel title = new JLabel("Management of students");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));


        JButton newStudentButton = new JButton("Add new student");
        newStudentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        newStudentButton.addActionListener(addNewStudent);

        JButton removeStudentButton = new JButton("Remove student");
        removeStudentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        removeStudentButton.addActionListener(removeStudent);

        JButton changeAverageButton = new JButton("Modify average of student");
        changeAverageButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        changeAverageButton.addActionListener(changeAverage);

        JButton listStudentButton = new JButton("List all students");
        listStudentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        listStudentButton.addActionListener(listStudents);

        JButton listSpecificStudentButton = new JButton("List of students with certain average");
        listSpecificStudentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        listSpecificStudentButton.addActionListener(listSpecificStudents);

        JButton generateIndexButton = new JButton("Generate index file");
        generateIndexButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        generateIndexButton.addActionListener(generateIndexFile);

        mainPanel.add(Box.createRigidArea(new Dimension(0,20)));
        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0,20)));
        mainPanel.add(newStudentButton);
        mainPanel.add(removeStudentButton);
        mainPanel.add(changeAverageButton);
        mainPanel.add(listStudentButton);
        mainPanel.add(listSpecificStudentButton);
        mainPanel.add(generateIndexButton);

        add(mainPanel);

        setVisible(true);
    }
}
