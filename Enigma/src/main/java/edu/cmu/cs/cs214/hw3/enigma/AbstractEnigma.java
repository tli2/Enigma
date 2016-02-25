package edu.cmu.cs.cs214.hw3.enigma;

import java.util.Collections;
import java.util.List;

/**
 * The boring old standard Enigma
 */
public abstract class AbstractEnigma implements Enigma {
    private List<Rotor> rotors;
    private Reflector reflector;

    /**
     * Instantiates a new Abstract enigma.
     *
     * @param rotors    the rotors
     * @param reflector the reflector
     */
    public AbstractEnigma(List<Rotor> rotors, Reflector reflector) {
        this.rotors = rotors;
        this.reflector = reflector;
    }

    /**
     * Instantiates a new Abstract enigma.
     */
    public AbstractEnigma() {

    }

    @Override
    public void construct(List<Rotor> rotors, Reflector reflector) {
        this.rotors = rotors;
        this.reflector = reflector;
    }

    @Override
    public char encode(char input) {
        RotorSignal signal = new RotorSignal(Util.translateToPositionCode(input), RotorSignal.SINGLE_STEP);
        for (Rotor rotor : rotors) {
            signal = rotor.output(signal);
        }
        signal = reflector.reflect(signal);

        Collections.reverse(rotors);

        for (Rotor rotor : rotors) {
            signal = rotor.reversedOutput(signal);
        }

        Collections.reverse(rotors);

        return Util.translateFromPositionCode(signal.getOutputPositionCode());
    }

    /**
     * Gets rotor numbers.
     *
     * @return the rotor numbers
     */
    public abstract int getRotorNumber();
}
