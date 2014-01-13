package ooad4.core;


/**
 * An abstract class representing a move in the game.
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public abstract class Move
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
	
	public Move(Player owner) {
		if (owner == null)
		{
			throw new IllegalArgumentException("Move cannot get a null owner");
		}
		this.owner = owner;
	}
	
}

