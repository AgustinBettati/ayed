package main.tablaHash;

import struct.impl.lists.DynamicList;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * @author Marcos Khabie
 * @version 1.0
 */
public class MainFrame extends JFrame {

    private JTextField word;
    private JLabel correctWords;
    public MainFrame(DocumentListener textFieldListener) {

        super("Trabajo Practico HashTable");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,200);
        setLocationRelativeTo(null);
        setResizable(false);



        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        JLabel title = new JLabel("Predictive Dictionary");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));

        word= new JTextField();
        word.getDocument().addDocumentListener(textFieldListener);
        word.setSize(20,2);
        word.setHorizontalAlignment(JTextField.CENTER);


        correctWords= new JLabel();

        correctWords.setSize(100,100);

        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0,20)));
        mainPanel.add(correctWords);
        mainPanel.add(Box.createRigidArea(new Dimension(0,150)));
        mainPanel.add(word);

        add(mainPanel);
        setVisible(true);



    }



    public String getWord(){
        return word.getText();
    }

    public void displaysWords(DynamicList<String> words){
        String listOfWords= "";
        for (int i = 0; i <words.size() ; i++) {
            words.goTo(i);
            listOfWords+= words.getActual() + " \n";
        }

        correctWords.setText(listOfWords);

    }
}
