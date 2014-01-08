package ooad4.core;

import java.util.Observable;


/**
 * Responsible for the game's loop.
 * Keeps track of the players, the board, whose turn it is, etc.
 */
public class Game extends Observable
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Rules rules;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Board board;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Player player1;
	public Player player2;
	

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Game(Player p1, Player p2, Rules rules) {
		this.player1 = p1;
		this.player2 = p2;
		this.rules = rules;
		this.board = new Board(rules.boardRows, rules.boardColumns);
	}
	
	/**
	 * Start the game, and run it until it ends.
	 * @returns the winning player, or null if there was a tie
	 * @throws GameEndedUnexpectedlyException 
	 */
	
	public Player play() throws GameEndedUnexpectedlyException {
		Player turn = null;
		WinResult gameState = WinResult.None;
		notifyObservers();
		//The game loop. Halts when the game has ended
		while(gameState == WinResult.None)
		{
			//Determine whose turn it is
			if (turn == player1)
			{
				turn = player2;
			}
			else
			{
				turn = player1;
			}
			
			//Ask player for the next move, and update the board
			boolean moved = false;	
			do {
			moved = false;
			Move nextMove = turn.getMove(this.board);
			try {
				rules.parseMove(nextMove, board);
				moved = true;
				notifyObservers();
			} catch (InvalidMoveException | IllegalMoveExcetion e) {
				//TODO: make game observable and notify about the exception.
			}

			} while (!moved);
			
			//Check whether the game has ended
			gameState = rules.checkWin(board);
		}
		
		switch (gameState)
		{
		case Won:
			return turn;
		case Tie:
			return null;
		default:
			//Exited the game loop, but no one has won and there is no tie.
			throw new GameEndedUnexpectedlyException();
		}
	}
	
}

