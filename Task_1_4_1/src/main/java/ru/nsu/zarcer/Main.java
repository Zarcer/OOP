package ru.nsu.zarcer;

public class Main {
    public static void main(String[] args) {
        ElectronicBook electronicBook = new ElectronicBook();
        electronicBook.addGradeBook(1, 5, ElectronicBook.typeControl.EXAM);
        electronicBook.addGradeBook(1, 5, ElectronicBook.typeControl.EXAM);
        electronicBook.addGradeBook(1, 5, ElectronicBook.typeControl.EXAM);
        electronicBook.addGradeBook(1, 5, ElectronicBook.typeControl.DIFF_CREDIT);
        electronicBook.addGradeBook(1, 5, ElectronicBook.typeControl.DIFF_CREDIT);
        electronicBook.addGradeBook(1, 5, ElectronicBook.typeControl.DIFF_CREDIT);
        electronicBook.addGradeBook(2, 5, ElectronicBook.typeControl.EXAM);
        electronicBook.addGradeBook(2, 5, ElectronicBook.typeControl.EXAM);
        electronicBook.addGradeBook(2, 5, ElectronicBook.typeControl.EXAM);
        electronicBook.addGradeBook(2, 5, ElectronicBook.typeControl.DIFF_CREDIT);
        electronicBook.addGradeBook(2, 5, ElectronicBook.typeControl.DIFF_CREDIT);
        electronicBook.addGradeBook(2, 5, ElectronicBook.typeControl.DIFF_CREDIT);
        System.out.println(electronicBook.checkPaidFree(3));
    }
}