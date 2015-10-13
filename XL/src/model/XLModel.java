package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
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
			try { // Checks for circular slot
				Slot newSlot = newSlot(editorValue);
				checkCircularSlot(name, newSlot); //Checks for circular dependencies
				slotMap.put(name, newSlot);
				recalculate();
			} catch (IOException|XLException e) {
				status = e.getMessage();
				
			}
			
			setChanged();
			notifyObservers();
		}
	}


	private Slot checkCircularSlot(String name, Slot newSlot) {
		
		Slot tmpSlot = slotMap.put(name, new CircSlot());
		try {
			newSlot.value(this);
			return tmpSlot;
		} catch (XLException e) {
			//status = e.getMessage();
			slotMap.put(name, tmpSlot);
			throw e;
		}
	} 

	private Slot newSlot(String editorString) throws IOException {  //Kollar efter commentslot bland annat.
		if (DEBUG) p("newSlot: " + editorString);
		if (editorString.charAt(0) == '#') //Looks for Comment
			return new CommentSlot(editorString);

		ExprSlot slot = new ExprSlot(editorString);
		return slot;
	}


	public String getSlotString(String name) { //
		return slotMap.get(name).toString();
	}

	private void recalculate() {
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

	public double value(String name) { // no status update if empty
		if (!isEmpty(name)) {
			return slotMap.get(name).value(this);
		}
			status = "Unable to reference empty slot " + name;
			throw new XLException("Unable to reference empty slot " + name);
	}

	public void p(Object o) { //DEBUG-metod
		System.out.println(o);
	}
	public ArrayList<String> getAllSlots(){
		//Iterator it = slotMap.entrySet().Iterator();
		ArrayList allSlots = new ArrayList();

		for(HashMap.Entry<String, Slot> entry : slotMap.entrySet()){
			String st = entry.getKey() + " " + entry.getValue();
			allSlots.add(st);
		}
		System.out.print(allSlots);
		return allSlots;
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