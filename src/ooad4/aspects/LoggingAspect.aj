package ooad4.aspects;

import java.io.PrintStream;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

//import org.aspectj.lang.Signature;

import ooad4.core.Board;
//import ooad4.core.Move;
import ooad4.core.LogFiles;
import ooad4.core.Piece;
import ooad4.core.Player;
import ooad4.core.WinResult;


//call (<return type> <package>.<class>.<method>(<params>));
public aspect LoggingAspect {
	static long turnStartTime;
	private static PrintStream out = LogFiles.GetStream("aspectLogger.txt", true);;
	private static Player p1;
	private static Player p2;
	private static String lastPlayer;
	pointcut nextMove() : call(* ooad4.core.Strategy.nextMove(..)) && !within(tests..*);
	
	before() : call (ooad4.core.Game.new(ooad4.core.Player,ooad4.core.Player,ooad4.core.IRules)) && !within(tests..*){
		Object[] args = thisJoinPoint.getArgs();
		p1 = (ooad4.core.Player)args[0];
		p2 = (ooad4.core.Player)args[1];
		log("-------Log started!------");
	}
	
	before() : nextMove(){
		turnStartTime = System.currentTimeMillis();
	}
	
	after() returning(ooad4.connectfour.ConnectFourMove move): nextMove()  {
		String player = "";
		if(move.owner == p1){
			player = "player1";
		}else if(move.owner == p2){
			player = "player2";
		}else{
			player = "unkown";
		}
		lastPlayer = player;
		long timeTook = System.currentTimeMillis() - turnStartTime;
		log("after "+timeTook/1000+" seconds, "+player+" puts a disc in column: "+move.column);
	}
	
	after() returning(boolean isValid): call(boolean ooad4.connectfour.ConnectFourRules.validateInput(..)) || call(boolean ooad4.connectfour.HumanStrategy.validateInput(..)){
		if (!isValid) {
			log("invalid move");
		}
	}
	
	after() : call(* ooad4.core.IRules.parseMove(* , *)){
		Object[] args = thisJoinPoint.getArgs();
		Board board = (Board)args[1];
		logBoard(board);
	}
	
	after() returning(WinResult res) : call(WinResult ooad4.core.IRules.checkWin(..)){
		switch (res) {
		case Won:
			log("Game has ended! "+lastPlayer+" has won!");
			break;
		case Tie:
			log("Game has ended in a tie");
			break;
		default:
			break;
		}
		
	}

	static void log(String msg){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		out.println("["+dateFormat.format(date)+"] AspectLogger:"+msg);
	}
	
	static void logBoard(Board board){
		log("Board status:");
		for (int i = board.getRows()-1; i >= 0; i--) {
			out.print("|");
			for (int j = 0; j < board.getColumns(); j ++) {
				Piece p = board.getPieces(i, j);
				if(p==null){
					out.print(" |");
				}else if(p.getOwner() == p1){
					out.print("X|");
				}else if(p.getOwner() == p2){
					out.print("O|");
				}else{
					out.print("?|");
				}
			}
			out.println();
		}
		for (int k = 0; k < 2*board.getColumns()+1; k++)
			out.print("-");
		out.println();
	}
     

    
    


}
