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
    	
    	try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)))) {
    		ArrayList<String> slots = xl.getSlots();
    		for(String st : slots){
    			writer.write(st + "\n");
    		}



        	if(path.toLowerCase().endsWith(".xl")) {
    			statusLabel.setText("The file was saved!");	
    		}else if(path.contains(".")){
    			statusLabel.setText("The file was saved but with an incorrect extension, consider changing it");
    		}else{
    			statusLabel.setText("The file was saved but without an extension, consider changing it");	
    		}
        }catch(IOException e){
      		System.out.print(e.getMessage());
        }
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}