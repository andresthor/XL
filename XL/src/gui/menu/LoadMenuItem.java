package gui.menu;

import gui.StatusLabel;
import gui.XL;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import util.*;

class LoadMenuItem extends OpenMenuItem {
 
    public LoadMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Load");
    }

    protected void action(String path) throws FileNotFoundException {
        try{
            xl.getModel().load(path);    
        }catch(XLException e){
            //statusLabel.setText(e.getMessage());
            throw new FileNotFoundException(e.getMessage());
        }
        
        statusLabel.setText("File was loaded");
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}