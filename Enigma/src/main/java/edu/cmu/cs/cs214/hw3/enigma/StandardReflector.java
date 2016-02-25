package edu.cmu.cs.cs214.hw3.enigma;

import java.util.HashMap;
import java.util.Map;

/**
 * Standard reflector that reflects the letters symmetrically
 */
public class StandardReflector implements Reflector {
    private Map<Integer, Integer> inputWiring;
    private String name;

    public StandardReflector(String inputFile) {
        inputWiring = new HashMap<>();
        name = Util.parseWiringFile(inputFile, inputWiring, null, null);
    }

    @Override
    public RotorSignal reflect(RotorSignal input) {
        int positionCode = inputWiring.get(input.getOutputPositionCode());
        return new RotorSignal(positionCode, RotorSignal.NO_STEP);
    }

    @Override
    public String toString() {
        return name;
    }
}
