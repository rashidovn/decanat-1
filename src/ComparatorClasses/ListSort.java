/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComparatorClasses;

import decanat.Student;
import java.util.ArrayList;
import java.util.Collections;

public class ListSort {

    private ArrayList<Student> sortedList = new ArrayList<>();

    public ListSort() {
    }

    public void sortByLastName(ArrayList<Student> sortingList) {
        Collections.sort(sortingList, new SortedByLastNameComparator());
        setSortedList(sortingList);
    }

    public void sortByFirstName(ArrayList<Student> sortingList) {
        Collections.sort(sortingList, new SortedByFirstNameComparator());
        setSortedList(sortingList);
    }

    public void sortByGroupNumber(ArrayList<Student> sortingList) {
        Collections.sort(sortingList, new SortedByGradePointAverageComparator());
        setSortedList(sortingList);
    }

    public void sortByGradePointAverage(ArrayList<Student> sortingList) {
        Collections.sort(sortingList, new SortedByGradePointAverageComparator());
        setSortedList(sortingList);

    }

    public ArrayList<Student> getSortedList() {
        return sortedList;
    }

    public void showSortedList() {
        System.out.println("Students sorted by lastName");
        for (Student p : getSortedList()) {
            System.out.println(p);
        }

    }

    public void setSortedList(ArrayList<Student> sortedList) {
        this.sortedList = sortedList;
    }

    @Override
    public String toString() {
        Student p = new Student();
        return " ID: " + p.getId() + ", LastName: " + p.getLastName() + ", first name: " + p.getFirstName() + ", Group: " + p.getGroupNumber() + ", GPA= " + String.format("%4.2f", p.getGradePointAverage());
    }
}