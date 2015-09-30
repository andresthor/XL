import expr.*;

public class ExprSlot implements Slot {
 
String slotString;
double slotValue;

	public ExprSlot(String slotString) {
		this.slotString = slotString;

	}

	public String toString() {
		return "";
	}

 	public double value(){
 		return 0;
 	}

 }