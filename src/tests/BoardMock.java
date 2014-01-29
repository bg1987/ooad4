package tests;

import ooad4.core.Board;
import ooad4.core.Piece;

public class BoardMock extends Board {

	public BoardMock(int rows, int columns) {
		super(rows, columns);
	}
	
	public BoardMock(int rows, int columns, Piece[][] board)
	{
		super(rows, columns);
		this.pieces = board;
	}

}
