package ooad4.connectfour;
import ooad4.core.Player;
import ooad4.core.Move;


/**
 * A concrete move in the ConnectFour game.
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class ConnectFourMove extends Move
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public int column;
	

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public ConnectFourMove(Player owner, int column) {
		super(owner);
		this.column = column;
	}
	
}

