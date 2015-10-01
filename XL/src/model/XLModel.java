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
	}

	public void addSlot(String name, String editorValue) {
		slotMap.put(name, newSlot(editorValue));
	}

	public Slot newSlot(String editorString) {  //Kollar efter commentslot bland annat.
		if (editorString.charAt(0) == '#') //Looks for Comment
			return new CommentSlot(editorString);
			
		
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


	public String getSlotString(String name) { //
		return slotMap.get(name).toString();
	}

	public void recalculate() {
		//For loop, iterates slotMap
	}

	public String getStatus() {
		return status;
	}

	public double value(String name) { //TODO if slotMap does not contain name throw error
		return slotMap.get(name).value(this);
	}

/*	public double getSlotValue(String name) { //Doesn't throw error if empty, instead returns empty.
		return slotMap.get(name).value(this);
	}
*/



/* Tillhör observable:
public void addObserver(Observer observer)  
public void deleteObserver(Observer observer)  
protected void setChanged() 
public void notifyObservers(Object object)  
public void notifyObservers() 
*/
} 