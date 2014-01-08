package ooad4.connectfour;

import java.io.*;

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

		System.out.println ("What is your next move? [0-"+(board.getColumns()-1)+"]");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int column = -1;
		while (column == -1)
		{
			try 
			{

				int input = Integer.parseInt(br.readLine());
				if (input < 0 || input >= board.getColumns())
				{
					System.out.println("Sorry, that is not on the board");
				}
				else
				{
					column = input;
					br.close();
				}
			}
			catch (IOException e){}
			catch (Exception e)
			{
				System.out.println("Sorry, I didn't understand you. Please try again.");
			}
		}
		return new ConnectFourMove(player, column);
	}

}
