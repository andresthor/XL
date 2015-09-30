package gui;

import java.awt.Color;
import javax.swing.JTextField;

public class Editor extends JTextField implements Observer {
    public Editor(CurrentSlot currentSlot) {
        setBackground(Color.WHITE);
    }
    public void update() {

    }
}