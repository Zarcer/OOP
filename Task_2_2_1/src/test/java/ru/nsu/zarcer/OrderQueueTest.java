package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderQueueTest {

    @Test
    public void putGetTest() {
        Pizzeria pizza = new Pizzeria(1, 1);
        OrderQueue test = new OrderQueue(pizza);
        test.putOrder(99);
        try{
            assertEquals(test.getOrder(), 99);
        } catch (InterruptedException ignored) {
        }
    }
}