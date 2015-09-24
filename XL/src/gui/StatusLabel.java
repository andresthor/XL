package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public class StatusLabel extends ColoredLabel implements Observer {
    public StatusLabel() {
        super("", Color.WHITE);
    }

    public void update(Observable observable, Object object) {
        setText("");
    }
}