package ooad4.connectfour;
import ooad4.core.Strategy;
import ooad4.core.Player;
import ooad4.core.Board;
import ooad4.core.Move;


/**
 * An abstract realization of the the Strategy interface that provides the next move in a connect four game.
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public abstract class ConnectFourStrategy implements Strategy
{

	protected ConnectFourStrategy instance;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public static ConnectFourStrategy GetInstance() {
		// TODO : to implement
		return null;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private ConnectFourStrategy() {
		super();
		// TODO : construct me	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Move nextMove(Board board, Player player) {
		// TODO : to implement
		return null;	
	}
	
}

