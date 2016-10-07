/**
 * A player class
 *
 * Handles the player for the game.
 * It contains the last throw and points of the player.
 */
public class Player {
	private Throw lastThrow;
	private String name;
	private int points;

	/**
	 * Instantiate the player with default values.
	 *
	 * @param name players name
	 */
	public Player(String name){
		this.name = name;
		this.points = 0;
	}

	public String getName() {
		return name;
	}

	public int getPoints() {
		return points;
	}

	/**
	 * Increases players point.
	 *
	 * @param points points to add
	 */
	public void addPoints(int points) {
		this.points += points;
	}

	/**
	 * Sets players point to <code>0</code>.
	 */
	public void resetPoints() {
		this.points = 0;
	}

	public void setLastThrow(Throw lastThrow) {
		this.lastThrow = lastThrow;
	}

	public Throw getLastThrow() {
		return lastThrow;
	}
}
