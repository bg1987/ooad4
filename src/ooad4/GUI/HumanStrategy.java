package ooad4.GUI;

import java.io.*;

import ooad4.connectfour.ConnectFourMove;
import ooad4.connectfour.ConnectFourStrategy;
import ooad4.core.Board;
import ooad4.core.Move;
import ooad4.core.Player;


/**
 * A ConnectFour that gets its next move from a user.
 */

public class HumanStrategy extends ConnectFourStrategy
{
	private static HumanStrategy instance;

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
		String input = "";
		do
		{
			try{
				 input = br.readLine();
			}
			catch (IOException e) {
				System.out.println("System Error.");
			}
			
		}while (!validateInput(input,board));
		
		return new ConnectFourMove(player, Integer.parseInt(input));
	}
	
	private boolean validateInput(String inMsg, Board board){
		try 
		{
			
			int input = Integer.parseInt(inMsg);
			if (input < 0 || input >= board.getColumns())
			{
				System.out.println("Sorry, that is not on the board");
				return false;
			}
			else
			{
				return true;
			}
		}
		catch (Exception e)
		{
			System.out.println("Sorry, I didn't understand you. Please try again.");
			return false;
		}
	}

}
