package ru.nsu.zarcer;

import java.util.ArrayDeque;

public class Warehouse {
    private ArrayDeque<Integer> pizzaList=new ArrayDeque<>();
    private int capacity;
    private Object pizzaListLock = new Object();
    Warehouse(int capacity){
        this.capacity=capacity;
    }

    public ArrayDeque<Integer> getPizza(int courierCapacity) throws InterruptedException {
        synchronized (pizzaListLock) {
            while(pizzaList.isEmpty()) {
                pizzaListLock.wait();
            }
            ArrayDeque<Integer> courierOrdersTaken=new ArrayDeque<>();
            while(courierOrdersTaken.size()<courierCapacity && !pizzaList.isEmpty()){
                System.out.println("["+pizzaList.getLast()+"][taken from warehouse]["+Thread.currentThread().getName()+"]");
                courierOrdersTaken.push(pizzaList.pollLast());
            }
            pizzaListLock.notify();
            return courierOrdersTaken;
        }
    }

    public boolean putPizza(int orderNumber) {
        synchronized (pizzaListLock){
            while(pizzaList.size()>=capacity){
                try{
                    pizzaListLock.wait();
                } catch (InterruptedException e) {
                    return false;
                }
            }
            pizzaList.push(orderNumber);
            System.out.println("["+pizzaList.peekFirst()+"][put to warehouse]["+Thread.currentThread().getName()+"]");
            pizzaListLock.notify();
            return true;
        }
    }

    public boolean pizzaCheck() {
        return pizzaList.isEmpty();
    }
}
