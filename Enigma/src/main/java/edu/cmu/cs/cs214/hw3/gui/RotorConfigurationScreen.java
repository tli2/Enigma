package edu.cmu.cs.cs214.hw3.gui;

import edu.cmu.cs.cs214.hw3.enigma.Enigma;
import edu.cmu.cs.cs214.hw3.enigma.Reflector;
import edu.cmu.cs.cs214.hw3.enigma.Rotor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Tianyu on 1/25/16.
 */
public class RotorConfigurationScreen extends JPanel {
    RotorConfigurationListener listener;

    public RotorConfigurationScreen(Enigma enigma, List<Rotor> rotors, List<Reflector> reflectors,
                                    RotorConfigurationListener listener) {
        this.listener = listener;
        List<JList> selectedRotors = new ArrayList<>();

        for (int i = 0; i < enigma.getRotorNumber(); i ++) {
            JList list = new JList(rotors.toArray());
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            selectedRotors.add(list);
        }

        JList reflectorList = new JList(reflectors.toArray());
        reflectorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JButton button = new JButton("Submit");
        button.addActionListener(a ->
            listener.onRotorConfigurationSubmitted(selectedRotors.stream()
                                            .map(b -> (Rotor) b.getSelectedValue()).collect(Collectors.toList()),
                    (Reflector) reflectorList.getSelectedValue())
        );

        setLayout(new FlowLayout());

        for (JList list : selectedRotors) {
            add(list);
        }

        add(reflectorList);
        add(button);

        setVisible(true);
    }
}
