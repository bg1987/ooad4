package ooad4.connectfour;
import ooad4.core.Board;
import ooad4.core.IllegalMoveExcetion;
import ooad4.core.InvalidMoveException;
import ooad4.core.Move;
import ooad4.core.Player;
import ooad4.core.Rules;
import ooad4.core.WinResult;


/**
 * A concrete implementation of the rules of the Connect Four game
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class ConnectFourRules extends Rules
{
	private int lastRow = -1;
	private int lastCol = -1;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public ConnectFourRules(int rows,int cols){
		super(rows,cols);
	}
	

	@Override
	public void parseMove(Move theMove, Board board) throws InvalidMoveException, IllegalMoveExcetion {
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
			throw new InvalidMoveException("selected column doesn't exist");
		}
		if (board.getPieces(board.getRows()-1, column) != null)
		{
			throw new IllegalMoveExcetion("selected column is full");
		}
		
		
		//put new disc in the lowest possible empty place on the board.
		for (int i = 0; i < boardRows; i++) 
		{
			if (board.getPieces(i, column) == null) 
			{
				Disc newPiece = new Disc(theMove.owner);
				board.setPieces(i, column, newPiece);
				lastRow = i;
				lastCol = column;
				break;
			}
		}

	}

	@Override
	public WinResult checkWin(Board board) {
		if (board == null) {
			throw new IllegalArgumentException("Board is null");
		}
		
		Player owner = board.getPieces(lastRow, lastCol).owner; //TODO: does this break LSP? the 2 dots things.
		int discCount = 0;
		//check for horizontal 4s.
			//west
		discCount += countConsecutiveDiscs(board, owner, lastRow, lastCol, 0, -1);
			//east
		discCount += countConsecutiveDiscs(board, owner, lastRow, lastCol, 0, 1);
		if (discCount >= 4)
		{
			return WinResult.Won;
		}
		else
		{
			discCount = 0;
		}
		//check for vertical 4s.
			//north
		discCount += countConsecutiveDiscs(board, owner, lastRow, lastCol, 1, 0);
			//south
		discCount += countConsecutiveDiscs(board, owner, lastRow, lastCol, -1, 0);
		if (discCount >= 4)
		{
			return WinResult.Won;
		}
		else
		{
			discCount = 0;
		}
		
		//check for diagonal 4s.
			//west
		discCount += countConsecutiveDiscs(board, owner, lastRow, lastCol, -1, -1);
			//east
		discCount += countConsecutiveDiscs(board, owner, lastRow, lastCol, 1, 1);
		if (discCount >= 4)
		{
			return WinResult.Won;
		}
		else
		{
			return isBoardFull(board) ? WinResult.Tie : WinResult.None;
		}
		
	}
	
	//goes in the direction defined by rowInc and rowCol and counts all the discs in the board which are owned by owner.
	private int countConsecutiveDiscs(Board board, Player owner, int startRow,int startCol, int rowInc,int colInc)
	{
		//TODO:Validate stuff
		int count = 0;
		
		int curRow = startRow;
		int curCol = startCol;
		
		while((curCol < boardColumns && curCol >= 0) && (curRow < boardRows && curRow >= 0) && board.getPieces(curRow, curCol) != null && board.getPieces(curRow, curCol).owner == owner)
		{
			count++;
			curRow += rowInc;
			curCol += colInc;
		}
		
		return  count;
	}

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

