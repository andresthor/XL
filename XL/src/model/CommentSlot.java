package model;

import expr.*;

/**
 * A Slot that handles Comments.
 * @author Emil Westenius, Adam Jalkemo, Anton Friberg, Andres Saemundsson. 
 */
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
