
import desktop_fields.*;
import desktop_resources.*;

/**
 * Class to handle the GUI
 */
public class DiceGUI {

	public static void main(String[] args) {
		Player player1 = new Player("Player 1");
		Player player2 = new Player("Player 2");

		Game game = new Game(new Player[]{player1, player2});

		createEmptyBoard();
		GUI.addPlayer(player1.getName(), player1.getPoints());
		GUI.addPlayer(player2.getName(), player2.getPoints());

		GUI.showMessage("Press OK, to start the game");
		game.start();
	}


	/**
	 * Creates the board without monopoly ;)
	 */
	private static void createEmptyBoard() {
		Field[] fields = new Field[40];
		for (int i = 0; i < fields.length ; i++) {
			fields[i] = new Empty.Builder().build();
		}
		GUI.create(fields);
	}
}
