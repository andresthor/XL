package gui;

import java.util.Observable;

public class CurrentSlot extends Observable {
	
	private SlotLabel currentSlot;
	
	public CurrentSlot(SlotLabel first) {
		currentSlot = first;
	}
	public void set(SlotLabel newCurrent){
		currentSlot = newCurrent;
	}
}