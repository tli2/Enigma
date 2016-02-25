package edu.cmu.cs.cs214.hw3.gui.components;

import edu.cmu.cs.cs214.hw3.enigma.RotatingReflector;
import edu.cmu.cs.cs214.hw3.enigma.Rotor;
import edu.cmu.cs.cs214.hw3.enigma.Util;
import edu.cmu.cs.cs214.hw3.gui.ConfigChangedListener;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Tianyu on 1/23/16.
 */
public class RotorAdjustment extends JPanel implements ConfigChangedListener {
    private final Map<Rotor, Integer> config;
    private final List<RotorAdjuster> adjusters;
    private final ReflectorAdjuster adjuster;

    /**
     * Instantiates a new Rotor adjustment.
     *
     * @param rotors    the rotors
     * @param reflector the reflector
     */
    public RotorAdjustment(List<Rotor> rotors, RotatingReflector reflector) {
        config = new HashMap<>();
        adjusters = new ArrayList<>();
        setLayout(new FlowLayout());
        for (int i = 0; i < rotors.size(); i++) {
            config.put(rotors.get(i), rotors.get(i).getCurrentPosition());
            RotorAdjuster adjuster = new RotorAdjuster(rotors.get(i));
            add(adjuster);
            adjusters.add(adjuster);
        }

        if (reflector != null) {
            adjuster = new ReflectorAdjuster(reflector);
            add(adjuster);
        } else {
            adjuster = null;
        }

        JButton finalize = new JButton("set");
        finalize.addActionListener(e -> {
            config.entrySet().forEach(a -> a.getKey().setCurrentPosition(a.getValue()));
            if (adjuster != null) {
                adjuster.reflector.setOffset(adjuster.offset);
            }
            configChanged();
        });

        finalize.setPreferredSize(new Dimension(40, 20));
        add(finalize);

        setPreferredSize(new Dimension(400, 75));
        setVisible(true);
    }


    @Override
    public void configChanged() {
        adjusters.forEach(RotorAdjuster::updateConfig);
        if (adjuster != null) {
            adjuster.updateConfig();
        }
    }

    private class RotorAdjuster extends JPanel {
        private Rotor rotor;
        private JLabel label;

        /**
         * Instantiates a new Rotor adjuster.
         *
         * @param rotor the rotor
         */
        RotorAdjuster(Rotor rotor) {
            this.rotor = rotor;
            label = new JLabel("", JLabel.CENTER);
            label.setPreferredSize(new Dimension(30, 30));
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            label.setBackground(Color.WHITE);
            updateLabel();
            label.setOpaque(true);
            label.setVisible(true);

            JButton up = new JButton("+");
            up.addActionListener(e -> {
                increment();
                updateLabel();
            });
            up.setPreferredSize(new Dimension(15, 15));

            JButton down = new JButton("-");
            down.addActionListener(e -> {
                decrement();
                updateLabel();
            });
            down.setPreferredSize(new Dimension(15, 15));

            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            add(up);
            add(label);
            add(down);

            setVisible(true);
        }

        private void updateLabel() {
            char newChar = Util.translateFromPositionCode(config.get(rotor));
            label.setText(Character.toString(newChar));
        }

        private void updateConfig() {
            char newChar = Util.translateFromPositionCode(rotor.getCurrentPosition());
            label.setText(Character.toString(newChar));
        }

        private void increment() {
            int position = config.get(rotor);
            int newPosition = (position + 1) % Util.ROTOR_LENGTH;
            config.put(rotor, newPosition);
        }

        private void decrement() {
            int position = config.get(rotor);
            int newPosition = (position -1 + Util.ROTOR_LENGTH) % Util.ROTOR_LENGTH;
            config.put(rotor, newPosition);
        }
    }

    private class ReflectorAdjuster extends JPanel {
        private RotatingReflector reflector;
        private JLabel label;
        private int offset;

        /**
         * Instantiates a new Rotor adjuster.
         *
         * @param reflector the reflector
         */
        ReflectorAdjuster(RotatingReflector reflector) {
            this.reflector = reflector;
            offset = reflector.getOffset();
            label = new JLabel("", JLabel.CENTER);
            label.setPreferredSize(new Dimension(30, 30));
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            label.setBackground(Color.WHITE);
            updateLabel();
            label.setOpaque(true);
            label.setVisible(true);

            JButton up = new JButton("+");
            up.addActionListener(e -> {
                increment();
                updateLabel();
            });
            up.setPreferredSize(new Dimension(15, 15));

            JButton down = new JButton("-");
            down.addActionListener(e -> {
                decrement();
                updateLabel();
            });
            down.setPreferredSize(new Dimension(15, 15));

            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            add(up);
            add(label);
            add(down);

            setVisible(true);
        }

        private void updateLabel() {
            char newChar = Util.translateFromPositionCode(offset);
            label.setText(Character.toString(newChar));
        }

        private void updateConfig() {
            char newChar = Util.translateFromPositionCode(reflector.getOffset());
            label.setText(Character.toString(newChar));
        }

        private void increment() {
            int position = reflector.getOffset();
            offset = (position + 1) % Util.ROTOR_LENGTH;
        }

        private void decrement() {
            int position = reflector.getOffset();
            offset = (position -1 + Util.ROTOR_LENGTH) % Util.ROTOR_LENGTH;
        }
    }
}
