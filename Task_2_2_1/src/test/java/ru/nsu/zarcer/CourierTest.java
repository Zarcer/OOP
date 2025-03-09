package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {
    @Test
    public void deliveringTest() throws InterruptedException {
        Pizzeria warehouse = new Pizzeria(2, 1);
        Thread courier0 = new Thread(new Courier(1, warehouse), "Courier0");
        warehouse.putPizza(1);
        courier0.start();
        warehouse.cookingOver();
        courier0.join();
        assertTrue(warehouse.pizzaCheck());
    }
}