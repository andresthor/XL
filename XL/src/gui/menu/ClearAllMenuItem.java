package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

import model.*;

class ClearAllMenuItem extends JMenuItem implements ActionListener {
	XLModel model;
    public ClearAllMenuItem(XLModel model) {
        super("Clear all");
        this.model = model;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        model.clearAllSlots();
    }
}