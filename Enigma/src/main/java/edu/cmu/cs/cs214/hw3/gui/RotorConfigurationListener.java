package edu.cmu.cs.cs214.hw3.gui;

import edu.cmu.cs.cs214.hw3.enigma.Reflector;
import edu.cmu.cs.cs214.hw3.enigma.Rotor;

import java.util.List;

/**
 * Created by Tianyu on 1/26/16.
 */
public interface RotorConfigurationListener {

    void onRotorConfigurationSubmitted(List<Rotor> config, Reflector reflector);
}
