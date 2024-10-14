package ru.nsu.zarcer;

import java.util.ArrayList;
import java.util.List;

/**
 * Class of book itself.
 */
public class ElectronicBook {
    private List<Semester> semesters;

    /**
     * Constructor with restrictions per control and semester.
     */
    ElectronicBook() {
        semesters = new ArrayList<>();
        semesters.add(new Semester(2, 3, 1, 3, 3, 3, 0, 0));
        semesters.add(new Semester(2, 3, 1, 3, 3, 2, 0, 0));
        semesters.add(new Semester(3, 2, 0, 2, 6, 0, 0, 0));
        semesters.add(new Semester(2, 1, 0, 5, 5, 0, 0, 0));
        semesters.add(new Semester(2, 2, 0, 3, 4, 0, 0, 0));
        semesters.add(new Semester(2, 2, 0, 2, 6, 0, 0, 0));
        semesters.add(new Semester(2, 0, 0, 1, 4, 1, 1, 0));
        semesters.add(new Semester(0, 0, 0, 0, 0, 0, 0, 1));
    }

    /**Adds grade to book.
     *
     * @param semesterNumber int number of semester
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
    public boolean addGradeBook(int semesterNumber, int grade, TypeControl type, String subject) {
        return semesters.get(semesterNumber - 1)
            .addGradeSemester(grade, type, subject);
    }

    /**Arithmetic medium.
     *
     * @return just double
     *
     */
    public double averageGrade() {
        int totalMarks = semesters.stream()
            .mapToInt(Semester::getMarksCnt).sum();
        int totalValueMarks = semesters.stream()
            .mapToInt(Semester::getMarksValue).sum();
        if (totalMarks == 0) {
            return 0;
        }
        return (double) totalValueMarks / totalMarks;
    }

    /**Checks can person go to free education.
     *
     * @param currentSemester number of current semester
     *
     * @return true if person can, false otherwise
     *
     */
    public boolean checkPaidFree(int currentSemester) {
        if (currentSemester == 1 || currentSemester == 2) {
            return false;
        }
        return (semesters.get(currentSemester - 3)
            .checkFinalMarks(4, 3) && semesters
            .get(currentSemester - 2).checkFinalMarks(4, 3));
    }

    /**Checks if person can get red diploma.
     *
     * @param currentSemester number of current semester
     *
     * @return true if person can, false otherwise
     *
     */
    public boolean checkRedDiploma(int currentSemester) {
        if (currentSemester == 8) {
            if (semesters.get(7).getMarksValue() != 5) {
                return false;
            }
        }
        if (!semesters.stream().limit(currentSemester).allMatch(s -> s.checkFinalMarks(4, 4))) {
            return false;
        }
        int totalMarks = semesters.stream().limit(currentSemester)
            .mapToInt(Semester::getMarksCnt).sum();
        if (totalMarks == 0) {
            return false;
        }
        int totalFiveMarks = semesters.stream().limit(currentSemester)
            .mapToInt(Semester::getFiveMarksCnt).sum();
        return !(((double) totalFiveMarks / totalMarks) < 0.75);
    }

    /**Checks if person can get increased scholarship.
     *
     * @param currentSemester number of current semester
     *
     * @return true if person can, false otherwise
     *
     */
    public boolean increasedScholarship(int currentSemester) {
        if (currentSemester == 1 || currentSemester == 2) {
            return false;
        }
        return (semesters.get(currentSemester - 3)
            .checkFinalMarks(5, 5) && semesters
            .get(currentSemester - 2).checkFinalMarks(5, 5));
    }

    /**Just getter for semesters.
     *
     * @return list of semesters
     *
     */
    public List<Semester> getSemesters() {
        return semesters;
    }

    /**
     * Enum class for types of assignments.
     */
    public enum TypeControl {
        TASK,
        TEST,
        COLLOQUIUM,
        EXAM,
        DIFF_CREDIT,
        CREDIT,
        PRACTICE_DEFENCE,
        VKR;
    }
}

