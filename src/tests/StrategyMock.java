package tests;

import ooad4.connectfour.ConnectFourMove;
import ooad4.core.Board;
import ooad4.core.Move;
import ooad4.core.Player;
import ooad4.core.Strategy;

public class StrategyMock implements Strategy {
	private int move;
	public StrategyMock(int move) {
		this.move = move;
	}
	
	public StrategyMock()
	{
		this.move = 0;
	}
	
	@Override
	public Move nextMove(Board board, Player player) {
		
		return new ConnectFourMove(player,move); 
	}
	
	public Move nextMove(Player player) {
		
		return new ConnectFourMove(player,move); 
	}
	
	public Move nextMove (){
		return new ConnectFourMove(new PlayerMock(this),move);
	}
}
