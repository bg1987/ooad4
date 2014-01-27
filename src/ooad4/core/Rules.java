package ooad4.core;


/**
 * An abstract class the determines the games logic, such as allowed moves and winning conditions.
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public abstract class Rules
{
	protected int boardRows;
	protected int boardColumns;
	 
	public int getBoardRows() {
		return boardRows;
	}
	
	public int getBoardColumns() {
		return boardColumns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Rules(int boardRows, int boardColumns){
		if (boardRows <= 0 || boardColumns <= 0) {
			throw new IllegalArgumentException("Board configured with non-positive rows or columns");
		}
		this.boardColumns = boardColumns;
		this.boardRows = boardRows;
	}

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

