package ru.nsu.zarcer;

import java.util.ArrayDeque;

public class Warehouse {
    private ArrayDeque<Integer> pizzaList=new ArrayDeque<>();
    private int capacity;
    Warehouse(int capacity){
        this.capacity=capacity;
    }

    synchronized public ArrayDeque<Integer> getPizza(int courierCapacity) throws InterruptedException {
        while (pizzaList.isEmpty()) {
            wait();
        }
        ArrayDeque<Integer> courierOrdersTaken = new ArrayDeque<>();
        while (courierOrdersTaken.size() < courierCapacity && !pizzaList.isEmpty()) {
            System.out.println("[" + pizzaList.getLast() + "][taken from warehouse][" + Thread.currentThread().getName() + "]");
            courierOrdersTaken.push(pizzaList.pollLast());
        }
        notify();
        return courierOrdersTaken;
    }

    synchronized public boolean putPizza(int orderNumber) {
        while (pizzaList.size() >= capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                return false;
            }
        }
        pizzaList.push(orderNumber);
        System.out.println("[" + pizzaList.peekFirst() + "][put to warehouse][" + Thread.currentThread().getName() + "]");
        notify();
        return true;
    }

    public boolean pizzaCheck() {
        return pizzaList.isEmpty();
    }
}
