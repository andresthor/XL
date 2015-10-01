package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import model.XLModel;

public class StatusLabel extends ColoredLabel implements Observer {
    XLModel model;
    public StatusLabel(XLModel model) {
        super("", Color.WHITE);
        this.model = model;
        model.addObserver(this);
    }

    public void update(Observable observable, Object object) {
        setText(model.getStatus()); 
    }
}