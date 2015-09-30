package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class XLModel extends Observable {

	HashMap slotMap;

	public XLModel() {
		slotMap = new HashMap<String, Slot>();

	}

	public Slot newSlot() {
		return null; //Kollar efter commentslot bland annat.

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
		return 0;
		//if slotMap does not contain name throw
	}



/* Tillhör observable:
public void addObserver(Observer observer)  
public void deleteObserver(Observer observer)  
protected void setChanged() 
public void notifyObservers(Object object)  
public void notifyObservers() 
*/
} 