package ru.nsu.zarcer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for grades per assignment.
 */
class Grades {
    private HashMap<String, ArrayList<Integer>> grades;
    private int max;

    /**Constructor with restriction.
     *
     * @param maxCnt restriction
     *
     */
    Grades(int maxCnt) {
        grades = new HashMap<>();
        max = maxCnt;
    }

    /**Adds grade to book.
     *
     * @param number from 1 to 5
     *
     * @param subject type of subject
     *
     * @return true if successful, false otherwise
     *
     */
    public boolean addGrade(int number, String subject) {
        if (!grades.containsKey(subject)) {
            grades.put(subject, new ArrayList<>());
        }
        if (grades.values().stream().mapToInt(List::size).sum() < max) {
            grades.get(subject).add(number);
            return true;
        } else {
            return false;
        }
    }

    /**Getter for marks cnt in this assignment and semester.
     *
     * @return just int
     *
     */
    public int getMarksCnt() {
        return grades.values().stream().mapToInt(List::size).sum();
    }

    /**Getter for marks values in this assignment and semester.
     *
     * @return just int
     *
     */
    public int getMarksValue() {
        return grades.values().stream().flatMap(List::stream).mapToInt(Integer::intValue).sum();
    }

    /**Getter for five marks cnt in this assignment and semester.
     *
     * @return just int
     *
     */
    public int getFiveMarksCnt() {
        return (int) grades.values().stream().flatMap(List::stream).filter(s -> s == 5).count();
    }

    /**Getter for list of grades in this assignment and semester.
     *
     * @return just list with integers
     *
     */
    public ArrayList<Integer> getGrades() {
        return (ArrayList<Integer>) grades.values().stream()
            .flatMap(List::stream).collect(Collectors.toList());
    }
}