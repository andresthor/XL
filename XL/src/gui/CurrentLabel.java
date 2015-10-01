package gui;

import java.awt.Color;
import java.util.Observer;
import java.util.Observable;

public class CurrentLabel extends ColoredLabel implements Observer{
	private CurrentSlot currentSlot;
    public CurrentLabel(CurrentSlot currentSlot) {
        super("A1", Color.WHITE);
        currentSlot.addObserver(this);
        this.currentSlot = currentSlot;
    }
    public void update(Observable o, Object arg){
    	setText(currentSlot.toString());
    }
}