package swingGUI;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ooad4.connectfour.ConnectFourRules;
import ooad4.connectfour.RandomStrategy;
import ooad4.core.Game;
import ooad4.core.GameEndedUnexpectedlyException;
import ooad4.core.Piece;
import ooad4.core.Player;

public class ConnectFourGUI extends JFrame implements Observer {
	public BoardGUI board;
	private Player p1, p2;
	
	public ConnectFourGUI(Player p1, Player p2)
	{
		super("ConnectFourGame");
		setSize(500,500);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		board = new BoardGUI(p1, p2);
		this.p1 = p1;
		this.p2 = p2;
		
		this.add(board);
		
		setVisible(true);

	}
	
	@Override
	public void update(Observable o, Object arg) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Piece piece = (Piece) arg;
		board.updateBoard(piece);
		
	}

	public static void main(String[] args) {
		Player p1 = new Player(RandomStrategy.getInstance());
		Player p2 = new Player(RandomStrategy.getInstance());
		Game theGame = new Game(p1, p2, new ConnectFourRules(6, 7));
		ConnectFourGUI gui = new ConnectFourGUI(p1,p2);
		theGame.addObserver(gui);


		try {
			Player winner = theGame.play();
			gui.gameEnded(winner);
		} catch (GameEndedUnexpectedlyException e) {
			e.printStackTrace();
		}

	}

	private void gameEnded(Player winner) {
		if (winner == null)
		{
			JOptionPane.showMessageDialog(null, "Game ended in a tie.");
		}
		else if (winner == p1)
		{
			JOptionPane.showMessageDialog(null, "Congratulations, player 1 won.");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Congratulations, player 2 won.");
		}
		
	}



}
