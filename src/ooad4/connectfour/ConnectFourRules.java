package ooad4.connectfour;
import ooad4.core.Board;
import ooad4.core.Move;
import ooad4.core.Piece;
import ooad4.core.Player;
import ooad4.core.Rules;
import ooad4.core.WinResult;


/**
 * A concrete implementation of the rules of the Connect Four game
 */
public class ConnectFourRules extends Rules
{
	//Remember the last move parsed by parseMove in order to use in checkWin
	private Piece lastPiece = null;
	
	private static final int defaultColumns = 7;
	private static final int defaultRows = 6;
	private static final int numToWin = 4;
	
	/**
	 * Create a ConnectFourRules instance with the given board size.
	 */
	public ConnectFourRules(int rows,int cols){
		super(rows,cols);
	}
	
	/**
	 * Create a ConnectFourRules instance with the default board size.
	 */
	public ConnectFourRules()
	{
		super(defaultRows,defaultColumns);
	}
	

	@Override
	public Piece parseMove(Move theMove, Board board){

		//Make sure that input is valid, and extract the valid column number from the given move.
		if (!validateInput(theMove, board))
		{
			lastPiece = null;
			return null;
		}
		
		int column = ((ConnectFourMove)theMove).column;
		
		//put new disc in the lowest possible empty place on the board.
		for (int i = 0; i < boardRows; i++) 
		{
			if (board.getPieces(i, column) == null) 
			{
				Disc newPiece = new Disc(theMove.owner, i, column);
				board.setPieces(i, column, newPiece);
				lastPiece = newPiece;
				break;
			}
		}
		
		return lastPiece;

	}
	
	/**
	 * Helper function for parseMove. 
	 * Checks that the given input is valid, and extracts the column number if the move is valid
	 * @param theMove
	 * @param board
	 * @return True if and only if the given move is valid.
	 */
	private boolean validateInput(Move theMove, Board board)
	{
		if (theMove == null || board == null) {
			throw new IllegalArgumentException("Move or Board were null");
		}
		if (!(theMove instanceof ConnectFourMove))
		{
			throw new IllegalArgumentException("Wrong move type");
		}
		if (boardColumns != board.getColumns() || boardRows != board.getRows() )
		{
			throw new IllegalArgumentException("wrong board size");
		}
		
		int column = ((ConnectFourMove)theMove).column;
		if ((column > board.getColumns()-1) || (column < 0))
		{
			return false;
		}
		if (board.getPieces(board.getRows()-1, column) != null)
		{
			return false;
		}
		
		return true;
	}

	@Override
	public WinResult checkWin(Board board) {
		if (board == null) {
			throw new IllegalArgumentException("Board is null");
		}
		
		if (lastPiece == null)
		{
			throw new IllegalArgumentException("checkWin must be called after a legal move has been made.");
		}
		
		int lastRow = lastPiece.getRow();
		int lastCol = lastPiece.getColumn();
		Player owner = lastPiece.getOwner();
		
		//check for horizontal win
		int discCount = 0;
		discCount += countConsecutiveDiscs(board, owner, lastRow, lastCol, 0, -1);
		if (discCount >= numToWin)
		{
			return WinResult.Won;
		}
		
		//check for vertical win
		discCount = 0;
		discCount += countConsecutiveDiscs(board, owner, lastRow, lastCol, -1, 0);
		if (discCount >= numToWin)
		{
			return WinResult.Won;
		}
		
		//check for diagonal win
		discCount = 0;
		discCount += countConsecutiveDiscs(board, owner, lastRow, lastCol, -1, -1);
		if (discCount >= numToWin)
		{
			return WinResult.Won;
		}

		//No one won. Check whether there is a tie.
		return isBoardFull(board) ? WinResult.Tie : WinResult.None;
		
	}
	
	/**
	 * Goes in the direction defined by rowInc and rowCol and counts all the discs in the board
	 * which are owned by owner.
	 * @param board
	 * @param owner
	 * @param startRow
	 * @param startCol
	 * @param rowInc
	 * @param colInc
	 * @return number of consecutive discs belonging to the given player, 
	 * 		starting at the given location, going in the specified direction.
	 */
	private int countConsecutiveDiscs(Board board, Player owner, int startRow,int startCol, int rowInc,int colInc)
	{
		int count = 0;
		
		int curRow = startRow;
		int curCol = startCol;
		
		while(isSameOwner(board, curCol, curRow, owner))
		{
			curRow += rowInc;
			curCol += colInc;
		}
		
		curRow -= rowInc;
		curCol -= colInc;
		while(isSameOwner(board, curCol, curRow, owner))
		{
			count++;
			curRow -= rowInc;
			curCol -= colInc;
		}
		
		return  count;
	}
	
	/**
	 * Helper function for countConsecutiveDiscs.
	 * Checks whether there is a disc at the given location on the board, 
	 * and if so, whether it belongs to the right player.
	 * @param board
	 * @param column
	 * @param row
	 * @param owner
	 * @return True if and only if the disc at the given location belongs to the given player.
	 */
	private boolean isSameOwner(Board board, int column,int row, Player owner)
	{
		return (column<boardColumns && column >= 0 &&
				row < boardRows && row >= 0 &&
				board.getPieces(row, column) != null &&
				board.getPieces(row, column).getOwner() == owner);
	}

	/**
	 * Checks whether the board is full.
	 * This is used to check whether there is a tie.
	 * @param board
	 * @return True if and only if the board is full.
	 */
	private boolean isBoardFull(Board board)
	{
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				if (board.getPieces(i, j) == null) {
					return false;
				}
			}
		}
		return true;
	}
}

