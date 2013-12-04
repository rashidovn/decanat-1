/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ParserClasses;

import decanat.Student;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roma
 */
public class Parser {

    private static ArrayList<Student> parsedArray = new ArrayList<>();

    public Parser() {
    }

    public static void bufferParser(BufferedReader bfr, int numOfEntries) {



        int groupNumber = 0;
        double gradePointAverage = 0;
        String lastName = "";
        String firstName = "";
        Student entryId = new Student();
        for (int i = 0; i < numOfEntries; i++) {

            String entry = null;
            try {
                entry = bfr.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
            }
            String[] tokens = entry.split("[\\p{Punct}\\s]");
            lastName = tokens[0].trim();
            firstName = tokens[1].trim();
            try {
                groupNumber = Integer.parseInt(tokens[2].trim());
            } catch (NumberFormatException e) {
                System.out.println("group name must be a digit");
            }
            try {
                gradePointAverage = Double.parseDouble(tokens[3].trim());
            } catch (NumberFormatException e) {
                System.out.println("GPA name must be a digit");
            }
            entryId.setId();
            parsedArray.add(new Student(entryId.getId(), lastName, firstName, groupNumber, gradePointAverage));
        }


    }

    /**
     * @return the student
     */
    public static ArrayList<Student> getparsedArray() {
        return parsedArray;
    }

    /**
     * @param aStudent the student to set
     */
    public static void setparsedArray(ArrayList<Student> aparsedArray) {
        parsedArray = aparsedArray;
    }

    
}
