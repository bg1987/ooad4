package tests;

import static org.junit.Assert.*;

import ooad4.connectfour.HumanStrategy;
import ooad4.core.Board;
import ooad4.core.Player;
import ooad4.core.Strategy;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HumanStrategyTest {
	private class mockBoard extends Board
	{

		public mockBoard(int rows, int columns) {
			super(rows, columns);
			// TODO Auto-generated constructor stub
		}
		
	}
	
	private class mockPlayer extends Player
	{

		public mockPlayer(Strategy strategy) {
			super(strategy);
			// TODO Auto-generated constructor stub
		}
		
	}
	
	
	private HumanStrategy humanStrat;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetInstance_Basic() {
		humanStrat = HumanStrategy.getInstance();
		System.out.println(humanStrat.hashCode());
		assertNotNull(humanStrat);
	}
	
	@Test
	public void testGetInstance_IdenticalObjects() {
		humanStrat = HumanStrategy.getInstance();
		assertEquals(humanStrat, HumanStrategy.getInstance());
	}
	

	@Test(expected=IllegalArgumentException.class)
	public void testNextMove_NullParams() {
		humanStrat = HumanStrategy.getInstance();
		humanStrat.nextMove(null, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNextMove_NonIntInput() {
		humanStrat = HumanStrategy.getInstance();
	}
	
	
}
