package ooad4.core;
import java.util.Set;
import java.util.HashSet;


/**
 * Responsible for the game&#39;s loop.<div>keeps track of the players, the board, whose turn it is, etc.</div>
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Game
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Rules rules;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Board board;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Player player1;
	public Player player2;
	

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Game(Player p1, Player p2, Rules rules) {
		this.player1 = p1;
		this.player2 = p2;
		this.rules = rules;
		// TODO: maybe create board here
	}
	
	/**
	 * Start the game.<div>Returns the winning player.</div>
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Player play() {
		// TODO : to implement
		return player1;	
	}
	
}

