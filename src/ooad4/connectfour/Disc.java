package ooad4.connectfour;
import ooad4.core.Player;
import ooad4.core.Piece;


/**
 * A concrete class that represents a single disc in a ConnectFour game.
 */
public class Disc extends Piece
{

	/**
	 * Create a new Disc on for a connect four game,
	 * with the given player and coordinates.
	 */
	public Disc(Player owner, int row, int column) {
		super(owner, row, column);
	}
	
}

