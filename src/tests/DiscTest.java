package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ooad4.connectfour.Disc;
import ooad4.core.Player;

public class DiscTest {

	private Disc disc;
	
	@Test(expected=IllegalArgumentException.class)
	public void testDisc_NullOwner() {
		disc = new Disc(null, 0, 0);
	}

	@Test
	public void testDisc_Basic()
	{
		Player owner = new PlayerMock();
		disc = new Disc(owner, 0, 0);
		assertNotNull("Disc created successfully", disc);
	}
	
	@Test
	public void testDisc_VerifyOwner()
	{
		Player owner = new PlayerMock();
		disc = new Disc(owner, 0, 0);
		assertNotNull("Disc created successfully", disc.getOwner());
	}

}
