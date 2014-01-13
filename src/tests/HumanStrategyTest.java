package tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ooad4.connectfour.HumanStrategy;
import ooad4.core.Board;
import ooad4.core.Player;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HumanStrategyTest {

	
	
	private HumanStrategy humanStrat;
	private Board board;
	private Player player;
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		board = new BoardMock(1, 1);
		player = new PlayerMock();
		
		
	}

	@After
	public void tearDown() throws Exception {
		System.setIn(System.in);
		System.setOut(System.out);
		
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
	public void testNextMove_NullParams1() {
		humanStrat = HumanStrategy.getInstance();
		humanStrat.nextMove(null, null);
	}
	
	
	@Test
	public void testNextMove_NonIntInput() {
		humanStrat = HumanStrategy.getInstance(); //todo move to setup??
		
		System.setOut(new PrintStream(outContent));
		ByteArrayInputStream in = new ByteArrayInputStream("a\r\n0\r\n".getBytes());
		System.setIn(in);
		
		humanStrat.nextMove(board, player);

		String s = outContent.toString();
		assertEquals("What is your next move? [0-0]\r\nSorry, I didn't understand you. Please try again.\r\n", s);
	}
	
	@Test
	public void testNextMove_NegativeIntInput() {
		humanStrat = HumanStrategy.getInstance(); //todo move to setup??
		
		System.setOut(new PrintStream(outContent));
		ByteArrayInputStream in = new ByteArrayInputStream("-1\r\n0\r\n".getBytes());
		System.setIn(in);
		humanStrat.nextMove(board, player);
		
		String s = outContent.toString();
		assertEquals("What is your next move? [0-0]\r\nSorry, that is not on the board\r\n", s);
	}
	
	@Test
	public void testNextMove_OutofBoundsIntInput() {
		humanStrat = HumanStrategy.getInstance(); //todo move to setup??
		
		System.setOut(new PrintStream(outContent));
		ByteArrayInputStream in = new ByteArrayInputStream("11\r\n0\r\n".getBytes());
		System.setIn(in);
		humanStrat.nextMove(board, player);
		
		String s = outContent.toString();
		assertEquals("What is your next move? [0-0]\r\nSorry, that is not on the board\r\n", s);
	}
	
	@Test
	public void testNextMove_GoodInput() {
		humanStrat = HumanStrategy.getInstance(); //todo move to setup??
		
		System.setOut(new PrintStream(outContent));
		ByteArrayInputStream in = new ByteArrayInputStream("0\r\n".getBytes());
		System.setIn(in);
		humanStrat.nextMove(board, player);
		
		String s = outContent.toString();
		assertEquals("What is your next move? [0-0]\r\n", s);
	}	

	
	
	
	
}
