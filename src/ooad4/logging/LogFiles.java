package ooad4.logging;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class LogFiles {
	public static PrintStream GetStream(String path,boolean append){
		try {
			return new PrintStream(new FileOutputStream(path,append));
		} catch (FileNotFoundException e) {
			System.out.println("Warning: Couldn't create file "+path+" Returning system.out");
			return System.out;
		}
	}
}
