package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import expr.*;
import java.io.*;
import util.XLException;

/**
 * A <code>XLmodel<code> is the model in the model-view-controller pattern for
 * the XL program. This creates, handles and removes all the slots aswell as 
 * notifing the gui of errors. 
 * @author Emil Westenius, Adam Jalkemo, Anton Friberg, Andres Saemundsson. 
 */
public class XLModel extends Observable implements Environment {

	private HashMap<String, Slot> slotMap;
	private String status;
	boolean DEBUG = true;

	/**
         * Creates a new model if none exists. 
         */
        public XLModel() {
		slotMap = new HashMap<String, Slot>();
		status = "Start String!";
	}

	/**
         * Adds new slot to the model from the provided string. 
         * @param name
         *          The address of the slot that is to be added.
         * @param editorValue 
         *          The <code>String<code> value that is to be associated with 
         *          the slot.  
         */
        public void addSlot(String name, String editorValue) {
		if (DEBUG) p("addSlot: " + name + ": " + editorValue);
		if (editorValue.equals("")) { // Removes slot (if allowed)
			Slot tmpSlot = slotMap.remove(name); 
			try {
				recalculate();
			} catch (XLException e) {
				status = "Can't clear a referenced slot: " 
                                        + e.getMessage();
				slotMap.put(name, tmpSlot);
			}
		} else {
			Slot tmpSlot = slotMap.get(name); //Could be null;
			
			try {
				Slot newSlot = newSlot(editorValue);
				checkCircularSlot(name, newSlot); //Checks for circular slot
				slotMap.put(name, newSlot); //Checks expression
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

	/**
         * Checks for circular slot. 
         * @param name
         *          The address of the slot that is being checked. 
         * @param newSlot
         *          The slot that is being checked. 
         * @throws XLException
         *          If circular dependency is found. 
         */
        private void checkCircularSlot(String name, Slot newSlot) throws XLException { // Checks for circular slot
		slotMap.put(name, new CircSlot());
		newSlot.value(this);
	}

	/**
         * Decides if the slot is to be created as <code>CommentSlot<code> or 
         * <code>ExprSlot. 
         * @param editorString
         *          The information that is to be stored in the slot. Can be
         *          either a comment or an expression. 
         * @return
         *          Returns the slot that is created. 
         * @throws IOException
         *          If the Slot cannot be created with the provided data. 
         * @throws XLException 
         *          If the information provided violates the grammar in parser. 
         */
        public Slot newSlot(String editorString) throws IOException, XLException {  //Kollar efter commentslot bland annat.
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

	/**
         * DEBUG - method. 
         * @param o 
         */
        public void p(Object o) {
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
	public void load(String path) throws FileNotFoundException,XLException{
		XLBufferedReader reader = new XLBufferedReader(path);
		clearAllSlots();
		try{
			reader.load(slotMap,this);
			recalculate();
		}catch(XLException e){
			throw new XLException(e.getMessage());
		}
		setChanged();
		notifyObservers();
	}



/* Tillhör observable:
public void addObserver(Observer observer)  
public void deleteObserver(Observer observer)  
protected void setChanged() 
public void notifyObservers(Object object)  
public void notifyObservers() 
*/
} 