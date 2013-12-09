package DataInputOutputClasses;

import decanat.Student;
import java.io.*;
import java.util.ArrayList;

public class DataIOSerialization extends DataIO {
    // private ArrayList<Person> writeData = new ArrayList<Person>();

    // 
    public DataIOSerialization() {
    }

    public void writeDataToFile(Object writeData, File data) throws IOException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(data));
            oos.writeObject(writeData);
            System.out.println("-----Writing data to file-------");
        } catch (IOException e) {
        } finally {
            oos.close();
        }

    }

    public ArrayList<Student> readDataFromFile(File data) throws IOException, ClassNotFoundException {
        ArrayList<Student> readData = new ArrayList<Student>();
        ObjectInputStream inf = null;
        try {
            inf = new ObjectInputStream(new FileInputStream(data));
            readData = (ArrayList<Student>) inf.readObject();
        } catch (FileNotFoundException e) {
        } finally {
            inf.close();
        }
        return readData;
    }

    public void showDataFromFile(File data) throws IOException, ClassNotFoundException {
        System.out.println("-----List from file-------");
        for (Student p : readDataFromFile(data)) {
            System.out.println(p);
        }
    }

    @Override
    public String toString() {
        Student p = new Student();
        return " ID: " + p.getId() + ", Last Name: " + p.getLastName() + ", First name: " + p.getFirstName() + ", Group: " + p.getGroupNumber() + ", GPA= " + String.format("%4.2f", p.getGradePointAverage());
    }
}