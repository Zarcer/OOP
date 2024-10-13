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

    public boolean addGradeSemester(int grade, ElectronicBook.typeControl type, String subject) {
        return records.get(type).addGrade(grade, subject);
    }

    public int getMarksCnt() {
        return records.values().stream().mapToInt(Grades::getMarksCnt).sum();
    }

    public int getFiveMarksCnt() {
        return records.values().stream().mapToInt(Grades::getFiveMarksCnt).sum();
    }

    public int getMarksValue() {
        return records.values().stream().mapToInt(Grades::getMarksValue).sum();
    }

    public boolean checkFinalMarks(int exam, int diffCredit) {
        if (!records.get(ElectronicBook.typeControl.EXAM).getGrades().stream().allMatch(s -> s >= exam)) {
            return false;
        }
        return records.get(ElectronicBook.typeControl.DIFF_CREDIT).getGrades().stream().allMatch(s -> s >= exam);
    }
}
