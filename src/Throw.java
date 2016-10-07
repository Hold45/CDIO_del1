import desktop_resources.GUI;

import java.util.stream.Stream;

/**
 * A class to handle a throw.
 */
public class Throw {
    private Dice[] dices;

	/**
	 * Instantiate the throw and rolls two dice.
	 */
	public Throw() {
        this.dices = new Dice[2];
	    for (int i = 0; i < dices.length; i++)
		    this.dices[i] = new Dice();
	    this.roll();
    }

	/**
	 * Rolls the dice.
	 */
	private void roll(){
	    Stream.of(dices).forEach(Dice::roll);
	    GUI.setDice(dices[0].getValue(), dices[1].getValue());
    }

	/**
	 * Checks whether the dice are the same.
	 *
	 * @return boolean if dice are the same
	 */
	public boolean isSame(){
		return dices[0].equals(dices[1]);
	}

	/**
	 * Calculates the sum of the dice.
	 *
	 * @return sum of dice
	 */
	public int sum(){
		return Stream.of(dices).mapToInt(Dice::getValue).sum();
	}

}
