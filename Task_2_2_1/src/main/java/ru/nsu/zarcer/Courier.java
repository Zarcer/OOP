package ru.nsu.zarcer;

import java.util.ArrayDeque;

public class Courier implements Runnable {
    private int capacity;
    private ArrayDeque<Integer> takenOrders=new ArrayDeque<>();
    private Pizzeria storage;
    Courier(int capacity, Pizzeria storage){
        this.capacity=capacity;
        this.storage=storage;
    }
    public void run(){
        while(storage.cookingCheck()!=0 || !storage.pizzaCheck()){
            try{
                takenOrders=storage.getPizza(capacity);
            } catch (InterruptedException e) {
                if(storage.cookingCheck()==0){
                    return;
                }
            }
            orderingPizza();
        }
    }

    private void orderingPizza(){
        for(Integer order : takenOrders){
            System.out.println("["+order+"][taken by courier]"+"["+Thread.currentThread().getName()+"]");
        }
        while(!takenOrders.isEmpty()){
            System.out.println("["+takenOrders.getLast()+"][start delivering]"+"["+Thread.currentThread().getName()+"]");
            try{
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
                //add another sleep to end delivering using timer
            }
            System.out.println("["+takenOrders.pollLast()+"][end delivering]"+"["+Thread.currentThread().getName()+"]");
        }
    }
}
