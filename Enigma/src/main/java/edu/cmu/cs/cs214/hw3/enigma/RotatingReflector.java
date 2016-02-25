package edu.cmu.cs.cs214.hw3.enigma;

/**
 * A Reflector that rotates every time after an input
 */
public class RotatingReflector extends StandardReflector {
    private int offset = 0;

    public RotatingReflector(String inputFile) {
        super(inputFile);
    }

    @Override
    public RotorSignal reflect(RotorSignal input) {

        int realInput = ((input.getOutputPositionCode() - offset + Util.ROTOR_LENGTH) % Util.ROTOR_LENGTH);
        int reflectedOutput = super.reflect(new RotorSignal(realInput, RotorSignal.NO_STEP)).getOutputPositionCode();
        int realOutput = (reflectedOutput + offset) % Util.ROTOR_LENGTH;
        for (int i = 0; i < input.getStep(); i++) {
            step();
        }
        return new RotorSignal(realOutput, RotorSignal.NO_STEP);
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    private void step() {
        offset = (offset + 1) % Util.ROTOR_LENGTH;
    }

    @Override
    public String toString() {
        return super.toString() + " rotating";
    }
}
