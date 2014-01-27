package swingGUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ooad4.core.Board;
import ooad4.core.Piece;
import ooad4.core.Player;

public class BoardGUI extends JPanel{
	
	private HashMap<Player,ImageIcon> playerImages = new HashMap<Player,ImageIcon>();
	private JLabel[][] boardDisplay = new JLabel[6][7];

	public BoardGUI(Player p1, Player p2)
	{
		this.setLayout(new GridLayout(6,7));
		for (int i=0;i<6;i++)
		{
			for(int j=0;j<7;j++)
			{
				boardDisplay[i][j] = new JLabel();
				boardDisplay[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				this.add(boardDisplay[i][j]);
			}
		}
		
        playerImages.put(p1, new ImageIcon("C:/Users/Owner/Documents/GitHub/ooad4/src/blue.png"));
		playerImages.put(p2, new ImageIcon("C:/Users/Owner/Documents/GitHub/ooad4/src/yellow.png"));
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
		int row = 5 - piece.getRow();
		int column = piece.getColumn();
		Player player = piece.getOwner();
		boardDisplay[row][column].setIcon(playerImages.get(player));
	}
}
