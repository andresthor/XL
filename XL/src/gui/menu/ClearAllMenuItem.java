package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

class ClearAllMenuItem extends JMenuItem implements ActionListener {
    public ClearAllMenuItem() {
        super("Clear all");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // TODO
    }
}