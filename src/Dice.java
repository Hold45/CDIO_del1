import java.util.Random;

/**
 * A Dice class
 *
 * This class is for rolling a dice and getting some information about the dice.
 */
public class Dice {
    private int value;

    /**
     * Rolls the dice and return it's face.
     *
     * @return int
     */
    public int roll() {
        Random random = new Random();
	    this.value = random.nextInt(6)+1;
        return this.value;
    }

	/**
	 * Returns the value of the die.
	 *
	 * @return value
	 */
	public int getValue() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Dice && ((Dice) obj).getValue() == this.getValue();
	}

}
