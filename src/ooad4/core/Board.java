package ooad4.core;
import java.util.Set;
import java.util.HashSet;


/**
 * Represents the state of the board in the game
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Board
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private int rows;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private int columns;
	

	/**
	 * <!-- begin-user-doc -->
	 * 2d array of the pieces on the board, where 0,0 represents the bottom left corner.
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private Piece pieces[][];
	

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Board(int rows, int columns) {
		this.setRows(rows);
		this.setColumns(columns);
	}


	public int getRows() {
		return rows;
	}


	public void setRows(int rows) {
		this.rows = rows;
	}


	public int getColumns() {
		return columns;
	}


	public void setColumns(int columns) {
		this.columns = columns;
	}


	public Piece getPieces(int row,int col) {
		return pieces[row][col];
	}


	public void setPieces(int row, int col, Piece newPiece) {
		this.pieces[row][col] = newPiece;
	}
	
}

