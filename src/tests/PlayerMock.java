package tests;

import ooad4.core.Player;
import ooad4.core.Strategy;

public class PlayerMock extends Player {
	public PlayerMock() {
		super(new StrategyMock());
	}

	public PlayerMock(int move) {
		super(new StrategyMock(move));
		// TODO Auto-generated constructor stub
	}
	
	public PlayerMock(Strategy strat){
		super(strat);
	}

}
