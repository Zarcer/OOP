package ru.nsu.zarcer;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Warehouse {
    private int capacity;
    private boolean dayOverCheck=false;
    private ArrayDeque<Integer> pizzaList;
    private ArrayDeque<Integer> orderList;
    private int cooksNumber;
    private Object pizzaListLock = new Object();
    private Object orderListLock = new Object();
    Warehouse(int capacity, int cooksNumber){
        this.capacity=capacity;
        this.cooksNumber=cooksNumber;
        pizzaList = new ArrayDeque<>();
        orderList = new ArrayDeque<>();
    }

    public ArrayDeque<Integer> getPizza(int courierCapacity) throws InterruptedException {
        synchronized (pizzaListLock){
            while(pizzaList.isEmpty()){
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

    public void putOrder(int orderNumber){
        synchronized (orderListLock){
            orderList.push(orderNumber);
            System.out.println("["+orderNumber+"]"+"[new order]");
            orderListLock.notify();
        }
    }

    public int getOrder() throws InterruptedException {
        synchronized (orderListLock){
            while(orderList.isEmpty()){
                if(dayOverCheck){
                    return 0;
                }
                orderListLock.wait();
            }
            System.out.println("["+orderList.getLast()+"][started execution]["+Thread.currentThread().getName()+"]");
            return orderList.pollLast();
        }
    }

    public void dayOverSetter(ArrayList<Thread> cooks, ArrayList<Thread> couriers){
        dayOverCheck=true;
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

    public void cookingOver(){
        cooksNumber--;
    }

    public int cookingCheck(){
        return cooksNumber;
    }

    public boolean pizzaCheck() {
        return pizzaList.isEmpty();
    }
}
