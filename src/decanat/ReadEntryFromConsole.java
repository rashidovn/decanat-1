package decanat;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadEntryFromConsole {

    private BufferedReader bfr;
    private int numOfEntries;
    private ArrayList<Student> student = new ArrayList<>();
    private int groupNumber = 0;
    private double gradePointAverage = 0;

    public ReadEntryFromConsole(BufferedReader bfr, int numOfEntries) {
        this.bfr = bfr;
        this.numOfEntries = numOfEntries;
    }

    public ReadEntryFromConsole() {
    }

    public void setListFromParseConsole(BufferedReader bfr, int numOfEntries) {

        Student entryId = new Student();
        for (int i = 0; i < numOfEntries; i++) {

            String entry = null;
            try {
                
                entry = bfr.readLine();
            } catch (IOException ex) {
                Logger.getLogger(ReadEntryFromConsole.class.getName()).log(Level.SEVERE, null, ex);
            }
            String[] tokens = entry.split("[\\p{Punct}\\s]");
            String lastName = tokens[0].trim();
            String firstName = tokens[1].trim();
            try {
                if(!entry.equals(" "))
                {
                setGroupNumber(Integer.parseInt(tokens[2].trim()));
                }
                else{
                   
                    groupNumber=0;
                }
            
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("group name must be a digit. Value has been set to null");
            }
            try {
                if(!entry.isEmpty())
                {
                setGradePointAverage(Double.parseDouble(tokens[3].trim()));
                }
                else{
                   
                    gradePointAverage = 0;
                }
            } catch (NumberFormatException e) {
                System.out.println("GPA name must be a digit. Value has been set to null");
            }


            entryId.setId();
           student.add(new Student(entryId.getId(), lastName, firstName, getGroupNumber(), getGradePointAverage()));
        }

    }

    /**
     * @return the bfr
     */
    public BufferedReader getBfr() {
        return bfr;
    }

    /**
     * @param bfr the bfr to set
     */
    public void setBfr(BufferedReader bfr) {
        this.bfr = bfr;
    }

    /**
     * @return the numOfEntries
     */
    public int getNumOfEntries() {
        return numOfEntries;
    }

    /**
     * @param numOfEntries the numOfEntries to set
     */
    public void setNumOfEntries(int numOfEntries) {
        this.numOfEntries = numOfEntries;
    }

    /**
     * @return the student
     */
    public ArrayList<Student> getListFromParseConsole() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setListFromParseConsole(ArrayList<Student> student) {
        this.student = student;
    }

    /**
     * @return the groupNumber
     */
    public int getGroupNumber() {
        return groupNumber;
    }

    /**
     * @param groupNumber the groupNumber to set
     */
    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    /**
     * @return the gradePointAverage
     */
    public double getGradePointAverage() {
        return gradePointAverage;
    }

    /**
     * @param gradePointAverage the gradePointAverage to set
     */
    public void setGradePointAverage(double gradePointAverage) {
        this.gradePointAverage = gradePointAverage;
    }


    
}
