package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

public class Editor extends JTextField implements Observer {
    public Editor(CurrentSlot currentSlot) {
        setBackground(Color.WHITE);
    }
    public void update() {

    }
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}