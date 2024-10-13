package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SemesterTest {

    @Test
    public void addGradeSemesterTestAndGetValueTest() {
        Semester semesterTest = new Semester(2,
            3, 1, 3,
            3, 3,
            0, 0);
        semesterTest.addGradeSemester(5, ElectronicBook.typeControl.TASK, "Math");
        assertEquals(5, semesterTest.getMarksValue());
    }

    @Test
    public void getMarksCntTest() {
        Semester semesterTest = new Semester(2,
            3, 1, 3,
            3, 3,
            0, 0);
        semesterTest.addGradeSemester(5, ElectronicBook.typeControl.TASK, "Math");
        assertEquals(1, semesterTest.getMarksCnt());
    }

    @Test
    public void getFiveMarks() {
        Semester semesterTest = new Semester(2,
            3, 1, 3,
            3, 3,
            0, 0);
        semesterTest.addGradeSemester(5, ElectronicBook.typeControl.TASK, "Math");
        assertEquals(1, semesterTest.getFiveMarksCnt());
    }

    @Test
    public void checkFinalMarksTest() {
        Semester semesterTest = new Semester(2,
            3, 1, 3,
            3, 3,
            0, 0);
        semesterTest.addGradeSemester(3, ElectronicBook.typeControl.EXAM, "Math");
        assertFalse(semesterTest.checkFinalMarks(4, 4));
        semesterTest.addGradeSemester(4, ElectronicBook.typeControl.DIFF_CREDIT, "Math");
        assertTrue(semesterTest.checkFinalMarks(3, 4));
    }


}