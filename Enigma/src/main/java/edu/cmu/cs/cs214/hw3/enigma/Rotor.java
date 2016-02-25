package edu.cmu.cs.cs214.hw3.enigma;

/**
 * The rotor wheel that is the heart of Enigma
 */
public interface Rotor {
    /**
     * scramble and output.
     *
     * @param input the input
     * @return the int
     */
    RotorSignal output(RotorSignal input);

    /**
     * scramble and output from the other direction.
     *
     * @param input the input
     * @return the int
     */
    RotorSignal reversedOutput(RotorSignal input);

    /**
     * Gets the current position for the rotor.
     *
     * @return the current position
     */
    int getCurrentPosition();

    /**
     * Sets current position.
     *
     * @param position the position
     */
    void setCurrentPosition(int position);


}
