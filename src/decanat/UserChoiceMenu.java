/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package decanat;

import ComparatorClasses.ListSort;
import DataBaseClasses.DBconnection;
import DataBaseClasses.DBTableCommands;
import DataInputOutputClasses.DataIOSerialization;
import ParserClasses.Parser;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Roma
 */
public class UserChoiceMenu {

    
    private ListSort listSort = new ListSort();
    private DataIOSerialization dataIO = new DataIOSerialization();
    Parser  readConsole = new Parser();

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
                    DBconnection.openConnection();
                    DBTableCommands.createTableStudents();
                    DBTableCommands.insertDataToDB(Parser.getparsedArray());
                    DBTableCommands.getDataFromDB();
                    //DBTableCommands.dropDB();
                    DBconnection.closeConnection();
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
}
