package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class GradesTest {
    @Test
    public void addGradeTestAndGetMarksValue() {
        Grades testGrades = new Grades(1);
        testGrades.addGrade(5, "Math");
        assertEquals(5, testGrades.getMarksValue());
        assertFalse(testGrades.addGrade(5, "OOP"));
    }

    @Test
    public void getMarksCntTest() {
        Grades testGrades = new Grades(5);
        testGrades.addGrade(5, "Math");
        testGrades.addGrade(5, "Math");
        testGrades.addGrade(5, "Math");
        assertEquals(3, testGrades.getMarksCnt());
    }

    @Test
    public void getMarksFiveCntTest() {
        Grades testGrades = new Grades(5);
        testGrades.addGrade(5, "Math");
        testGrades.addGrade(5, "Math");
        assertEquals(2, testGrades.getFiveMarksCnt());
    }

    @Test
    public void getGradesTest() {
        Grades testGrades = new Grades(5);
        testGrades.addGrade(5, "Math");
        testGrades.addGrade(5, "Math");
        assertEquals(2, testGrades.getGrades().size());
    }

}