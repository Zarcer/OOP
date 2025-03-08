package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkingProcessTest {

    @Test
    public void startRoutine() {
        assertTrue(WorkingProcess.startRoutine(1, 1000, 1, 1, 3));
    }

}