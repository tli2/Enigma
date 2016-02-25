package edu.cmu.cs.cs214.hw3.gui.components;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Tianyu on 1/23/16.
 */
public class Lamp extends JLabel {
    private final Timer timer;
    private static final int DURATION = 300;

    /**
     * Instantiates a new Lamp.
     *
     * @param character the character
     */
    public Lamp(char character) {
        super(Character.toString(character), JLabel.CENTER);
        setBackground(Color.WHITE);
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        setPreferredSize(new Dimension(30, 20));
        timer = new Timer(DURATION, e -> setBackground(Color.WHITE));
    }

    /**
     * Light.
     */
    public void light() {
        setBackground(Color.YELLOW);
        timer.restart();
    }
}
