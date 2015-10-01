package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

public class Editor extends JTextField implements Observer {
    public Editor(CurrentSlot currentSlot) {
        setBackground(Color.WHITE);
        currentSlot.addObserver(this);
    }
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}