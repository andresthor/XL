package gui;

import java.awt.Color;
import java.awt.Event.*;

public class SlotLabel extends ColoredLabel {
    public SlotLabel(CurrentSlot currentSlot) {
        super("                    ", Color.WHITE, RIGHT);
    }

	private class MyAdapter extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
	
    }
}