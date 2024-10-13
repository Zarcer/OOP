package ru.nsu.zarcer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class Grades {
    private HashMap<String, ArrayList<Integer>> grades;
    private int max;

    Grades(int maxCnt) {
        grades = new HashMap<>();
        max = maxCnt;
    }

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

    public int getMarksCnt() {
        return grades.values().stream().mapToInt(List::size).sum();
    }

    public int getMarksValue() {
        return grades.values().stream().flatMap(List::stream).mapToInt(Integer::intValue).sum();
    }

    public int getFiveMarksCnt() {
        return (int) grades.values().stream().flatMap(List::stream).filter(s -> s == 5).count();
    }

    public ArrayList<Integer> getGrades() {
        return (ArrayList<Integer>) grades.values().stream().flatMap(List::stream).collect(Collectors.toList());
    }
}