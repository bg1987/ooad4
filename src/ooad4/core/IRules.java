package ooad4.core;

/**
 * Represents a set of rules for the game.
 */
public interface IRules {

	public abstract int getBoardRows();

	public abstract int getBoardColumns();

	/**
	 * Parse the given move and make changes to the board if the move is valid.
	 * @return The piece that was moved, or null if move was invalid.
	 */
	public abstract Piece parseMove(Move theMove, Board board);

	/**
	 * Check whether the game has ended.
	 * @param the board on which to check the state of the game.
	 * @return the result of the check.
	 */
	public abstract WinResult checkWin(Board board);

}