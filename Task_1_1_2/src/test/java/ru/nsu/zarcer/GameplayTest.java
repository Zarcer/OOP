package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;


class GameplayTest {
    private String runGame(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        final InputStream inputStream = System.in;
        final PrintStream outputStream = System.out;
        Gameplay.main(null);
        System.setIn(inputStream);
        System.setOut(outputStream);
        return myOut.toString();
    }

    @Test
    void mainTest() {
        runGame("1\n0\n-1\n");
        assertTrue(true);
    }
}