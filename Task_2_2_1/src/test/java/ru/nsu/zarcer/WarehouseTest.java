package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {
    @Test
    public void putPizzaTest() {
        Warehouse warehouse = new Warehouse(1);
        assertTrue(warehouse.pizzaCheck());
        warehouse.putPizza(100);
        assertFalse(warehouse.pizzaCheck());
    }

    @Test
    public void getPizzaTest() {
        Warehouse warehouse = new Warehouse(1);
        warehouse.putPizza(100);
        try {
            assertEquals(warehouse.getPizza(1).getLast(), 100);
        } catch (InterruptedException ignored) {
        }
    }

    @Test
    public void pizzaCheckTest() {
        Warehouse warehouse = new Warehouse(1);
        assertTrue(warehouse.pizzaCheck());
        warehouse.putPizza(100);
        assertFalse(warehouse.pizzaCheck());
        try {
            warehouse.getPizza(1);
        } catch (InterruptedException ignored) {
        }
        assertTrue(warehouse.pizzaCheck());
    }
}