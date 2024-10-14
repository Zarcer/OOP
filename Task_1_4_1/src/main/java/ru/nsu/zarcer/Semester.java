package ru.nsu.zarcer;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for semester.
 */
public class Semester {

    private Map<ElectronicBook.TypeControl, Grades> records;

    /**Constructor with restrictions per semester.
     *
     * @param taskRestriction restriction
     *
     * @param testRestriction restriction
     *
     * @param colloquiumRestriction restriction
     *
     * @param examRestriction restriction
     *
     * @param diffCreditRestriction restriction
     *
     * @param creditRestriction restriction
     *
     * @param practiceDefenceRestriction restriction
     *
     * @param vkrRestriction restriction
     *
     */
    public Semester(int taskRestriction, int testRestriction,
                    int colloquiumRestriction, int examRestriction,
                    int diffCreditRestriction, int creditRestriction,
                    int practiceDefenceRestriction, int vkrRestriction) {
        records = new HashMap<>();
        records.put(ElectronicBook.TypeControl.TASK, new Grades(taskRestriction));
        records.put(ElectronicBook.TypeControl.TEST, new Grades(testRestriction));
        records.put(ElectronicBook.TypeControl.COLLOQUIUM, new Grades(colloquiumRestriction));
        records.put(ElectronicBook.TypeControl.EXAM, new Grades(examRestriction));
        records.put(ElectronicBook.TypeControl.DIFF_CREDIT, new Grades(diffCreditRestriction));
        records.put(ElectronicBook.TypeControl.CREDIT, new Grades(creditRestriction));
        records.put(ElectronicBook.TypeControl.PRACTICE_DEFENCE,
            new Grades(practiceDefenceRestriction));
        records.put(ElectronicBook.TypeControl.VKR, new Grades(vkrRestriction));
    }

    /**Adds grade to book, shell.
     *
     * @param grade from 1 to 5
     *
     * @param type type of assignment
     *
     * @param subject type of subject
     *
     * @return true if successful, false otherwise
     *
     */
    public boolean addGradeSemester(int grade, ElectronicBook.TypeControl type, String subject) {
        return records.get(type).addGrade(grade, subject);
    }

    /**Getter for marks cnt in this semester.
     *
     * @return just int
     *
     */
    public int getMarksCnt() {
        return records.values().stream().mapToInt(Grades::getMarksCnt).sum();
    }

    /**Getter for five marks cnt in this semester.
     *
     * @return just int
     */
    public int getFiveMarksCnt() {
        return records.values().stream().mapToInt(Grades::getFiveMarksCnt).sum();
    }

    /**Getter for marks value in this semester.
     *
     * @return just int
     */
    public int getMarksValue() {
        return records.values().stream().mapToInt(Grades::getMarksValue).sum();
    }

    /**Checks exam and diff credit values, because they are final usually.
     *
     * @param exam mark should be at least that number
     *
     * @param diffCredit mark should be at least that number
     *
     * @return true if they satisfied arguments
     *
     */
    public boolean checkFinalMarks(int exam, int diffCredit) {
        if (!records.get(ElectronicBook.TypeControl.EXAM)
            .getGrades().stream().allMatch(s -> s >= exam)) {
            return false;
        }
        return records.get(ElectronicBook.TypeControl.DIFF_CREDIT)
            .getGrades().stream().allMatch(s -> s >= exam);
    }
}
