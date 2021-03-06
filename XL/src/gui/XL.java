package gui;

import static java.awt.BorderLayout.CENTER;
import model.*;

import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;

import gui.menu.XLMenuBar;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The view and controller for the XL program that implements the model-view-
 * controller architecture. Handles the displayed information and the inputs 
 * made by the user. 
 * @author Emil Westenius, Adam Jalkemo, Anton Friberg, Andrés Þór Sæmundsson.
 */
public class XL extends JFrame implements Printable {
    private static final int ROWS = 10, COLUMNS = 8;
    private XLCounter counter;
    private XLList xlList;
    private XLModel model;
    private StatusLabel statusLabel;

    /**
     * Shortened constructor. 
     * @param oldXL 
     */
    public XL(XL oldXL) {
        this(oldXL.xlList, oldXL.counter);
    }

    /**
     * The constructor for the gui. 
     * @param xlList
     *          List of all running gui's. 
     * @param counter
     *          Number of running gui's
     */
    public XL(XLList xlList, XLCounter counter) {
        super("Untitled-" + counter);
        this.xlList = xlList;
        this.counter = counter;
        xlList.add(this);
        counter.increment();
        model = new XLModel();
        statusLabel = new StatusLabel(model);
        CurrentSlot currentSlot = new CurrentSlot();
        JPanel statusPanel = new StatusPanel(statusLabel, currentSlot);
        JPanel sheetPanel = new SheetPanel(ROWS, COLUMNS, currentSlot,model);
        Editor editor = new Editor(currentSlot,model);
        add(NORTH, statusPanel);
        add(CENTER, editor);
        add(SOUTH, sheetPanel);
        setJMenuBar(new XLMenuBar(this, xlList, statusLabel, model, currentSlot));
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Handles the printing of the slotpanel. 
     * @param g
     *      Graphics to be printed.
     * @param pageFormat
     *      The format for the print. 
     * @param page
     *      The number of pages to be printed. 
     * @return 
     */
    public int print(Graphics g, PageFormat pageFormat, int page) {
        if (page > 0)
            return NO_SUCH_PAGE;
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        printAll(g2d);
        return PAGE_EXISTS;
    }

    public void rename(String title) {
        setTitle(title);
        xlList.setChanged();
    }

    public static void main(String[] args) {
        new XL(new XLList(), new XLCounter());
    }
    public XLModel getModel(){
        return model;
    }
}