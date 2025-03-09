package ru.nsu.zarcer;

import java.util.ArrayDeque;



public class OrderQueue {
    private ArrayDeque<Integer> orderList;
    public static final int DAY_OVER_CODE = 0;
    private boolean dayOverCheck=false;
    OrderQueue(){
        orderList=new ArrayDeque<>();
    }

    synchronized public void putOrder(int orderNumber) {
        orderList.push(orderNumber);
        System.out.println("[" + orderNumber + "]" + "[new order]");
        notify();
    }

    synchronized public int getOrder() throws InterruptedException {
        while (orderList.isEmpty()) {
            if (dayOverCheck) {
                return DAY_OVER_CODE;
            }
            wait();
        }
        System.out.println("[" + orderList.getLast() + "][started execution][" + Thread.currentThread().getName() + "]");
        return orderList.pollLast();
    }

    public void setDayOverCheck(){
        dayOverCheck=true;

    }
}
