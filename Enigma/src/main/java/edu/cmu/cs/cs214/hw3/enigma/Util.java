package edu.cmu.cs.cs214.hw3.enigma;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.Set;

/**
 * Utility functions for our Enigma implementation, only works with the defined alphabet
 */
public final class Util {
    /**
     * The constant ROTOR_LENGTH.
     */
    public static final int ROTOR_LENGTH = 26;

    private Util() {
        //Should not be instantiated
    }

    /**
     * Translate from position code to a printable character.
     *
     * @param positionCode the position code
     * @return the char
     * @throws IllegalArgumentException the illegal argument exception
     */
    public static char translateFromPositionCode(int positionCode) throws IllegalArgumentException {
        if (positionCode < 0 || positionCode >= ROTOR_LENGTH) {
            throw new IllegalArgumentException("position code out of bounds");
        }
        return (char) (positionCode + 'A');
    }

    /**
     * Translate to position code from a printable character.
     *
     * @param signal the signal
     * @return the int
     * @throws IllegalArgumentException the illegal argument exception
     */
    public static int translateToPositionCode(char signal) throws IllegalArgumentException {
        if (signal < 'A' || signal > 'Z') {
            throw new IllegalArgumentException("input character not legal");
        }
        return signal - 'A';
    }

    public static String parseWiringFile(String wiringFile, Map<Integer, Integer> inputWiring,
                                         Map<Integer, Integer> reversedInputWiring, Set<Character> turnover) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(wiringFile));
            String result = reader.readLine();
            String wiring = reader.readLine();
            String turn = reader.readLine();
            for (int i = 0; i < wiring.length(); i++) {
                inputWiring.put(i, Util.translateToPositionCode(wiring.charAt(i)));
            }

            if (reversedInputWiring != null) {
                inputWiring.entrySet().forEach(a -> reversedInputWiring.put(a.getValue(), a.getKey()));
            }

            if (turnover != null) {
                for (int i = 0; i < turn.length(); i++) {
                    turnover.add(turn.charAt(i));
                }
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
