package ooad4.core;


/**
 * Represents the state of the board in the game
 */
public class Board
{
	private int rows;
	
	private int columns;
	

	/**
	 * 2d array of the pieces on the board, where 0,0 represents the bottom left corner.
	 */
	protected Piece pieces[][];
	

	/**
	 * Create a new board, with the specified dimensions.
	 */
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}


	/**
	 * Return the number of rows in this board.
	 * @return number of rows.
	 */
	public int getRows() {
		return rows;
	}


	/**
	 * Return the number of columns in this board.
	 * @return number of columns.
	 */
	public int getColumns() {
		return columns;
	}


	/**
	 * Return the contents of the board in the given index.
	 * @param row of the desired piece
	 * @param column of the desired piece
	 * @return the piece in the board at the point (row, col).
	 */
	public Piece getPieces(int row,int col) {
		return pieces[row][col];
	}


	/**
	 * Set the contents of the board at the index provided to the provided piece.
	 * @param row
	 * @param col
	 * @param newPiece to be inserted into the board;
	 */
	public void setPieces(int row, int col, Piece newPiece) {
		this.pieces[row][col] = newPiece;
	}
	
}

