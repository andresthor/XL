package model;

import expr.*;
public interface Slot {
 	
 	public String toString();
 	public double value(Environment env);
 }