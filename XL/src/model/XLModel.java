package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import expr.*;
import java.io.*;
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
		if (DEBUG) p("addSlot: " + name + ": " + editorValue);
		if (editorValue.equals("")) { // Removes slot (if allowed)
			Slot tmpSlot = slotMap.remove(name);
			try {
				recalculate();
			} catch (XLException e) {
				status = "Can't clear a referenced slot: " + e.getMessage();
				slotMap.put(name, tmpSlot);
			}
		} else {
			Slot tmpSlot = slotMap.get(name); //Could be null;
			
			try {
				Slot newSlot = newSlot(editorValue);
				checkCircularSlot(name, newSlot); // Checks for circular slot
				slotMap.put(name, newSlot); //checks expression
				recalculate(); //checks dependencies
			} catch (IOException|XLException e) {
				if (tmpSlot == null) { 
					slotMap.remove(name); //Resets slot
				} else {
					slotMap.put(name, tmpSlot); //Resets slot
				}
				status = e.getMessage();
				recalculate();
			}

		}
		setChanged();
		notifyObservers();
	}

	private void checkCircularSlot(String name, Slot newSlot) throws XLException { // Checks for circular slot
		slotMap.put(name, new CircSlot());
		newSlot.value(this);
	}

	private Slot newSlot(String editorString) throws IOException, XLException {  //Kollar efter commentslot bland annat.
		if (DEBUG) p("newSlot: " + editorString);
		if (editorString.charAt(0) == '#') //Looks for Comment
			return new CommentSlot(editorString);

		ExprSlot slot = new ExprSlot(editorString);
		return slot;
	}


	public String getSlotString(String name) { //
		return slotMap.get(name).toString();
	}

	private void recalculate() throws XLException {
		for (Entry<String, Slot> entry : slotMap.entrySet()) {
			entry.getValue().value(this);
		}
	}

	public String getStatus() {
		return status;
	}


	public boolean isEmpty(String name) {
		return (!slotMap.containsKey(name));
	}

	public double value(String name) throws XLException { // no status update if empty
		if (!isEmpty(name)) {
			return slotMap.get(name).value(this);
		}
			throw new XLException(status = "Unable to reference empty slot " + name);
	}

	public void p(Object o) { //DEBUG-metod
		System.out.println(o);
	}

	public void clearAllSlots() {
		slotMap.clear();
		setChanged();
		notifyObservers();
	}
	public void save(String path) throws FileNotFoundException{
		XLPrintStream writer = new XLPrintStream(path);
		writer.save(slotMap.entrySet());
	}
	public void load(String path) throws FileNotFoundException{
		XLBufferedReader reader = new XLBufferedReader(path);
		clearAllSlots();
		reader.load(this);
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