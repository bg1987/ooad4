package ooad4.consolegui;

import java.util.Observable;

public class foo extends Observable {
	public void bar(Object o)
	{
		notifyObservers(o);
	}

}
