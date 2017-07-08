package main.tablaHash;

import struct.impl.lists.DynamicList;

import javax.swing.*;
import javax.swing.border.Border;
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
        setSize(300,180);
        setLocationRelativeTo(null);
        setResizable(false);



        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        JLabel title = new JLabel("Predictive Dictionary");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));

        JPanel wordPanel = new JPanel();
        wordPanel.setLayout(new BoxLayout(wordPanel, BoxLayout.LINE_AXIS));
        wordPanel.setMaximumSize(new Dimension(290,35));

        JLabel wordLabel = new JLabel("Enter your word: ");

        word= new JTextField();
        word.getDocument().addDocumentListener(textFieldListener);

        wordPanel.add(wordLabel);
        wordPanel.add(word);


        JPanel correctWordsPanel = new JPanel();
        correctWords= new JLabel();
        correctWords.setForeground(new Color(9, 108, 11));
        correctWords.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        correctWordsPanel.add(correctWords);



        mainPanel.add(Box.createRigidArea(new Dimension(0,10)));
        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0,20)));
        mainPanel.add(wordPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0,15)));
        mainPanel.add(correctWordsPanel);

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
