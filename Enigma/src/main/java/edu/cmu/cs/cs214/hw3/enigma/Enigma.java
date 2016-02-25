package edu.cmu.cs.cs214.hw3.enigma;

import java.util.List;

/**
 * The interface of an Enigma machine, for the purpose of this assignment, we arbitrarily fix the alphabet to be
 * the 26 capital English letters plus the 10 digits.
 */
public interface Enigma {
    /**
     * Encode a character input, must be alphanumeric.
     *
     * @param input the input
     * @return the encoded char
     */
    char encode(char input);

    int getRotorNumber();

    void construct(List<Rotor> rotors, Reflector reflector);

    @Override
    String toString();
}
