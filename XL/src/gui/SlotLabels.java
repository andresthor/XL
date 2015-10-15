package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import model.XLModel;
import javax.swing.SwingConstants;

/**
 * Iterates through the information in the model and displays the slots in
 * the grid. 
 * @author Emil Westenius, Adam Jalkemo, Anton Friberg, Andrés Þór Sæmundsson.
 */
public class SlotLabels extends GridPanel{
    private List<SlotLabel> labelList;
    private CurrentSlot currentSlot;

    
    public SlotLabels(int rows, int cols, CurrentSlot currentSlot, XLModel model) {
        super(rows + 1, cols);
        labelList = new ArrayList<SlotLabel>(rows * cols);

        this.currentSlot = currentSlot;

        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
                    SwingConstants.CENTER));
        }
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
                SlotLabel label = new SlotLabel(currentSlot, Character.toString(ch)+Integer.toString(row) , model);
                add(label);
                labelList.add(label);
            }
        }
        SlotLabel firstLabel = labelList.get(0);
        firstLabel.setBackground(Color.YELLOW);
        currentSlot.set(firstLabel);
    }
}
