package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

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
    void refresher() {
        int round_start_number = Gameplay.round_count[0];
        assertEquals(1, Gameplay.round_count[0]);
        runGame("0 -1");
        int round_next = Gameplay.round_count[0];
        assertEquals(2, Gameplay.round_count[0]);
    }

    @Test
    void maintest() {
        runGame("0 -1");
        assertTrue(true);
    }
}