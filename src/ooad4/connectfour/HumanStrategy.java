package ooad4.connectfour;

import java.util.Scanner;

import ooad4.core.Board;
import ooad4.core.Move;
import ooad4.core.Player;


/**
 * A ConnectFour that gets its next move from a user.
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class HumanStrategy extends ConnectFourStrategy
{
	private static HumanStrategy instance;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	private HumanStrategy(){
		super();
	}
	
	public static HumanStrategy getInstance()
	{
		if (instance == null)
		{
			instance = new HumanStrategy();
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
		Scanner in = new Scanner (System.in);
		System.out.println ("What is your next move? [0-"+(board.getColumns()-1)+"]");
		int a = -1;
		while (!in.hasNextInt() && a != -1)
		{
			if (in.hasNextInt())
			{
				a = in.nextInt();
				if (a >= board.getColumns() )
				{
					System.out.println("Sorry, wrong column");
					continue;
				}
			}
			else
			{
				System.out.println("Sorry, couldn't understand you!");
			}
		}
		

		return new ConnectFourMove(player, a);
	}

}

