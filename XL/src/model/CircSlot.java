package model;

import expr.*;
import util.XLException;

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