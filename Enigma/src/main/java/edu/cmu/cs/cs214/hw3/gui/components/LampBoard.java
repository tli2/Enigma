package edu.cmu.cs.cs214.hw3.gui.components;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianyu on 1/23/16.
 */
public class LampBoard extends JPanel {
    private static final char[] row1 = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'};
    private static final char[] row2 = {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'};
    private static final char[] row3 = {'Z', 'X', 'C', 'V', 'B', 'N', 'M'};
    private final Map<Character, Lamp> lamps;

    /**
     * Instantiates a new Lamp board.
     */
    public LampBoard() {
        lamps = new HashMap<>();
        setSize(400, 175);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new LampBoardRow(row1));
        add(new LampBoardRow(row2));
        add(new LampBoardRow(row3));
        setVisible(true);
    }

    /**
     * Light.
     *
     * @param c the c
     */
    public void light(char c) {
        lamps.get(c).light();
    }


    private final class LampBoardRow extends JPanel {
        /**
         * Instantiates a new Lamp board row.
         *
         * @param row the row
         */
        LampBoardRow(char[] row) {
            FlowLayout manager = new FlowLayout();
            manager.setHgap(5);
            setLayout(manager);
            for (char character : row) {
                Lamp lamp = new Lamp(character);
                lamps.put(character, lamp);
                setVisible(true);
                add(lamp);
            }
        }
    }
}
