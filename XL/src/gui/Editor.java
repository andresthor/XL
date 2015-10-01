package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.XLModel;

import javax.swing.JTextField;

public class Editor extends JTextField implements Observer, ActionListener {

	private XLModel model;
	private CurrentSlot currentSlot;
    private StatusLabel status;

    public Editor(CurrentSlot currentSlot, XLModel model) {
        setBackground(Color.WHITE);
        this.currentSlot = currentSlot;
        currentSlot.addObserver(this);
        this.model = model;
        addActionListener(this);
    }
	@Override
	public void update(Observable arg0, Object arg1) {
		if(!model.isEmpty(currentSlot.toString())){
			setText(model.getSlotString(currentSlot.toString()));
		}else{
			setText("");
		}
		
	}
	public void actionPerformed(ActionEvent e){
		String input = getText();		
		model.addSlot(currentSlot.toString(),input);
		//status.update(model,null);
	}

}