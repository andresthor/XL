package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

public class StatusPanel extends BorderPanel {
    protected StatusPanel(StatusLabel statusLabel) {
        add(WEST, new CurrentLabel());
        add(CENTER, statusLabel);
    }
}