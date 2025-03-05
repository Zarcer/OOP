package ru.nsu.zarcer;

import java.util.ArrayList;

public class WorkingProcess {
    public static void startRoutine(int N, int speed, int M, int courierCapacity, int warehouseCapacity){
        Warehouse warehouse = new Warehouse(warehouseCapacity, N);
        ArrayList<Thread> cooks = new ArrayList<>();
        ArrayList<Thread> couriers = new ArrayList<>();
        for(int i = 0;i<N;i++){
            cooks.add(i, new Thread(new Cook(speed, warehouse), "Cook"+i));
            cooks.get(i).start();
        }
        for(int i = 0;i<M;i++){
            couriers.add(i, new Thread(new Courier(courierCapacity, warehouse), "Courier"+i));
            couriers.get(i).start();
        }
        for(int i = 1;i<=8;i++){
            warehouse.putOrder(i);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
        }
        warehouse.dayOverSetter(cooks, couriers);
    }
}
