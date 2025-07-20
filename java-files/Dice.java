import java.util.Random;

/**
 * The Dice class simulates a single six-sided die.
 */
public class Dice {
    private Random random;

    /**
     * Constructor for the Dice class.
     * Initializes the Random object.
     */
    public Dice() {
        this.random = new Random();
    }

    /**
     * Rolls the die and returns the result.
     * @return An integer between 1 and 6 (inclusive).
     */
    public int roll() {
        // The bound is exclusive, so we add 1 to get a range of 1-6.
        return random.nextInt(6) + 1;
    }
}

