package edu.cmu.cs.cs214.hw3.enigma;

/**
 * The reflector that creates a pairwise circuit between inputs, makes the Enigma self-reciprocal
 */
public interface Reflector {
    /**
     * Reflect int.
     *
     * @param input the input
     * @return the int
     */
    RotorSignal reflect(RotorSignal input);

    @Override
    String toString();
}
