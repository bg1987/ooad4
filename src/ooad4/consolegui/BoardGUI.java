package ooad4.consolegui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ooad4.core.Piece;
import ooad4.core.Player;

public class BoardGUI extends JPanel{
	
	private HashMap<Player,ImageIcon> playerImages = new HashMap<Player,ImageIcon>();
	private JLabel[][] boardDisplay;
	private int rows, cols;

	public BoardGUI(Player p1, Player p2, int rows, int cols)
	{
		this.setLayout(new GridLayout(rows,cols));
		boardDisplay = new JLabel[rows][cols];
		for (int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				boardDisplay[i][j] = new JLabel();
				boardDisplay[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				this.add(boardDisplay[i][j]);
			}
		}
		
        playerImages.put(p1, new ImageIcon("blue.png"));
		playerImages.put(p2, new ImageIcon("yellow.png"));
		this.rows = rows;
		this.cols = cols;
	}
	
	public void setPlayerGUI(Player player, Image newGUI)
	{
		playerImages.get(player).setImage(newGUI);
		redrawBoard();
	}

	
	private void redrawBoard() {
		// TODO Auto-generated method stub
		
	}

	public void updateBoard(Piece piece)
	{
		int row = (rows-1) - piece.getRow();
		int column = piece.getColumn();
		Player player = piece.getOwner();
		boardDisplay[row][column].setIcon(playerImages.get(player));
	}
}
