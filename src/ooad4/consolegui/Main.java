package ooad4.consolegui;

import ooad4.connectfour.ConnectFourRules;
import ooad4.core.Game;
import ooad4.core.GameEndedUnexpectedlyException;
import ooad4.core.IRules;
import ooad4.core.Player;
import ooad4.core.ProxyLogger;

public class Main {

	public static void main(String[] args)
	{
		//create the players and the game, with a set of rules.
		Player pHuman = new Player(HumanStrategy.getInstance());
		Player pRandom = new Player(RandomStrategy.getInstance());
		
		IRules rules = (IRules)ProxyLogger.newInstance(new ConnectFourRules(6, 7));
		
		Game theGame = new Game(pHuman, pRandom,rules );
		
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
