import desktop_resources.GUI;

/**
 * Game class
 *
 * Contains players and handles game actions.
 */
public class Game {
	private Player[] players;

	/**
	 * Adds the players in the game.
	 *
	 * @param players players to add in game.
	 */
	public Game(Player[] players){
		this.players = players;
	}

	/**
	 * Takes a turn for the given player, and checks if they win.
	 *
	 * @param player player to take turn.
	 * @return boolean if the player won.
	 */
	private boolean takeTurn(Player player){
		GUI.showMessage("It is now "+player.getName()+"'s turn."+System.lineSeparator()+"Press OK, to roll the dice. ;-))");

		Throw currentThrow = new Throw();
		player.addPoints(currentThrow.sum());

		if(currentThrow.sum() == 2){
			player.resetPoints();
		}

		GUI.setBalance(player.getName(), player.getPoints());

		if(player.getLastThrow() != null && currentThrow.sum() == 12 && player.getLastThrow().sum() == 12){
			return true;
		}

		player.setLastThrow(currentThrow);

		if(currentThrow.isSame()) {
			return player.getPoints() >= 40 || this.takeTurn(player);
		}
		return false;
	}

	/**
	 * Starts the game :DD
	 */
	public void start(){
		while (!round()){}
	}

	/**
	 * Plays a round of the game and true if a player won.
	 *
	 * @return true if won
	 */
	private boolean round() {
		for (Player player: players) {
			if(takeTurn(player)){
				GUI.showMessage(player.getName()+" won! :DDD");
				GUI.close();
				return true;
			}
		}
		return false;
	}
}
