package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

class GameplayTest {
    private String runGame(String input) {
        InputStream inputStream = System.in;
        PrintStream outputStream = System.out;
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        Gameplay.main(null);
        System.setIn(inputStream);
        System.setOut(outputStream);
        return myOut.toString();
    }

    @Test
    void mainTest() {
        runGame("-1\n");
        assertTrue(true);
    }
}