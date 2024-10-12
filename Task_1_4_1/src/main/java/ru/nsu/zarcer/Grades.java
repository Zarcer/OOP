package ru.nsu.zarcer;

import java.util.ArrayList;

class Grades {
    private ArrayList<Integer> grades;
    private int max;
    Grades(int maxCnt){
        grades = new ArrayList<>();
        max=maxCnt;
    }

    public boolean addGrade(int number){
        if(grades.size()<max){
            grades.add(number);
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
        int marksValue = 0;
        for(Integer mark : grades){
            marksValue=marksValue+mark;
        }
        return marksValue;
    }

    public int getFiveMarksCnt() {
        int fiveMarksCnt = 0;
        for(Integer mark : grades){
            if(mark==5){
                fiveMarksCnt++;
            }
        }
        return fiveMarksCnt;
    }

    public ArrayList<Integer> getGrades(){
        return grades;
    }
}