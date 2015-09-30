package gui;

import java.awt.Color;
import java.awt.Event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SlotLabel extends ColoredLabel {
	
	private CurrentSlot currentSlot;
    public SlotLabel(CurrentSlot currentSlot) {
        super("                    ", Color.WHITE, RIGHT);
    }

	private class MyAdapter extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
	
        }
	}
}