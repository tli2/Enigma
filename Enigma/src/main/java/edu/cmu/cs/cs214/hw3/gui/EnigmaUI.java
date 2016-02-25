package edu.cmu.cs.cs214.hw3.gui;

import edu.cmu.cs.cs214.hw3.enigma.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianyu on 1/23/16.
 */
public class EnigmaUI extends JFrame implements ModelSelectionListener, RotorConfigurationListener {
    private ModelSelectionScreen modelSelection;
    private RotorConfigurationScreen rotorConfiguration;
    private OperatorScreen operator;
    private Enigma enigma;

    /**
     * Instantiates a new Enigma ui.
     */
    public EnigmaUI() {
        modelSelection = new ModelSelectionScreen(getModels(), this);
        add(modelSelection);
        setTitle("Enigma Emulator");
        setVisible(true);
    }

    @Override
    public void onModelSelected(Enigma enigma) {
        remove(modelSelection);
        rotorConfiguration = new RotorConfigurationScreen(enigma, getRotors(), getReflectors(), this);
        this.enigma = enigma;
        add(rotorConfiguration);
        pack();
        setSize(600, 400);
    }

    @Override
    public void onRotorConfigurationSubmitted(List<Rotor> config, Reflector reflector) {
        remove(rotorConfiguration);
        enigma.construct(config, reflector);
        if (reflector instanceof RotatingReflector) {
            operator = new OperatorScreen(enigma, config, (RotatingReflector) reflector);
        } else {
            operator = new OperatorScreen(enigma, config, null);
        }
        add(operator);
        pack();
        setSize(800, 450);
    }

    private static List<Enigma> getModels() {
        List<Enigma> models = new ArrayList<>();
        models.add(new ArmyM3Enigma());
        models.add(new NavalM4Enigma());
        return models;
    }

    private static List<Rotor> getRotors() {
        List<Rotor> rotors = new ArrayList<>();
        rotors.add(new StandardRotor("src/main/resources/RotorIConfig"));
        rotors.add(new StandardRotor("src/main/resources/RotorIIConfig"));
        rotors.add(new StandardRotor("src/main/resources/RotorIIIConfig"));
        rotors.add(new StandardRotor("src/main/resources/RotorIVConfig"));
        rotors.add(new StandardRotor("src/main/resources/RotorVConfig"));
        rotors.add(new StandardRotor("src/main/resources/RotorVIConfig"));
        rotors.add(new StandardRotor("src/main/resources/RotorVIIConfig"));
        rotors.add(new StandardRotor("src/main/resources/RotorVIIIConfig"));
        return rotors;
    }

    private static List<Reflector> getReflectors() {
        List<Reflector> reflectors = new ArrayList<>();
        reflectors.add(new StandardReflector("src/main/resources/ReflectorAConfig"));
        reflectors.add(new StandardReflector("src/main/resources/ReflectorBConfig"));
        reflectors.add(new StandardReflector("src/main/resources/ReflectorCConfig"));
        reflectors.add(new RotatingReflector("src/main/resources/ReflectorAConfig"));
        reflectors.add(new RotatingReflector("src/main/resources/ReflectorBConfig"));
        reflectors.add(new RotatingReflector("src/main/resources/ReflectorCConfig"));
        return reflectors;
    }
}
