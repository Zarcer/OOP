package ru.nsu.zarcer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CookTest {

    @Test
    public void pizzaCookingTest() throws InterruptedException {
        Pizzeria warehouse = new Pizzeria(2, 1);
        ArrayList<Thread> listCook = new ArrayList<>();
        ArrayList<Thread> listCour = new ArrayList<>();
        Thread cook0 = new Thread(new Cook(0, warehouse), "Cook0");
        Thread cour0 = new Thread(new Courier(1, warehouse), "cour0");
        cook0.start();
        listCook.add(cook0);
        listCour.add(cour0);
        warehouse.putOrder(1);
        warehouse.dayOverSetter(listCook, listCour);
        assertFalse(warehouse.pizzaCheck());
    }
}