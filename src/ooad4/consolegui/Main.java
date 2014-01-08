package ooad4.consolegui;

import ooad4.connectfour.ConnectFourRules;
import ooad4.connectfour.HumanStrategy;
import ooad4.connectfour.RandomStrategy;
import ooad4.core.Game;
import ooad4.core.GameEndedUnexpectedlyException;
import ooad4.core.Player;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		foo f = new foo();
		
		
		
		
		Player pHuman = new Player(HumanStrategy.getInstance());
		Player pRandom = new Player(RandomStrategy.getInstance());
		Game theGame = new Game(pHuman, pRandom, new ConnectFourRules(5, 5));
		gameObserver go = new gameObserver(pHuman, '@', pRandom, 'O');
		theGame.addObserver(go);
		
		
		f.addObserver(go);
		f.bar("hello");
		
		
		try {
			theGame.play();
		} catch (GameEndedUnexpectedlyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done");
		
	}


}
