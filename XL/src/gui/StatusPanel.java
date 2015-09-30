package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

public class StatusPanel extends BorderPanel {
    protected StatusPanel(StatusLabel statusLabel, CurrentSlot currentSlot) {
        add(WEST, new CurrentLabel(currentSlot));
        add(CENTER, statusLabel);
    }
}