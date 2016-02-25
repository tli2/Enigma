package edu.cmu.cs.cs214.hw3.enigma;

import java.util.*;

/**
 * A standard rotor
 */
public class StandardRotor implements Rotor {
    private final Map<Integer, Integer> inputWiring;
    private final Map<Integer, Integer> reversedInputWiring;
    private int offset;
    private final Set<Character> turnover;
    private RotorSignal prevInput;
    private String name;


    /**
     * Instantiates a new Standard rotor.
     *
     * @param wiringFile the wiring file
     * @throws IllegalArgumentException the illegal argument exception
     */
    public StandardRotor(String wiringFile) throws IllegalArgumentException {
        inputWiring = new HashMap<>();
        reversedInputWiring = new HashMap<>();
        turnover = new HashSet<>();
        offset = 0;
        name = Util.parseWiringFile(wiringFile, inputWiring, reversedInputWiring, turnover);
    }

    @Override
    public RotorSignal output(RotorSignal input) {
        assert (prevInput == null);
        prevInput = input;
        int positionCode = genericOutput(input.getOutputPositionCode(), inputWiring);
        if (turnover.contains(Util.translateFromPositionCode(offset)) && prevInput.getStep() == RotorSignal.SINGLE_STEP) {
            return new RotorSignal(positionCode, RotorSignal.SINGLE_STEP);
        }
        return new RotorSignal(positionCode, RotorSignal.NO_STEP);
    }

    @Override
    public RotorSignal reversedOutput(RotorSignal input) {
        assert (prevInput != null);
        int positionCode =  genericOutput(input.getOutputPositionCode(), reversedInputWiring);
        for (int i = 0; i < prevInput.getStep(); i ++) {
            step();
        }
        prevInput = null;
        return new RotorSignal(positionCode, RotorSignal.NO_STEP);
    }

    @Override
    public int getCurrentPosition() {
        return offset;
    }

    @Override
    public void setCurrentPosition(int position) {
        offset = position;
    }

    @Override
    public String toString() {
        return name;
    }

    private void step() {
        offset = (offset + 1) % Util.ROTOR_LENGTH;
    }

    private int genericOutput(int input, Map<Integer, Integer> inputWiring) {
        int charInput = (input + offset) % Util.ROTOR_LENGTH;
        return (inputWiring.get(charInput) - offset + Util.ROTOR_LENGTH) % Util.ROTOR_LENGTH;
    }


}
