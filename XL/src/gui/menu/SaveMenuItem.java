package gui.menu;

import gui.StatusLabel;
import gui.XL;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import java.io.*;

class SaveMenuItem extends OpenMenuItem {
    public SaveMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Save");
    }

    protected void action(String path) throws FileNotFoundException {
    	if(!path.toLowerCase().endsWith(".xl")){
    		if(!path.contains(("."))){

    			//LÄGGA TILL ATT FILEN INTE HAR EN EXTENSION OCH INTE KAN ÖPPNAS?
    			try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)))) {

        			writer.write("");

        		}catch(IOException e){
      				System.out.print(e.getMessage());
        		}
    		}
    	}
    	//LÄGGA TILL ATT FILEN HAR FEL EXTENSION OCH INTE KAN ÖPPNAS?
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}