package ooad4.core;


/**
 * Represents a player in the game, either human or an AI.
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Player
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public String color;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Strategy strategy;
	

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Player(Strategy strategy) {
		super();
		// TODO : construct me	
	}


	public Move getMove(Board board) {
		return strategy.nextMove(board, this);
	}
	
}

