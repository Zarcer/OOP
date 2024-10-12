package ru.nsu.zarcer;

import java.util.HashMap;
import java.util.Map;

public class Semester {

    private Map<ElectronicBook.typeControl, Grades> records;

    public Semester(int taskRestriction, int testRestriction, int colloquiumRestriction, int examRestriction, int diffCreditRestriction, int creditRestriction, int practiceDefenceRestriction, int vkrRestriction) {
        records = new HashMap<>();
        records.put(ElectronicBook.typeControl.TASK, new Grades(taskRestriction));
        records.put(ElectronicBook.typeControl.TEST, new Grades(testRestriction));
        records.put(ElectronicBook.typeControl.COLLOQUIUM, new Grades(colloquiumRestriction));
        records.put(ElectronicBook.typeControl.EXAM, new Grades(examRestriction));
        records.put(ElectronicBook.typeControl.DIFF_CREDIT, new Grades(diffCreditRestriction));
        records.put(ElectronicBook.typeControl.CREDIT, new Grades(creditRestriction));
        records.put(ElectronicBook.typeControl.PRACTICE_DEFENCE, new Grades(practiceDefenceRestriction));
        records.put(ElectronicBook.typeControl.VKR, new Grades(vkrRestriction));
    }

    public boolean addGradeSemester(int grade, ElectronicBook.typeControl type){
        return records.get(type).addGrade(grade);
    }

    public int getMarksCnt() {
        int marksCnt = 0;
        for(Grades grade : records.values()){
            marksCnt = marksCnt+grade.getMarksCnt();
        }
        return marksCnt;
    }

    public int getFiveMarksCnt() {
        int fiveMarksCnt = 0;
        for(Grades grade : records.values()){
            fiveMarksCnt = fiveMarksCnt+grade.getFiveMarksCnt();
        }
        return fiveMarksCnt;
    }

    public int getMarksValue(){
        int marksValue = 0;
        for(Grades grade : records.values()){
            marksValue = marksValue+grade.getMarksValue();
        }
        return marksValue;
    }

    public boolean checkFinalMarks(int exam, int diffCredit){
        for(Integer grade : records.get(ElectronicBook.typeControl.EXAM).getGrades()){
            if(grade < exam){
                return false;
            }
        }
        for(Integer grade : records.get(ElectronicBook.typeControl.DIFF_CREDIT).getGrades()){
            if(grade<diffCredit){
                return false;
            }
        }
        return true;
    }


}
