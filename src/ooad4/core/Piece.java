package ooad4.core;


/**
 * An abstract class that represents a single piece on the game board.
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public abstract class Piece
{
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Player owner;
	

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Piece(Player owner) {

		this.owner = owner;
	}
	
}

