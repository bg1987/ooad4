package ooad4.consolegui;

import ooad4.connectfour.ConnectFourRules;
import ooad4.connectfour.HumanStrategy;
import ooad4.connectfour.RandomStrategy;
import ooad4.core.Game;
import ooad4.core.GameEndedUnexpectedlyException;
import ooad4.core.Player;

public class Main {

	public static void main(String[] args)
	{
		//create the players and the game, with a set of rules.
		Player pHuman = new Player(HumanStrategy.getInstance());
		Player pRandom = new Player(RandomStrategy.getInstance());
		Game theGame = new Game(pHuman, pRandom, new ConnectFourRules(6, 7));
		
		//initialize consul GUI
		gameObserver consulGUI = new gameObserver(pHuman, '@', pRandom, 'O', 6, 7);
		theGame.addObserver(consulGUI);
		
		//initialize swing GUI
		ConnectFourGUI swingGUI = new ConnectFourGUI(pHuman,pRandom, 6, 7);
		theGame.addObserver(swingGUI);
		
		try {
			//start the game
			Player winner = theGame.play();
			
			swingGUI.gameEnded(winner);
			consulGUI.gameEnded(winner);
		} catch (GameEndedUnexpectedlyException e) {
			e.printStackTrace();
		}
	}
}
