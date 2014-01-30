package ooad4.core;

import java.util.Observable;


/**
 * Responsible for the game's loop.
 * Keeps track of the players, the board, whose turn it is, etc.
 */
public class Game extends Observable
{
	/**
	 * The rules of the game.
	 * Determine the legality of moves and the winning conditions.
	 */
	public IRules rules;
	
	/**
	 * The board.
	 */
	public Board board;
	
	/**
	 * The two players.
	 */
	public Player player1;
	public Player player2;
	

	/**
	 * Creates a game with two players and a set of rules.
	 */
	public Game(Player p1, Player p2, IRules rules) {
		if (p1 == null || p2 == null || rules == null)
		{
			throw new IllegalArgumentException("Players and rules cannot be null");
		}
		this.player1 = p1;
		this.player2 = p2;
		this.rules = rules;
		this.board = new Board(rules.getBoardRows(), rules.getBoardColumns());
	}
	
	/**
	 * Start the game, and run it until it ends.
	 * @returns the winning player, or null if there was a tie
	 * @throws GameEndedUnexpectedlyException 
	 */
	public Player play() throws GameEndedUnexpectedlyException {
		Player turn = null;
		WinResult gameState = WinResult.None;
		
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
			//If an invalid move is sent, ask for another move from the player.
			int moveTries = 0;	
			Piece newestPiece = null;
			while(moveTries<10 && newestPiece == null) {
				Move nextMove = turn.getMove(this.board);
				newestPiece = rules.parseMove(nextMove, board);
				if (newestPiece == null)
				{
					moveTries++;
				}
				setChanged();
				notifyObservers(newestPiece);
			}
			//If after 10 tries, the player has not provided a legal move, stop the game.
			//This will make the game throw a gameEndedUnexpectedlyException.
			if (moveTries >= 10)
			{
				break;
			}
			
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

