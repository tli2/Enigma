package edu.cmu.cs.cs214.hw3.enigma;

/**
 * Created by Tianyu on 1/23/16.
 */
public class RotorSignal {
    private final int outputPositionCode, step;
    /**
     * The constant NO_STEP.
     */
    public static final int NO_STEP = 0;
    /**
     * The constant SINGLE_STEP.
     */
    public static final int SINGLE_STEP = 1;


    /**
     * Instantiates a new Rotor signal.
     *
     * @param outputPositionCode the output position code
     * @param step               the step
     */
    public RotorSignal(int outputPositionCode, int step) {
        this.outputPositionCode = outputPositionCode;
        this.step = step;
    }

    /**
     * Gets output position code.
     *
     * @return the output position code
     */
    public int getOutputPositionCode() {
        return outputPositionCode;
    }

    /**
     * Gets current rotor offset.
     *
     * @return the current rotor offset
     */
    public int getStep() {
        return step;
    }
}
