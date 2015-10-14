package model;

import expr.*;
/**
 * Handles different kinds of information that is used in the model. 
 * @author Emil Westenius, Adam Jalkemo, Anton Friberg, Andrés Þór Sæmundsson. 
 */
public interface Slot {
 	
 	public String toString();
 	public double value(Environment env);
 }