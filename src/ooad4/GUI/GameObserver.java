/**
 * 
 */
package ooad4.GUI;


import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import ooad4.core.Board;
import ooad4.core.Game;
import ooad4.core.Player;


public class GameObserver implements Observer {

	Player player1;
	private HashMap<Player, Character> guiObjects = new  HashMap<Player, Character>();
	
	public GameObserver(Player p1, char p1Gui, Player p2, char p2Gui, int rows, int cols) {
		guiObjects.put(p1, new Character(p1Gui));
		guiObjects.put(p2, new Character(p2Gui));
		this.player1 = p1;
		
		//print out an empty board for the start of the game.
		for (int i = rows; i >= 0; i--) {
			for (int j = 0; j < cols; j ++) {
				System.out.print('_');
				System.out.print(' ');
			}
			System.out.println();
		}
		System.out.println();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Board board = ((Game)o).board;
		
		for (int i = board.getRows()-1; i >= 0; i--) {
			for (int j = 0; j < board.getColumns(); j ++) {
				char c = board.getPieces(i, j) == null ? '_' : guiObjects.get(board.getPieces(i, j).getOwner());
				System.out.print(c);
				System.out.print(' ');
			}
			System.out.println();
		}
		System.out.println();
	}

	public void gameEnded(Player winner) {
		if (winner == null)
		{
			System.out.println("Game ended in a tie.");
		}
		else if(player1 == winner)
		{
			System.out.println("Player1 won.");
		}
		else
		{
			System.out.println("Player2 won.");
		}
		
	}
	
}
