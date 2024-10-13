package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class FinderTest {
    @Test
    public void findResourceTest() {
        try {
            ArrayList<Integer> test = Finder.findRecourse("test.txt", "⌨");
            ArrayList<Integer> validation = new ArrayList<>();
            validation.add(1);
            validation.add(8);
            assertEquals(test, validation);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void substringVoidTest() {
        try {
            ArrayList<Integer> test = Finder.findRecourse("test.txt", "тыква");
            ArrayList<Integer> validation = new ArrayList<>();
            assertEquals(test, validation);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void substringEqualsTest() {
        try {
            ArrayList<Integer> test = Finder.findRecourse("equals.txt", "абра");
            ArrayList<Integer> validation = new ArrayList<>();
            validation.add(0);
            validation.add(3);
            assertEquals(test, validation);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void findFileTest() {
        File testFile = new File("bigTest.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(testFile,
                StandardCharsets.UTF_8))) {
            ArrayList<Integer> validation = new ArrayList<>();
            testFile.createNewFile();
            String input = "абракадабра";
            String subName = "бра";
            int shift = 0;
            for (int i = 0; i < 1000000; i++) {
                bw.write(input);
                bw.flush();
                validation.add(1 + shift);
                validation.add(8 + shift);
                shift = shift + 11;
            }
            ArrayList<Integer> testing = Finder.findFile("bigTest.txt", subName);
            assertEquals(validation, testing);
            testFile.delete();
        } catch (IOException e) {
            testFile.delete();
            System.out.println(e.getMessage());
        }
    }
}