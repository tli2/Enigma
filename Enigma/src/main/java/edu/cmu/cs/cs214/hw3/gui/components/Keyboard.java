package edu.cmu.cs.cs214.hw3.gui.components;

import edu.cmu.cs.cs214.hw3.gui.KeyPressedListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Tianyu on 1/23/16.
 */
public class Keyboard extends JPanel {
    private static final char[] row1 = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'};
    private static final char[] row2 = {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'};
    private static final char[] row3 = {'Z', 'X', 'C', 'V', 'B', 'N', 'M'};
    private final List<KeyPressedListener> listeners;

    /**
     * Instantiates a new Keyboard.
     *
     * @param listener the listener
     */
    public Keyboard(KeyPressedListener listener) {
        listeners = new ArrayList<>();
        listeners.add(listener);
        setSize(400, 175);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new KeyboardRow(row1));
        add(new KeyboardRow(row2));
        add(new KeyboardRow(row3));
        setVisible(true);
    }


    private final class KeyboardRow extends JPanel {
        /**
         * Instantiates a new Keyboard row.
         *
         * @param row the row
         */
        KeyboardRow(char[] row) {
            FlowLayout manager = new FlowLayout();
            manager.setHgap(5);
            setLayout(manager);
            for (char character : row) {
                JButton button = new JButton(Character.toString(character));
                button.addActionListener(new KeyPressListener(character));
                button.setPreferredSize(new Dimension(30, 20));
                add(button);
                setVisible(true);
            }
        }
    }

    private class KeyPressListener implements ActionListener {
        private char character;

        /**
         * Instantiates a new Key press listener.
         *
         * @param character the character
         */
        KeyPressListener(char character) {
            this.character = character;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            listeners.forEach(a -> a.keyPressed(character));
        }
    }
}
