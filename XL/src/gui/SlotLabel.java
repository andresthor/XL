package gui;

import java.awt.Color;
import java.awt.Event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SlotLabel extends ColoredLabel {
	
	private CurrentSlot currentSlot;
    public SlotLabel(CurrentSlot currentSlot) {	
        super("                    ", Color.WHITE, RIGHT);
        this.addMouseListener(new MyAdapter());
    }

	private class MyAdapter extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
        	System.out.println("222");
			SlotLabel.this.updateCurrent();
			System.out.print("gogo");
        }
	}
	protected void updateCurrent(){
		System.out.println("1");
		currentSlot.setWhite();
		System.out.print("2");
		currentSlot.set(this);
		System.out.print("3");
		currentSlot.setYellow();
		System.out.print("4");
	}
}