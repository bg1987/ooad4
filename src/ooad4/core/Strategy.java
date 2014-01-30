package ooad4.core;



/**
 * The "Intelligence" of the player.
 * Defines a method that will determine the next move.
 */
public  interface Strategy 
{
	/**
	 * Decide the next move to be played.
	 * @param the board to play on
	 * @param the player the needs to make a move
	 * @return the move chosen to be played.
	 */
	public Move nextMove(Board board, Player player) ;
	
	
}

