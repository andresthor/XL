package model;

import java.util.HashMap;
import java.util.Observable;

public class Sheet extends Observable {

	HashMap slotMap;
	ArrayList<Observer> Observers;

	public Sheet() {
		slotMap = new HashMap<String, Slot>();
		Observers = new ArrayList<Observers>();

	}

	public Slot newSlot() { //Kollar efter commentslot bland annat.

	}

	public double getSlotValue(String name) { //
		return 0;
	}

	public String getSlotString(String name) { //
		return "";
	}

	public void recalculate() {
		//For loop, iterates slotMap
	}

	public String getStatus() {
		return "";
	}

	public double value(String name) {
		if slotMap does not contain name throw
	}



/* Tillhör observable:
public void addObserver(Observer observer)  
public void deleteObserver(Observer observer)  
protected void setChanged() 
public void notifyObservers(Object object)  
public void notifyObservers() 
*/
} 