package main.studentManagmentBinaryFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Marcos Khabie
 * @version 1.0
 */
public class ListStudentsFrame extends JFrame {

    private JList list;
    public ListStudentsFrame(ActionListener back, String [] studentsList, boolean isToDelete, ActionListener delete) {
        super("IO of binary file of students");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350,250);
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


        JLabel title = new JLabel("List of students: ");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));


        list = new JList(studentsList);
        list.setSelectedIndex(1);


        JButton backButton = new JButton("Back to Menu");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(back);

        mainPanel.add(title);

        mainPanel.add(Box.createRigidArea(new Dimension(0,20)));
        mainPanel.add(list);
        if (isToDelete){

            mainPanel.add(Box.createRigidArea(new Dimension(0,15)));

            JButton deleteButton = new JButton("Delete");
            deleteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            deleteButton.addActionListener(delete);

            mainPanel.add(deleteButton);



        }
        mainPanel.add(Box.createRigidArea(new Dimension(0,15)));
        mainPanel.add(backButton);

        add(mainPanel);
        pack();
        setVisible(true);




    }

    public int getDniOfSelected(){
        String s=list.getSelectedValue().toString();
        return Integer.parseInt(s.substring(4,12));
    }



}
