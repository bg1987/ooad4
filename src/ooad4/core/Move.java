package ooad4.core;


/**
 * An abstract class representing a move in the game.
 */
public abstract class Move
{
	/**
	 * The player that played this move.
	 */
	public Player owner;
	

	/**
	 * Create a new move object.
	 */
	public Move(Player owner) {
		if (owner == null)
		{
			throw new IllegalArgumentException("Move cannot get a null owner");
		}
		this.owner = owner;
	}
	
}

