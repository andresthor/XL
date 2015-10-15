package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import model.XLModel;

/**
 * Colors the active slot that is being edited. 
 * @author Emil Westenius, Adam Jalkemo, Anton Friberg, Andrés Þór Sæmundsson.
 */
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