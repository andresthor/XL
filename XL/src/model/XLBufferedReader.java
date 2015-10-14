package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import util.XLException;

public class XLBufferedReader extends BufferedReader {
    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }
    public void load(Map<String, Slot> map, XLModel model) {
        try{
            while(ready()){
                String string = readLine();
                int i = string.indexOf('=');
                Slot newSlot = model.newSlot(string.substring(i+1));
                map.put(string.substring(0,i),newSlot);
            }
        } catch(Exception e){
            throw new XLException(e.getMessage());
        }
        /*try {
            while (ready()) {
                String string = readLine();
                int i = string.indexOf('=');
                model.addSlot(string.substring(0,i),string.substring(i+1));                
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }*/
        return;
    }
}
