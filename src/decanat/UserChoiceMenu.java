/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package decanat;

import ComparatorClasses.ListSort;
import DataBaseClasses.DBconnection;
import DataBaseClasses.DBTableCommands;
import DataInputOutputClasses.DataIOSerialization;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Roma
 */
public class UserChoiceMenu {

    private static int numOfEntries = 0;
    private int choice = 0;
    private Scanner in = new Scanner(System.in);
    private ListSort listSort = new ListSort();
    private DataIOSerialization dataIO = new DataIOSerialization();
    ReadEntryFromConsole readConsole = new ReadEntryFromConsole();

    public UserChoiceMenu() {
    }

    public void MenuSelect() throws IOException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of entries: ");
        try {
            setNumOfEntries(Integer.parseInt(in.next()));
        } catch (NumberFormatException e) {
            System.out.println("you didn't type a digit");
        }
        System.out.println("Please write entries LASTNAME, FIRSTNAME, GROUP NUMBER,GPA, separated with comma, space, slash or other separator");
        readConsole.setListFromParseConsole(new BufferedReader(new InputStreamReader(System.in)), getNumOfEntries());
        System.out.println("--------------List of Students-------------");
        System.out.println(readConsole.getListFromParseConsole() + "/n");
        System.out.println("to sort list by last name, press: 1 ");
        System.out.println("to sort list by first name, press: 2 ");
        System.out.println("to sort list by grade point average, press: 3 ");
        System.out.println("to sort list by group, press: 4 ");
        System.out.println("to write to db, press: 5 ");
        System.out.println("to exit, press: 5 " + "/n");

        try {
            setChoice(in.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("choice must be a digit");
        }
        switch (getChoice()) {
            case 1:
                getListSort().sortByLastName(readConsole.getListFromParseConsole());
                getListSort().showSortedList();
                getDataIO().writeDataToFile(getListSort().getSortedList(), new File("data.dat"));
                getDataIO().readDataFromFile(new File("data.dat"));
                getDataIO().showDataFromFile(new File("data.dat"));
                break;
            case 2:
                System.out.println("Students by firstName");
                getListSort().sortByFirstName(readConsole.getListFromParseConsole());
                getListSort().showSortedList();
                getDataIO().writeDataToFile(getListSort().getSortedList(), new File("data.dat"));
                getDataIO().readDataFromFile(new File("data.dat"));
                getDataIO().showDataFromFile(new File("data.dat"));
                break;
            case 3:
                System.out.println("Students by Group");
                getListSort().sortByGroupNumber(readConsole.getListFromParseConsole());
                getListSort().showSortedList();
                getDataIO().writeDataToFile(getListSort().getSortedList(), new File("data.dat"));
                getDataIO().readDataFromFile(new File("data.dat"));
                getDataIO().showDataFromFile(new File("data.dat"));
                break;
            case 4:
                System.out.println("Students by GradePointAverage");
                getListSort().sortByGradePointAverage(readConsole.getListFromParseConsole());
                getListSort().showSortedList();
                getDataIO().writeDataToFile(getListSort().getSortedList(), new File("data.dat"));
                getDataIO().readDataFromFile(new File("data.dat"));
                getDataIO().showDataFromFile(new File("data.dat"));
                break;
            case 5:
                DBconnection.openConnection();
                DBTableCommands.createTableStudents();
                DBTableCommands.insertDataToStudentsTable();
                DBTableCommands.getResultList();
                DBTableCommands.dropDB();
                DBconnection.closeConnection();
            case 6:
                System.out.println("Bye-bye");
                System.exit(0);
        }
        in.close();
    }

    public void setChoice(int choice) {
        this.choice = choice;

    }

    public int getChoice() {
        return choice;

    }

    /**
     * @return the numOfEntries
     */
    public static int getNumOfEntries() {
        return numOfEntries;
    }

    /**
     * @param aNumOfEntries the numOfEntries to set
     */
    public static void setNumOfEntries(int aNumOfEntries) {
        numOfEntries = aNumOfEntries;
    }

    /**
     * @return the in
     */
    public Scanner getIn() {
        return in;
    }

    /**
     * @param in the in to set
     */
    public void setIn(Scanner in) {
        this.in = in;
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
