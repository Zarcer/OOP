package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    @Test
    public void equalTestTrue() {
        Position first = new Position(5, 5);
        Position second = new Position(5, 5);
        assertTrue(first.equals(second));
    }

    @Test
    public void equalTestFalseValue() {
        Position first = new Position(5, 5);
        Position second = new Position(10, 10);
        assertFalse(first.equals(second));
    }

    @Test
    public void equalTestFalseType() {
        Position first = new Position(5, 5);
        Integer second = 5;
        assertFalse(first.equals(second));
    }

    @Test
    public void hashCodeTest(){
        Position first = new Position(5, 5);
        Position second = new Position(10, 10);
        assertFalse(first.hashCode()==second.hashCode());
    }


  
}