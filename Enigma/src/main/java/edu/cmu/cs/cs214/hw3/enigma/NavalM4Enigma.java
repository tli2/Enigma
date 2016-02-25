package edu.cmu.cs.cs214.hw3.enigma;

import java.util.List;

/**
 * The class that imitates the Naval M4 model Enigma, 4 rotors and a rotating reflector
 */
public class NavalM4Enigma extends AbstractEnigma {

    /**
     * Instantiates a new Naval m 4 enigma.
     *
     * @param rotors    the rotors
     * @param reflector the reflector
     */
    public NavalM4Enigma(List<Rotor> rotors, Reflector reflector) {
        super(rotors, reflector);
    }

    public NavalM4Enigma() {

    }

    @Override
    public int getRotorNumber() {
        return 4;
    }

    @Override
    public String toString() {
        return "Naval M4";
    }
}
