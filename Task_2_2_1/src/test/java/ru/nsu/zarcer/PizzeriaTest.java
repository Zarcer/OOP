package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PizzeriaTest {
    @Test
    public void cookingCheckTest() {
        Pizzeria pizza = new Pizzeria(1, 1);
        assertEquals(1, pizza.cookingCheck());
    }

    @Test
    public void cookingOverTest() {
        Pizzeria pizza = new Pizzeria(1, 1);
        pizza.cookingOver();
        assertEquals(0, pizza.cookingCheck());
    }

    @Test
    public void putGetOrderTest() {
        Pizzeria pizza = new Pizzeria(1, 1);
        pizza.putOrder(99);
        try{
            assertEquals(pizza.getOrder(), 99);
        } catch (InterruptedException ignored) {
        }
    }

    @Test
    public void putPizzaTest() {
        Pizzeria pizza = new Pizzeria(1, 1);
        assertTrue(pizza.pizzaCheck());
        pizza.putPizza(100);
        assertFalse(pizza.pizzaCheck());
    }

    @Test
    public void getPizzaTest() {
        Pizzeria pizza = new Pizzeria(1, 1);
        pizza.putPizza(100);
        try {
            assertEquals(pizza.getPizza(1).getLast(), 100);
        } catch (InterruptedException ignored) {
        }
    }

    @Test
    public void pizzaCheckTest() {
        Pizzeria pizza = new Pizzeria(1, 1);
        assertTrue(pizza.pizzaCheck());
        pizza.putPizza(100);
        assertFalse(pizza.pizzaCheck());
        try {
            pizza.getPizza(1);
        } catch (InterruptedException ignored) {
        }
        assertTrue(pizza.pizzaCheck());
    }

    @Test
    public void dayOverTest() {
        Pizzeria warehouse = new Pizzeria(2, 1);
        assertFalse(warehouse.getDayOverCheckValue());
        ArrayList<Thread> listCook = new ArrayList<>();
        ArrayList<Thread> listCour = new ArrayList<>();
        Thread cook0 = new Thread(new Cook(0, warehouse), "Cook0");
        Thread cour0 = new Thread(new Courier(1, warehouse), "cour0");
        cook0.start();
        cour0.start();
        listCook.add(cook0);
        listCour.add(cour0);
        warehouse.dayOverSetter(listCook, listCour);
        assertTrue(warehouse.pizzaCheck());
    }




}