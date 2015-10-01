package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import expr.*;
import java.io.IOException;
import util.XLException;

public class XLModel extends Observable implements Environment {

	private HashMap<String, Slot> slotMap;
	private String status;
	boolean DEBUG = true;

	public XLModel() {
		slotMap = new HashMap<String, Slot>();
		status = "Start String!";
	}

	public void addSlot(String name, String editorValue) {
		if (DEBUG) System.out.print("addSlot: " + editorValue)
		if (editorValue.equals(""))
			slotMap.remove(name);
		else
			slotMap.put(name, newSlot(editorValue));
		setChanged();
		notifyObservers();
	}

	private Slot newSlot(String editorString) {  //Kollar efter commentslot bland annat.
		if (DEBUG) System.out.print("newSlot: " + editorValue)
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

	/*public void recalculate() {
		//For loop, iterates slotMap
	}*/

	public String getStatus() {
		return status;
	}


	public boolean isEmpty(String name) {
		return (!slotMap.containsKey(name));
	}

	public double value(String name) { // no status update if empty
		if (!isEmpty(name)) {
			return slotMap.get(name).value(this);
		}
			status = "Unable to reference empty slot";
			throw new XLException("Empty reference " + name);
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