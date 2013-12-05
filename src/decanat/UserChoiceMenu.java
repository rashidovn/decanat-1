/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package decanat;

import ComparatorClasses.ListSort;
import DataBaseClasses.Factory;
import DataInputOutputClasses.DataIOSerialization;
import ParserClasses.Parser;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roma
 */
public class UserChoiceMenu {

    private Student student = new  Student();
    private ListSort listSort = new ListSort();
    private DataIOSerialization dataIO = new DataIOSerialization();
    
    

    public UserChoiceMenu() {
    }

    public void MenuSelect() throws IOException, ClassNotFoundException {
        int numOfEntries = 0;
        int choice = 0;
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter number of entries: ");
            try {
             numOfEntries= Integer.parseInt(in.next());
            } catch (NumberFormatException e) {
                System.out.println("you didn't type a digit");
            }
            System.out.println("Please write entries LASTNAME, FIRSTNAME, GROUP NUMBER,GPA, separated with comma, space, slash or other separator");
            Parser.bufferParser(new BufferedReader(new InputStreamReader(System.in)), numOfEntries);
            System.out.println("--------------List of Students-------------");
            System.out.println(Parser.getparsedArray()  );
            System.out.println("to sort list by last name, press: 1 ");
            System.out.println("to sort list by first name, press: 2 ");
            System.out.println("to sort list by grade point average, press: 3 ");
            System.out.println("to sort list by group, press: 4 ");
            System.out.println("to write to db, press: 5 ");
            System.out.println("to exit, press: 6  ");

            try {
                choice=in.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("choice must be a digit");
            }
            switch (choice) {
                case 1:
                    getListSort().sortByLastName(Parser.getparsedArray());
                    getListSort().showSortedList();
                    getDataIO().writeDataToFile(getListSort().getSortedList(), new File("data.dat"));
                    getDataIO().readDataFromFile(new File("data.dat"));
                    getDataIO().showDataFromFile(new File("data.dat"));
                    break;
                case 2:
                    System.out.println("Students by firstName");
                    getListSort().sortByFirstName(Parser.getparsedArray());
                    getListSort().showSortedList();
                    getDataIO().writeDataToFile(getListSort().getSortedList(), new File("data.dat"));
                    getDataIO().readDataFromFile(new File("data.dat"));
                    getDataIO().showDataFromFile(new File("data.dat"));
                    break;
                case 3:
                    System.out.println("Students by Group");
                    getListSort().sortByGroupNumber(Parser.getparsedArray());
                    getListSort().showSortedList();
                    getDataIO().writeDataToFile(getListSort().getSortedList(), new File("data.dat"));
                    getDataIO().readDataFromFile(new File("data.dat"));
                    getDataIO().showDataFromFile(new File("data.dat"));
                    break;
                case 4:
                    System.out.println("Students by GradePointAverage");
                    getListSort().sortByGradePointAverage(Parser.getparsedArray());
                    getListSort().showSortedList();
                    getDataIO().writeDataToFile(getListSort().getSortedList(), new File("data.dat"));
                    getDataIO().readDataFromFile(new File("data.dat"));
                    getDataIO().showDataFromFile(new File("data.dat"));
                    break;
                case 5:
                    try {
                        Factory.getInstance().getActionMethods().insertStudent(Parser.getparsedArray());
                    } catch (SQLException ex) {
                        Logger.getLogger(UserChoiceMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    showListFromDB();
                
                case 6:
                    System.out.println("Bye-bye");
                default:
                    System.exit(0);
            }
        }
    }

    /**
     * @return the listSort
     */
    public ListSort getListSort() {
        return listSort;
    }

    /**
     * @param listSort the listSort to set
     */
    public void setListSort(ListSort listSort) {
        this.listSort = listSort;
    }
    public void showListFromDB() {
        List result = null;
        try {
            result = Factory.getInstance().getActionMethods().getAllStudents();
        } catch (SQLException ex) {
            Logger.getLogger(UserChoiceMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Object r: result)
            System.out.println(r);
        
    }
    /**
     * @return the dataIO
     */
    public DataIOSerialization getDataIO() {
        return dataIO;
    }

    /**
     * @param dataIO the dataIO to set
     */
    public void setDataIO(DataIOSerialization dataIO) {
        this.dataIO = dataIO;
    }
    
    @Override
    public String toString() {
        return " ID: " + student.getId() + ", LastName: " + student.getLastName() + ", first name: " + student.getFirstName() + ", Group: " + student.getGroupNumber() + ", GPA= " + String.format("%4.2f", student.getGradePointAverage());
    }
    
    
}
