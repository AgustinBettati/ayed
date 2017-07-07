package main.tablaHash;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * @author Marcos Khabie
 * @version 1.0
 */
public class ViewControler {
    private MainFrame main;
    private Dictionary dictionary;

    public ViewControler() {
        dictionary= new Dictionary();
        main = new MainFrame(new TextFieldLiestener());

        }

        public class TextFieldLiestener implements DocumentListener {
            public TextFieldLiestener() {
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (main.getWord()==null){

                }
                main.displaysWords(dictionary.getSimilarWords(main.getWord()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            if (main.getWord()==null){

            }
                main.displaysWords(dictionary.getSimilarWords(main.getWord()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (main.getWord()==null){

                }
                main.displaysWords(dictionary.getSimilarWords(main.getWord()));
            }
        }
    }



