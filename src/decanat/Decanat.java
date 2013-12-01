
package decanat;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Decanat {
    
    public Decanat(){
        
    }
    private static int  numOfEntries = 0;
    private static int choice=0;
   
    public static void main(String[] args) throws IOException, ClassNotFoundException {
      
       ListSort listSort=new ListSort();
        ReadEntryFromConsole readConsole=new ReadEntryFromConsole();
        DataIO dataIO=new DataIO();
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter number of entries: ");
        try {
        numOfEntries = Integer.parseInt(in.next());
        }catch(NumberFormatException e) {
        System.out.println("you didn't type a digit");
        }
        System.out.println("Please write entries LASTNAME, FIRSTNAME, GROUP NUMBER,GPA, separated with comma, space, slash or other separator");
        readConsole.setListFromParseConsole(new BufferedReader(new InputStreamReader(System.in)), numOfEntries);
        System.out.println("--------------List of Students-------------");
        System.out.println(readConsole.getListFromParseConsole()+"/n");
        System.out.println("to sort list by last name, press: 1 ");
        System.out.println("to sort list by first name, press: 2 ");
        System.out.println("to sort list by grade point average, press: 3 ");
        System.out.println("to sort list by group, press: 4 ");
        System.out.println("to write to db, press: 5 ");
        System.out.println("to exit, press: 5 "+"/n");
      
        try {
         choice = in.nextInt();
          
        }catch(NumberFormatException e) {
        System.out.println("choice must be a digit");
        }
        switch(choice){
                    
              case 1:
                  listSort.sortByLastName(readConsole.getListFromParseConsole());
                  listSort.showSortedList();
                  dataIO.writeDataToFile(listSort.getSortedList(),new File ("data.dat"));
                  dataIO.readDataFromFile(new File ("data.dat"));
                  dataIO.showDataFromFile(new File ("data.dat"));
                  break;
              case 2:
                  System.out.println ("Students by firstName");
                  listSort.sortByFirstName(readConsole.getListFromParseConsole());
                  listSort.showSortedList();
                 dataIO.writeDataToFile(listSort.getSortedList(),new File ("data.dat"));
                  dataIO.readDataFromFile(new File ("data.dat"));
                  dataIO.showDataFromFile(new File ("data.dat"));
                   break;
              case 3:
                  System.out.println ("Students by Group");
                  listSort.sortByGroupNumber(readConsole.getListFromParseConsole());
                  listSort.showSortedList();
                  dataIO.writeDataToFile(listSort.getSortedList(),new File ("data.dat"));
                  dataIO.readDataFromFile(new File ("data.dat"));
                  dataIO.showDataFromFile(new File ("data.dat"));
                   break;
              case 4:
                  System.out.println ("Students by GradePointAverage");
                  listSort.sortByGradePointAverage(readConsole.getListFromParseConsole());
                   listSort.showSortedList();
                  dataIO.writeDataToFile(listSort.getSortedList(),new File ("data.dat"));
                  dataIO.readDataFromFile(new File ("data.dat"));
                  dataIO.showDataFromFile(new File ("data.dat"));
                   break;
              case 5:
                  DBconnection.openConnection();
                  DBconnection.createTableStudents();
                  DBconnection.insertDataToStudentsTable();
                  DBconnection.getResultList();
                  DBconnection.dropDB();
                  DBconnection.closeConnection(); 
              case 6:
                       System.out.println("Bye-bye");
                       System.exit(0);
        }
    
           //String dbPath = "jdbc:sqlite:C:\\Users\\Roma\\Documents\\NetBeansProjects\\Decanat\\database.db";
            
           
    
    
    
    }

   
  

    
  public static void setNumOfEntries(int numOfEntries){
       Decanat.numOfEntries = numOfEntries;
   
    }
    public static int getNumOfEntries(){
       return numOfEntries;
   
    }
    
    
    private static void setChoice(int choice){
       Decanat.choice = choice;
   
    }
    private static int getChoice(){
       return choice;
   
    }
   }

    

