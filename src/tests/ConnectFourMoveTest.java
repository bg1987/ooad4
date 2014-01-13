package tests;

import static org.junit.Assert.*;
import ooad4.connectfour.ConnectFourMove;

import org.junit.Test;

public class ConnectFourMoveTest {

	private ConnectFourMove move;
	
	@Test(expected=IllegalArgumentException.class)
	public void testConnectFourMove_NullOwner() {
		move = new ConnectFourMove(null, 0);
	}
	
	@Test
	public void testConnectFourMove_Basic()
	{
		move = new ConnectFourMove(new PlayerMock(), 0);
		assertNotNull(move);
	}
	
	@Test
	public void testConnectFourMove_VerifyOwner()
	{
		move = new ConnectFourMove(new PlayerMock(), 0);
		assertNotNull(move.owner);
	}

}
