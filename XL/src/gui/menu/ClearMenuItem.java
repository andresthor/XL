package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import model.*;
import gui.*;

class ClearMenuItem extends JMenuItem implements ActionListener {
	CurrentSlot currentSlot;
	XLModel model;

    public ClearMenuItem(XLModel model, CurrentSlot currentSlot) {
        super("Clear");
        this.model = model;
        this.currentSlot = currentSlot;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        model.addSlot(currentSlot.toString(), "");
    }
}