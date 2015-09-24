package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

//TODO move to another package
public class XLBufferedReader extends BufferedReader {
    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    // TODO Change Object to something appropriate
    public void load(Map<String, Object> map) {
        try {
            while (ready()) {
                String string = readLine();
                int i = string.indexOf('=');
                // TODO
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}
