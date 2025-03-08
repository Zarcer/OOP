package ru.nsu.zarcer;

import java.util.ArrayDeque;

public class OrderQueue {
    private ArrayDeque<Integer> orderList;
    private Object orderListLock;
    private Pizzeria pizzeria;
    OrderQueue(Pizzeria pizzeria){
        orderList=new ArrayDeque<>();
        orderListLock=new Object();
        this.pizzeria=pizzeria;
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
                if(pizzeria.getDayOverCheckValue()){
                    return 0;
                }
                orderListLock.wait();
            }
            System.out.println("["+orderList.getLast()+"][started execution]["+Thread.currentThread().getName()+"]");
            return orderList.pollLast();
        }
    }
}
