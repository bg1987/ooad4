package ooad4.connectfour;
import ooad4.core.Board;
import ooad4.core.IllegalMoveExcetion;
import ooad4.core.InvalidMoveException;
import ooad4.core.Move;
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
		if (board.getPieces(board.getRows(), column) != null)
		{
			throw new IllegalMoveExcetion("selected column is full");
		}
		
		
		//put new disc in the lowest possible empty place on the board.
		for (int i = 0; i < boardRows; i++) 
		{
			if (board.getPieces(i, column) != null) 
			{
				Disc newPiece = new Disc(theMove.owner);
				board.setPieces(i, column, newPiece);
				break;
			}
		}

	}

	@Override
	public WinResult checkWin(Board board) {
		// TODO Auto-generated method stub
		return null;
	}

}

