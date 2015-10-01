package gui;

import java.util.Observable;
import java.awt.Color;

public class CurrentSlot extends Observable {
	
	private SlotLabel currentSlot;
	
	public CurrentSlot() {
	}
	public void set(SlotLabel newCurrent){
		currentSlot = newCurrent;
		setChanged();
		notifyObservers();
		//addObserver(newCurrent)
	}
	public void setWhite(){
		currentSlot.setBackground(Color.WHITE);
	}
	public void setYellow(){
		currentSlot.setBackground(Color.YELLOW);
	}
	public String toString(){
		return currentSlot.toString();
	}
}