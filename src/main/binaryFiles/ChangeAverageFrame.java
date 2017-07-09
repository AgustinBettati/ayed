package main.binaryFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class ChangeAverageFrame extends JFrame{
    private JTextField dni;
    private JTextField average;

    public ChangeAverageFrame(ActionListener changeAverageButton) {

        super("");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(340,250);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        JLabel title = new JLabel("Modify average");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));

        JPanel dniPanel = new JPanel();
        dniPanel.setLayout(new BoxLayout(dniPanel, BoxLayout.LINE_AXIS));
        dniPanel.setMaximumSize(new Dimension(290,35));

        JLabel dniLabel = new JLabel("Enter DNI: ");

        dni = new JTextField();

        dniPanel.add(dniLabel);
        dniPanel.add(dni);


        JPanel averagePanel = new JPanel();
        averagePanel.setLayout(new BoxLayout(averagePanel, BoxLayout.LINE_AXIS));
        averagePanel.setMaximumSize(new Dimension(290,35));

        JLabel averageLabel = new JLabel("Enter average: ");

        average = new JTextField();

        averagePanel.add(averageLabel);
        averagePanel.add(average);


        JButton submitValues = new JButton("Make change");
        submitValues.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitValues.addActionListener(changeAverageButton);


        mainPanel.add(Box.createRigidArea(new Dimension(0,10)));
        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0,20)));
        mainPanel.add(dniPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0,15)));
        mainPanel.add(averagePanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0,15)));
        mainPanel.add(submitValues);
        mainPanel.add(Box.createRigidArea(new Dimension(0,15)));

        add(mainPanel);
    }

    public int getDni(){
        return Integer.parseInt(dni.getText());
    }

    public double getAverage(){
        return Double.parseDouble(average.getText());
    }
}
