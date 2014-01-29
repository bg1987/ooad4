package ooad4.consolegui;

import java.util.Random;

import ooad4.connectfour.ConnectFourMove;
import ooad4.connectfour.ConnectFourStrategy;
import ooad4.core.Board;
import ooad4.core.Move;
import ooad4.core.Player;


/**
 * A ConnectFour strategy that randomly selects a valid column to drop a disc into.
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class RandomStrategy extends ConnectFourStrategy
{
	private static RandomStrategy instance;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	private RandomStrategy(){
		super();
	}
	
	public static RandomStrategy getInstance()
	{
		if (instance == null)
		{
			instance = new RandomStrategy();
		}
		return instance;
	}
	
	@Override
	public Move nextMove(Board board, Player player) 
	
	{
		if (board == null || player == null)
		{
			throw new IllegalArgumentException("board or player are null");
		}
		Random rnd = new Random();
		return new ConnectFourMove(player, rnd.nextInt(board.getColumns()));
	}

}

