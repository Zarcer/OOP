package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ElectronicBookTest {
    @Test
    public void addGradeTest() {
        ElectronicBook electronicBook = new ElectronicBook();
        electronicBook.addGradeBook(1, 5, ElectronicBook.TypeControl.TASK, "History");
        assertEquals(5, electronicBook.getSemesters().get(0).getMarksValue());
    }

    @Test
    public void averageGradeTest() {
        ElectronicBook electronicBook = new ElectronicBook();
        assertEquals(0, electronicBook.averageGrade());
        electronicBook.addGradeBook(1, 5, ElectronicBook.TypeControl.TASK, "History");
        electronicBook.addGradeBook(1, 5, ElectronicBook.TypeControl.TASK, "History");
        electronicBook.addGradeBook(1, 5, ElectronicBook.TypeControl.TEST, "Math");
        electronicBook.addGradeBook(1, 4, ElectronicBook.TypeControl.TEST, "Math");
        assertEquals(4.75, electronicBook.averageGrade());

    }

    @Test
    public void checkPaidFreeTest() {
        ElectronicBook electronicBook = new ElectronicBook();
        assertFalse(electronicBook.checkPaidFree(1));
        electronicBook.addGradeBook(1, 5, ElectronicBook.TypeControl.EXAM, "History");
        electronicBook.addGradeBook(1, 5, ElectronicBook.TypeControl.EXAM, "Imperative");
        electronicBook.addGradeBook(1, 5, ElectronicBook.TypeControl.EXAM, "Math");
        electronicBook.addGradeBook(1, 4, ElectronicBook.TypeControl.DIFF_CREDIT, "Haskell");
        electronicBook.addGradeBook(1, 5, ElectronicBook.TypeControl.DIFF_CREDIT, "Models");
        electronicBook.addGradeBook(1, 5, ElectronicBook.TypeControl.DIFF_CREDIT, "Sql");
        electronicBook.addGradeBook(2, 5, ElectronicBook.TypeControl.EXAM, "Osi");
        electronicBook.addGradeBook(2, 5, ElectronicBook.TypeControl.EXAM, "OOP");
        electronicBook.addGradeBook(2, 5, ElectronicBook.TypeControl.EXAM, "tfkp");
        electronicBook.addGradeBook(2, 4, ElectronicBook.TypeControl.DIFF_CREDIT, "terver");
        electronicBook.addGradeBook(2, 5, ElectronicBook.TypeControl.DIFF_CREDIT, "prolog");
        electronicBook.addGradeBook(2, 5, ElectronicBook.TypeControl.DIFF_CREDIT, "tikva");
        assertTrue(electronicBook.checkPaidFree(3));
    }

    @Test
    public void checkRedDiplomaTest() {
        ElectronicBook electronicBook = new ElectronicBook();
        assertFalse(electronicBook.checkRedDiploma(1));
        electronicBook.addGradeBook(1, 5, ElectronicBook.TypeControl.EXAM, "History");
        electronicBook.addGradeBook(1, 5, ElectronicBook.TypeControl.EXAM, "Imperative");
        electronicBook.addGradeBook(1, 5, ElectronicBook.TypeControl.EXAM, "Math");
        electronicBook.addGradeBook(1, 4, ElectronicBook.TypeControl.DIFF_CREDIT, "Haskell");
        electronicBook.addGradeBook(1, 5, ElectronicBook.TypeControl.DIFF_CREDIT, "Models");
        electronicBook.addGradeBook(1, 5, ElectronicBook.TypeControl.DIFF_CREDIT, "Sql");
        electronicBook.addGradeBook(2, 5, ElectronicBook.TypeControl.EXAM, "Osi");
        electronicBook.addGradeBook(2, 5, ElectronicBook.TypeControl.EXAM, "OOP");
        electronicBook.addGradeBook(2, 5, ElectronicBook.TypeControl.EXAM, "tfkp");
        electronicBook.addGradeBook(2, 4, ElectronicBook.TypeControl.DIFF_CREDIT, "terver");
        electronicBook.addGradeBook(2, 5, ElectronicBook.TypeControl.DIFF_CREDIT, "prolog");
        electronicBook.addGradeBook(2, 5, ElectronicBook.TypeControl.DIFF_CREDIT, "tikva");
        assertTrue(electronicBook.checkRedDiploma(3));
        electronicBook.addGradeBook(8, 3, ElectronicBook.TypeControl.VKR, "VKR");
        assertFalse(electronicBook.checkRedDiploma(8));
    }

}