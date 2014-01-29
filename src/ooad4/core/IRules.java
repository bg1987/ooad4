package ooad4.core;

public interface IRules {

	public abstract int getBoardRows();

	public abstract int getBoardColumns();

	/**
	 * Parse the given move and make changes to the board if the move is valid.
	 * @return The piece that was moved, or null if move was invalid.
	 */

	public abstract Piece parseMove(Move theMove, Board board);

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	public abstract WinResult checkWin(Board board);

}