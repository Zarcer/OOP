package ru.nsu.zarcer;

public class Cook implements Runnable{
    private int speed;
    private int orderNumber;
    private Pizzeria storage;
    Cook(int speed, Pizzeria storage){
        this.speed=speed;
        this.storage=storage;
    }
    public void run(){
        while(true){
            try{
                orderNumber=storage.getOrder();
                if(orderNumber==OrderQueue.DAY_OVER_CODE){
                    storage.cookingOver();
                    return;
                }
            } catch (InterruptedException e) {
                storage.cookingOver();
                return;
            }
            cookingPizza();
        }
    }

    private void cookingPizza(){
        try{
            Thread.sleep(speed);
        } catch (InterruptedException ignored) {
            //add another sleep to end cooking using timer
        }
        System.out.println("["+orderNumber+"][cooked]"+"["+Thread.currentThread().getName()+"]");
        if(!storage.putPizza(orderNumber)){
            storage.putPizza(orderNumber);
        }
    }
}
