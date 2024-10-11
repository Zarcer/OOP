package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FinderTest {
    @Test
    public void findResourceTest(){
        try{
            ArrayList<Integer> test = Finder.findRecourse("test.txt", "бра");
            ArrayList<Integer> validation = new ArrayList<>();
            validation.add(1);
            validation.add(8);
            assertEquals(test, validation);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findFileTest(){
        try{
            File testFile = new File("bigTest.txt");
            ArrayList<Integer> validation = new ArrayList<>();
            testFile.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(testFile));
            String input = "абракадабра";
            String subName = "бра";
            int shift = 0;
            for(int i = 0;i<2000000;i++){
                bw.write(input);
                validation.add(1+shift);
                validation.add(8+shift);
                shift = shift+11;
            }
            ArrayList<Integer> testing = Finder.findFile("bigTest.txt", subName);
            testFile.delete();
            bw.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}