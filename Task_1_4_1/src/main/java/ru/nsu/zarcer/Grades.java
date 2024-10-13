package ru.nsu.zarcer;

import java.util.ArrayList;
import java.util.HashMap;

class Grades {
    private HashMap<String, Integer> grades;
    private int max;
    Grades(int maxCnt){
        grades = new HashMap<>();
        max=maxCnt;
    }

    public boolean addGrade(int number, String subject){
        if(grades.size()<max){
            grades.put(subject, number);
            return true;
        }
        else {
            return false;
        }
    }

    public int getMarksCnt(){
        return grades.size();
    }

    public int getMarksValue(){
        return grades.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int getFiveMarksCnt() {
        return (int)grades.values().stream().filter(s->s==5).count();
    }

    public ArrayList<Integer> getGrades(){
        return (ArrayList<Integer>) grades.values();
    }
}