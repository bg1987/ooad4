/**
 * 
 */
package ooad4.consolegui;


import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import ooad4.core.Board;
import ooad4.core.Game;
import ooad4.core.Player;

/**
 * @author Benny
 *
 */
public class gameObserver implements Observer {

	private HashMap<Player, Character> guiObjects = new  HashMap<Player, Character>();
	
	public gameObserver(Player p1, char p1Gui, Player p2, char p2Gui) {
		guiObjects.put(p1, new Character(p1Gui));
		guiObjects.put(p2, new Character(p2Gui));
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Board board = ((Game)o).board;
		
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				char c = board.getPieces(i, j) == null ? '_' : guiObjects.get(board.getPieces(i, j).owner);
				System.out.print(c);
				System.out.print(' ');
			}
			System.out.println();
		}
	}
	
}
