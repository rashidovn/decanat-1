/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataInputOutputClasses;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roma
 */
public class DataIOTextToFile extends DataIO {

    public DataIOTextToFile() {
        super();
    }

    private static void writeTextToFile(String text) {
        try {
            try (Writer fw = new FileWriter("resultText.txt")) {
                fw.write(text);
                fw.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(DataIOSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
