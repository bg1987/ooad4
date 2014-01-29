package ooad4.consolegui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ooad4.core.Piece;
import ooad4.core.Player;

/**
 * Basic GUI created with swing, to show that the game can be 
 * displayed with any GUI written for it, without having to change the code.
 */
public class ConnectFourGUI extends JFrame implements Observer {
	public BoardGUI board;
	private Player p1, p2;
	
	public ConnectFourGUI(Player p1, Player p2, int rows, int cols)
	{
		super("ConnectFourGame");
		setSize(500,500);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		board = new BoardGUI(p1, p2, rows, cols);
		this.p1 = p1;
		this.p2 = p2;
		
		this.add(board);
		
		setVisible(true);

	}
	
	@Override
	public void update(Observable o, Object arg) {
		Piece piece = (Piece) arg;
		board.updateBoard(piece);
		
	}

	public void gameEnded(Player winner) {
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
