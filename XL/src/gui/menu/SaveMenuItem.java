package gui.menu;

import gui.StatusLabel;
import gui.XL;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import java.io.*;
import java.util.ArrayList;

class SaveMenuItem extends OpenMenuItem {
    public SaveMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Save");
    }

    protected void action(String path) throws FileNotFoundException {
    	
    	xl.getModel().save(path);

      if(path.toLowerCase().endsWith(".xl")) {
   			statusLabel.setText("The file was saved!");	
   		}else if(path.contains(".")){
   			statusLabel.setText("The file was saved but with an incorrect extension, consider changing it");
    	}else{
    			statusLabel.setText("The file was saved but without an extension, consider changing it");
    	}
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}