package tests;

import static org.junit.Assert.*;
import ooad4.core.Board;
import ooad4.core.Game;
import ooad4.core.GameEndedUnexpectedlyException;
import ooad4.core.Move;
import ooad4.core.Player;
import ooad4.connectfour.ConnectFourMove;
import ooad4.connectfour.ConnectFourRules;

import org.junit.Test;

public class GameTest {

	private Game game;
	
	@Test(expected=IllegalArgumentException.class)
	public void testGame_NullArgument() {
		game = new Game(null, null, null);
	}
	
	@Test
	public void testGame_BasicConstruction()
	{
		game = new Game(new PlayerMock(), new PlayerMock(1), new ConnectFourRules());
		assertNotNull(game);
	}
	

	@Test
	public void testPlay_Player1Win() {
		Player player1 = new PlayerMock();
		Player player2 = new PlayerMock(1);
		game = new Game(player1, player2, new ConnectFourRules());
		try
		{
			Player winner = game.play();
			assertEquals(winner, player1);
		}
		catch (Exception e)
		{
			fail("Game ended in an exception");
		}
	}
	
	@Test
	public void testPlay_Tie() {
		Player player1 = new PlayerMock();
		Player player2 = new PlayerMock(1);
		game = new Game(player1, player2, new ConnectFourRules(1,1));
		try
		{
			Player winner = game.play();
			assertEquals(winner, null);
		}
		catch (Exception e)
		{
			fail("Game ended in an exception");
		}
	}

	@Test(expected=GameEndedUnexpectedlyException.class)
	public void testPlay_IllegalMoves() throws GameEndedUnexpectedlyException {
		Player player1 = new PlayerMock(-1);
		Player player2 = new PlayerMock(1);
		
		game = new Game(player1, player2, new ConnectFourRules());
		game.play();
	}
	
	//This strategy will send one illegal move, and then send a good one when prompted again.
	private class TestStrategy extends StrategyMock
	{
		private boolean firstTime = true;
		public TestStrategy() 
		{
			super();
		}
		
		@Override
		public Move nextMove(Board board, Player player) {
			//Return an illegal move on the first time this function is called
			if (firstTime == true)
			{
				firstTime = false;
				return new ConnectFourMove(player, -1);
			}
			return new ConnectFourMove(player,this.move); 
		}
	}
	
	@Test
	public void testPlay_OneIllegalMove() {
		Player player1 = new Player(new TestStrategy());
		Player player2 = new PlayerMock(1);
		game = new Game(player1, player2, new ConnectFourRules());
		try
		{
			Player winner = game.play();
			assertEquals(winner, player1);
		}
		catch (Exception e)
		{
			fail("Game ended in an exception");
		}
	}
	
}
