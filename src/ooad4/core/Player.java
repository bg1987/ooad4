package ooad4.core;


/**
 * Represents a player in the game, either human or an AI.
 */
public class Player
{	
	/**
	 * The strategy used by this player.
	 */
	public Strategy strategy;
	

	/**
	 * Create a new player that uses the given strategy to choose their moves.
	 */
	public Player(Strategy strategy) {
		this.strategy = strategy; 
	}


	/**
	 * Decide what move to play next.
	 * @param the board on which to play the next move.
	 * @return The next move that the player would like to play.
	 */
	public Move getMove(Board board) {
		return strategy.nextMove(board, this);
	}
	
}

