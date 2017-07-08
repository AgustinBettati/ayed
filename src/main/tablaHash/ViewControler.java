package main.tablaHash;

import struct.impl.lists.DynamicList;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * @author Marcos Khabie
 * @version 1.0
 */
public class ViewControler {
    private MainFrame view;
    private Dictionary dictionary;

    public ViewControler() {
        dictionary= new Dictionary();
        view = new MainFrame(new TextFieldLiestener());
    }

    public class TextFieldLiestener implements DocumentListener {
        void respondToNewWord(){
            String currentWord = view.getWord();
            if (currentWord==null || currentWord.isEmpty() || dictionary.wordIsPresent(currentWord)){
                view.displaysWords(new DynamicList<>());
            }
            else {
                view.displaysWords(dictionary.getSimilarWords(view.getWord()));

            }
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            respondToNewWord();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            respondToNewWord();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            respondToNewWord();
        }
    }

}



