package edu.cmu.cs.cs214.hw3.gui;

import edu.cmu.cs.cs214.hw3.enigma.ArmyM3Enigma;
import edu.cmu.cs.cs214.hw3.enigma.Enigma;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianyu on 1/23/16.
 */
public class ModelSelectionScreen extends JPanel {
    ModelSelectionListener listener;

    public ModelSelectionScreen(List<Enigma> models, ModelSelectionListener listener) {
        this.listener = listener;
        JList list = new JList(models.toArray());
        setSize(400, 200);
        setLayout(new FlowLayout());
        add(list);

        JButton button = new JButton("confirm");
        button.addActionListener(a -> {
            listener.onModelSelected((Enigma) list.getSelectedValue());
        });
        add(button);

        setVisible(true);
    }



}
