package ooad4.connectfour;
import ooad4.core.Player;
import ooad4.core.Move;


/**
 * A concrete move in the ConnectFour game.
 */

public class ConnectFourMove extends Move
{
	/**
	 * The column that the player picked
	 */
	public int column;
	

	/**
	 * Create a ConnectFourMove object with the given player and column.
	 */
	public ConnectFourMove(Player owner, int column) {
		super(owner);
		this.column = column;
	}
	
}

