/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package decanat;

import ComparatorClasses.ListSort;
import DataBaseClasses.DBconnection;
import DataBaseClasses.DBTableCommands;
import DataInputOutputClasses.DataIOSerialization;
import SeekingClasses.ListSeek;
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
    private ReadEntryFromConsole readConsole = new ReadEntryFromConsole();
    private ListSeek listSeek = new ListSeek();

    public UserChoiceMenu() {
    }

    public void MenuSelect() throws IOException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of entries: ");
        try {
            numOfEntries = Integer.parseInt(in.next());
        } catch (NumberFormatException e) {
            System.out.println("you didn't type a digit");
        }

        System.out.println("Please write entries LASTNAME, FIRSTNAME, GROUP NUMBER,GPA, separated with comma, space, slash or other separator");
        readConsole.setListFromParseConsole(new BufferedReader(new InputStreamReader(System.in)), numOfEntries);
        System.out.println("--------------List of Students-------------");
        System.out.println(readConsole.getListFromParseConsole());
        System.out.println("to sort list by last name, press: 1 ");
        System.out.println("to sort list by first name, press: 2 ");
        System.out.println("to sort list by grade point average, press: 3 ");
        System.out.println("to sort list by group, press: 4 ");
        System.out.println("to write to db, press: 5 ");
        System.out.println("to seek by last name, press: 6 ");

        try {
            choice = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("choice must be a digit");
        }
        switch (choice) {
            case 1:
                listSort.sortByLastName(readConsole.getListFromParseConsole());
                listSort.showSortedList();
                dataIO.writeDataToFile(listSort.getSortedList(), new File("data.dat"));
                dataIO.readDataFromFile(new File("data.dat"));
                dataIO.showDataFromFile(new File("data.dat"));
                break;
            case 2:
                System.out.println("Students by firstName");
                listSort.sortByFirstName(readConsole.getListFromParseConsole());
                listSort.showSortedList();
                dataIO.writeDataToFile(listSort.getSortedList(), new File("data.dat"));
                dataIO.readDataFromFile(new File("data.dat"));
                dataIO.showDataFromFile(new File("data.dat"));
                break;
            case 3:
                System.out.println("Students by Group");
                listSort.sortByGroupNumber(readConsole.getListFromParseConsole());
                listSort.showSortedList();
                dataIO.writeDataToFile(listSort.getSortedList(), new File("data.dat"));
                dataIO.readDataFromFile(new File("data.dat"));
                dataIO.showDataFromFile(new File("data.dat"));

                break;
            case 4:
                System.out.println("Students by GradePointAverage");
                listSort.sortByGradePointAverage(readConsole.getListFromParseConsole());
                listSort.showSortedList();
                dataIO.writeDataToFile(listSort.getSortedList(), new File("data.dat"));
                dataIO.readDataFromFile(new File("data.dat"));
                dataIO.showDataFromFile(new File("data.dat"));
                break;
            case 5:
                DBconnection.openConnection();
                DBTableCommands.createTables();
                DBTableCommands.insertDataToStudentsTable();
                DBTableCommands.getResultList();
                DBTableCommands.dropDB();
                DBconnection.closeConnection();
            case 6:
                System.out.println("Seek by last name");
                Scanner sc = new Scanner(System.in);
                System.out.print("input last name: ");
                String lastName = sc.next();
                sc.close();
                listSeek.seekByLastName(readConsole.getListFromParseConsole(), lastName);
                listSeek.showSeekedList();



        }

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
     * @param in the in to set
     */
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

    public ReadEntryFromConsole getReadConsole() {
        return readConsole;

    }
}
