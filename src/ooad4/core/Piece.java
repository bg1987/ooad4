package ooad4.core;


/**
 * An abstract class that represents a single piece on the game board.
 */
public abstract class Piece
{
	
	/**
	 * The player who owns this piece.
	 * Read-only
	 */
	protected Player owner;
	
	/**
	 * the coordinates this piece is on.
	 * Read-only
	 */
	protected int row, column;
	
	public Player getOwner()
	{
		return this.owner;
	}
	
	public int getRow()
	{
		return this.row;
	}
	
	public int getColumn()
	{
		return this.column;
	}
	

	/**
	 * Create a new piece, given the player to which this piece belongs, 
	 * and its coordinates on the board.
	 */
	public Piece(Player owner, int row, int column) {
		if (owner == null)
		{
			throw new IllegalArgumentException("Owner cannot be null");
		}

		this.owner = owner;
		this.row = row;
		this.column = column;
	}
	
}

