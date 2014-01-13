package ooad4.core;


/**
 * An abstract class that represents a single piece on the game board.
 */
public abstract class Piece
{
	
	/**
	 * The player who owns this piece.
	 */
	public Player owner;
	

	/**
	 * Create a new piece, given the player to which this piece belongs.
	 */
	public Piece(Player owner) {
		if (owner == null)
		{
			throw new IllegalArgumentException("Owner cannot be null");
		}

		this.owner = owner;
	}
	
}

