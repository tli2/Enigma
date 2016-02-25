package edu.cmu.cs.cs214.hw3.gui;

import edu.cmu.cs.cs214.hw3.enigma.*;
import edu.cmu.cs.cs214.hw3.gui.components.Keyboard;
import edu.cmu.cs.cs214.hw3.gui.components.LampBoard;
import edu.cmu.cs.cs214.hw3.gui.components.RotorAdjustment;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianyu on 1/23/16.
 */
public class OperatorScreen extends JPanel implements KeyPressedListener {
    private final Enigma enigma;
    private Keyboard keyboard;
    private LampBoard lampBoard;
    private RotorAdjustment adjustment;
    private List<ConfigChangedListener> listeners;


    /**
     * Instantiates a new Operator screen.
     *
     * @param enigma the enigma
     * @param rotors the rotors
     */
    public OperatorScreen(Enigma enigma, List<Rotor> rotors, RotatingReflector reflector) {
        this.enigma = enigma;
        setUpScreen(rotors, reflector);
        setVisible(true);
    }

    private void setUpScreen(List<Rotor> rotors, RotatingReflector reflector) {
        listeners = new ArrayList<>();
        keyboard = new Keyboard(this);
        lampBoard = new LampBoard();
        adjustment = new RotorAdjustment(rotors, reflector);
        listeners.add(adjustment);
        setLayout(null);
        add(lampBoard);
        lampBoard.setBounds(300, 0, 600, 175);
        add(keyboard);
        keyboard.setBounds(300, 200, 600, 175);
        add(adjustment);
        adjustment.setBounds(0, 75, 250, 90);
        setVisible(true);

    }

    @Override
    public void keyPressed(char character) {
        lampBoard.light(enigma.encode(character));
        listeners.forEach(ConfigChangedListener::configChanged);
    }

}
