package edu.cmu.cs.cs214.hw3.enigma;

import java.util.List;

/**
 * A Class that imitates Army M3 Enigma, 3 rotors and static reflector
 */
public class ArmyM3Enigma extends AbstractEnigma {

    /**
     * Instantiates a new Model d enigma.
     *
     * @param rotors    the rotors
     * @param reflector the reflector
     */
    public ArmyM3Enigma(List<Rotor> rotors, Reflector reflector) {
        super(rotors, reflector);
    }

    public ArmyM3Enigma() {

    }

    @Override
    public int getRotorNumber() {
        return 3;
    }

    @Override
    public String toString() {
        return "Army M3";
    }
}
