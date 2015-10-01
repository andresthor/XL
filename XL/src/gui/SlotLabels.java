package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingConstants;

public class SlotLabels extends GridPanel implements Observer{
    private List<SlotLabel> labelList;
    private CurrentSlot currentSlot;

    
    public SlotLabels(int rows, int cols, CurrentSlot currentSlot) {
        super(rows + 1, cols);
        labelList = new ArrayList<SlotLabel>(rows * cols);

        this.currentSlot = currentSlot;

        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
                    SwingConstants.CENTER));
        }
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
                SlotLabel label = new SlotLabel(currentSlot, Character.toString(ch)+Integer.toString(row));
                add(label);
                labelList.add(label);
            }
        }
        SlotLabel firstLabel = labelList.get(0);
        firstLabel.setBackground(Color.YELLOW);
        currentSlot.set(firstLabel);
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}
}
