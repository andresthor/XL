package model;

import expr.*;

public class CommentSlot implements Slot{
	
String slotString;

	public CommentSlot(String editorString) {
		this.slotString = editorString;
	}

	public String toString() {
		return slotString;
	}

 	public double value(Environment env){
 		return 0;
 	}
	
} 
