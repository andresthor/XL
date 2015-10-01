package model;

import expr.*;

public class CommentSlot implements Slot{
	
String slotString;

	public CommentSlot() {

	}

	public String toString() {
		return "";
	}

 	public double value(Environment env){
 		return 0;
 	}
	
} 
