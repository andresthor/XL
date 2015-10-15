package model;

import expr.*;
import util.XLException;

/**
 * This Slot helps the model handle circular dependencies. 
 * @author Emil Westenius, Adam Jalkemo, Anton Friberg, Andres Saemundsson. 
 */
public class CircSlot implements Slot{

	public CircSlot() {

	}

	public String toString() {
		return "";
	}

 	public double value(Environment env){
 		throw new XLException("Circular dependencies not allowed");
 	}
	
}