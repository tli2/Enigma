package edu.cmu.cs.cs214.hw3.gui;



import javax.swing.*;


/**
 * Created by Tianyu on 1/23/16.
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new EnigmaUI();
            frame.setSize(600, 400);
            frame.setResizable(false);
            frame.setVisible(true);
        });
    }
}
