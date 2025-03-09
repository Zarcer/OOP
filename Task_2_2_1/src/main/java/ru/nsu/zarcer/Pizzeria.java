package ru.nsu.zarcer;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Pizzeria {
    private int cooksNumber;
    private Warehouse warehouse;
    private OrderQueue orderQueue;
    Pizzeria(int capacity, int cooksNumber){
        warehouse = new Warehouse(capacity);
        orderQueue = new OrderQueue();
        this.cooksNumber=cooksNumber;
    }

    public ArrayDeque<Integer> getPizza(int courierCapacity) throws InterruptedException {
        return warehouse.getPizza(courierCapacity);
    }

    public boolean putPizza(int orderNumber) {
        return warehouse.putPizza(orderNumber);
    }

    public void putOrder(int orderNumber){
        orderQueue.putOrder(orderNumber);
    }

    public int getOrder() throws InterruptedException {
        return orderQueue.getOrder();
    }

    synchronized public void cookingOver(){
        cooksNumber--;
    }

    public int cookingCheck(){
        return cooksNumber;
    }

    public boolean pizzaCheck() {
        return warehouse.pizzaCheck();
    }

    public void dayOverSetter(ArrayList<Thread> cooks, ArrayList<Thread> couriers){
        orderQueue.setDayOverCheck();
        for(Thread cook:cooks){
            cook.interrupt();
        }
        for(Thread courier:couriers){
            courier.interrupt();
        }
        for(Thread cook:cooks){
            try{
                cook.join();
            } catch (InterruptedException ignored) {
            }
        }
        for(Thread courier:couriers){
            try{
                courier.join();
            } catch (InterruptedException ignored) {
            }
        }
    }
}
