package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JTextField;

public class Editor extends JTextField implements Observer {

	private XLModel model;
	private CurrentSlot currentSlot;
    private StatusLabel status;

    public Editor(CurrentSlot currentSlot) {
        setBackground(Color.WHITE);
        this.currentSlot = currentSlot;
        currentSlot.addObserver(this);
    }
	@Override
	public void update(Observable arg0, Object arg1) {
		setText(model.get)
		
	}
	public void actionPerformed(ActionEvent e){
		String input = getText();		
		model.addSlot(currentSlot.toString(),input);
		status.update(model,null);
	}

}