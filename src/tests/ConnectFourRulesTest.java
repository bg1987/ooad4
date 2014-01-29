package tests;

import org.junit.Test;

import static org.junit.Assert.*;
import ooad4.connectfour.ConnectFourMove;
import ooad4.connectfour.ConnectFourRules;
import ooad4.connectfour.Disc;
import ooad4.core.Board;
import ooad4.core.Piece;
import ooad4.core.Player;
import ooad4.core.WinResult;

public class ConnectFourRulesTest {

	private ConnectFourRules rules;
	
	@Test(expected=IllegalArgumentException.class)
	public void testConnectFourRules_NegativeSize() {
		rules = new ConnectFourRules(-1, 0);
	}
	
	@Test
	public void testConnectFourRules_BasicInit()
	{
		rules = new ConnectFourRules(6, 7);
		assertNotNull(rules);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConnectFourRules_ParseMoveNullArgs()
	{
		rules = new ConnectFourRules(6,7);
		rules.parseMove(null, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConnectFourRules_ParseMoveBadBoardSize()
	{
		rules = new ConnectFourRules(6,7);
		Player player = new PlayerMock();
		Board badBoard = new BoardMock(5,5);
		rules.parseMove(new ConnectFourMove(player, 1), badBoard);
	}
	
	@Test
	public void testConnectFourRules_ParseMoveColumnOutOfBounds()
	{
		rules = new ConnectFourRules(6,7);
		Player player = new PlayerMock();
		Board board = new BoardMock(6,7);
		Piece piece = rules.parseMove(new ConnectFourMove(player, -1), board);
		assertNull(piece);
	}
	
	@Test
	public void testConnectFourRules_ParseMoveFullColumn()
	{
		rules = new ConnectFourRules(1,1);
		Player player = new PlayerMock();
		Piece[][] filledBoard = new Disc[1][1];
		filledBoard[0][0] = new Disc(player,0,0);
		Board board = new BoardMock(1,1, filledBoard );
		Piece piece = rules.parseMove(new ConnectFourMove(player, 0), board);
		assertNull(piece);
	}
	
	@Test
	public void testConnectFourRules_ParseMoveGoodInput()
	{
		rules = new ConnectFourRules(6,7);
		Player player = new PlayerMock();
		Board board = new BoardMock(6,7);
		Piece piece = rules.parseMove(new ConnectFourMove(player, 1), board);
		assertNotNull(piece); //TODO change assert to check more things
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConnectFourRules_CheckWinNullBoard()
	{
		rules = new ConnectFourRules(6,7);
		rules.checkWin(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConnectFourRules_CheckWinNoLastPiece()
	{
		rules = new ConnectFourRules(6,7);
		rules.checkWin(new BoardMock(6,7));
	}
	
	@Test
	public void testConnectFourRules_CheckWinHorizontalWin()
	{
		rules = new ConnectFourRules(6,7);
		Player player = new PlayerMock();
		Piece[][] filledBoard = new Disc[6][7];
		for (int i=1; i<5;i++)
		{
			filledBoard[0][i] = new Disc(player,0,i);
		}

		Board board = new BoardMock(6,7, filledBoard);
		rules.parseMove(new ConnectFourMove(player, 0), board);
		WinResult result = rules.checkWin(board);
		assert(result == WinResult.Won);
	}
	
	@Test
	public void testConnectFourRules_CheckWinVerticalWin()
	{
		rules = new ConnectFourRules(6,7);
		Player player = new PlayerMock();
		Piece[][] filledBoard = new Disc[6][7];
		for (int i=0; i<4;i++)
		{
			filledBoard[i][0] = new Disc(player,i,0);
		}

		Board board = new BoardMock(6,7, filledBoard);
		rules.parseMove(new ConnectFourMove(player, 0), board);
		WinResult result = rules.checkWin(board);
		assert(result == WinResult.Won);
	}
	
	@Test
	public void testConnectFourRules_CheckWinDiagonalWin()
	{
		rules = new ConnectFourRules(6,7);
		Player player1 = new PlayerMock();
		Player player2 = new PlayerMock();
		Piece[][] filledBoard = new Disc[6][7];
		//fill the board to give player1 a diagonal win.
		for (int i=0; i<3;i++)
		{
			filledBoard[i][3] = new Disc(player2,i,3);
		}
		filledBoard[3][3] = new Disc(player1, 3, 3);
		
		for (int i=0; i<2;i++)
		{
			filledBoard[i][2] = new Disc(player2,i,2);
		}
		filledBoard[2][2] = new Disc(player1, 2, 2);
		
		filledBoard[0][1] = new Disc(player2, 0, 1);
		filledBoard[1][1] = new Disc(player1, 1, 1);

		Board board = new BoardMock(6,7, filledBoard);
		rules.parseMove(new ConnectFourMove(player1, 0), board);
		WinResult result = rules.checkWin(board);
		assert(result == WinResult.Won);
	}
}
