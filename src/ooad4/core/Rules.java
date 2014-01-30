package ooad4.core;


/**
 * An abstract class the determines the games logic, such as allowed moves and winning conditions.
 */
public abstract class Rules implements IRules
{
	protected int boardRows;
	protected int boardColumns;
	 
	/* (non-Javadoc)
	 * @see ooad4.core.IRules#getBoardRows()
	 */
	@Override
	public int getBoardRows() {
		return boardRows;
	}
	
	/* (non-Javadoc)
	 * @see ooad4.core.IRules#getBoardColumns()
	 */
	@Override
	public int getBoardColumns() {
		return boardColumns;
	}

	/**
	 * Create a new set of rules, given the size of the board that will be played on.
	 */
	public Rules(int boardRows, int boardColumns){
		if (boardRows <= 0 || boardColumns <= 0) {
			throw new IllegalArgumentException("Board configured with non-positive rows or columns");
		}
		this.boardColumns = boardColumns;
		this.boardRows = boardRows;
	}

	/* (non-Javadoc)
	 * @see ooad4.core.IRules#parseMove(ooad4.core.Move, ooad4.core.Board)
	 */
	
	@Override
	public abstract Piece parseMove(Move theMove, Board board);
	
	/* (non-Javadoc)
	 * @see ooad4.core.IRules#checkWin(ooad4.core.Board)
	 */
	
	@Override
	public abstract WinResult checkWin(Board board);


	
}

