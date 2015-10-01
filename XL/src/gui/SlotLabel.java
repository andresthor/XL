package gui;

import java.awt.Color;
import java.awt.Event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import model.XLModel;
import util.XLException;

public class SlotLabel extends ColoredLabel implements Observer{
	
	private CurrentSlot currentSlot;
	private String slotName;
	private XLModel model;

    public SlotLabel(CurrentSlot currentSlot, String name, XLModel model) {	
        super("                    ", Color.WHITE, RIGHT);
        this.addMouseListener(new MyAdapter());
        this.currentSlot = currentSlot;
        slotName = name;
        this.model = model;
        model.addObserver(this);
    }

	private class MyAdapter extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
			SlotLabel.this.updateCurrent();
        }
	}
	protected void updateCurrent(){
		currentSlot.setWhite();
		currentSlot.set(this);
		currentSlot.setYellow();
	}
	public String toString(){
		return slotName;
	}
	@Override
	public void update(Observable o, Object arg) {
		if(!model.isEmpty(slotName)){
			setText(Double.toString(model.value(slotName)));
		}

	}
}