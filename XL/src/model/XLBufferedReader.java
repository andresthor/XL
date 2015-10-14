package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import util.XLException;

/**
 * An <code>XLBufferedReader<code>  reads text from a character input stream
 * and extends the functionality of <code>BufferedReader<code>
 * @author Emil Westenius, Adam Jalkemo, Anton Friberg, Andrés Þór Sæmundsson. 
 */
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
        return;
    }
}
