 
package decanat;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;


public class ReadEntryFromConsole {
    private BufferedReader bfr;
    private int numOfEntries;
    private ArrayList<Student> student = new ArrayList<>();
    private int groupNumber=0;
    private double gradePointAverage=0;
    public ReadEntryFromConsole(BufferedReader bfr, int numOfEntries){
        this.bfr=bfr;
        this.numOfEntries=numOfEntries;
    }
    public ReadEntryFromConsole(){
        
    }
           
public void setListFromParseConsole(BufferedReader bfr,int numOfEntries ) throws IOException{
            
             Student entryId = new Student();
             for(int i=0; i<numOfEntries;i++){
              
             String entry = bfr.readLine();
             String[]tokens = entry.split("[\\p{Punct}\\s]");
             String lastName = tokens[0].trim();
             String firstName = tokens[1].trim();
             try {
             groupNumber = Integer.parseInt(tokens[2].trim()); 
             }catch(NumberFormatException e) {
             System.out.println("group name must be a digit");
             }
             try {
              gradePointAverage = Double.parseDouble(tokens[3].trim());
             }catch(NumberFormatException e) {
             System.out.println("GPA name must be a digit");
             }
             
             
             entryId.setId();
             student.add (new Student(entryId.getId(),lastName,firstName,groupNumber,gradePointAverage));
             }
             
}

 public ArrayList<Student> getListFromParseConsole(){
     
     return student;
 }
 public BufferedReader getBfr(){
     return bfr;
 }
 public int getNumOfEntries(){
     return numOfEntries;
 }
 public void setBfr(BufferedReader bfr){
     this.bfr=bfr;
 }
 public void setNumOfEntries(int numOfEntries){
     this.numOfEntries=numOfEntries;
 }
}
