package gui;

import java.util.Observable;
import java.awt.Color;

public class CurrentSlot extends Observable {
	
	private SlotLabel currentSlot;
	
	public CurrentSlot() {
	}
	public void set(SlotLabel newCurrent){
		currentSlot = newCurrent;
	}
	public void setWhite(){
		System.out.println("This is good");
		currentSlot.setBackground(Color.WHITE);
		System.out.println("this is bad");
	}
	public void setYellow(){
		currentSlot.setBackground(Color.YELLOW);
	}
}