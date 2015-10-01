package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import expr.*;
import java.io.IOException;

public class XLModel extends Observable implements Environment {

	private HashMap<String, Slot> slotMap;
	private String status;
	boolean DEBUG = true;

	public XLModel() {
		slotMap = new HashMap<String, Slot>();
		status = "Start String!";

		if (DEBUG) {
			slotMap.put("A1", newSlot("5"));
			slotMap.put("B2", newSlot("50"));
		}


	}

	public Slot newSlot(String editorString) {  //Kollar efter commentslot bland annat.
		try {
			ExprSlot slot = new ExprSlot(editorString);
			return slot;
		} catch (IOException e) {
        	if (DEBUG) {
        		System.err.println(e.getMessage());
	        	System.out.println("New ExprSlot failed");
          		System.out.println(editorString);
          	}
        	status = e.getMessage();
        	return null; // TODO borde inte returnera null (kanske)
        }

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
		return status;
	}

	public double value(String name) { //TODO if slotMap does not contain name throw
		return slotMap.get(name).value(this);
		
	}



/* Tillhör observable:
public void addObserver(Observer observer)  
public void deleteObserver(Observer observer)  
protected void setChanged() 
public void notifyObservers(Object object)  
public void notifyObservers() 
*/
} 