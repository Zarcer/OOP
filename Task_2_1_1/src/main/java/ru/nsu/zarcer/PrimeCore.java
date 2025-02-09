package ru.nsu.zarcer;

import java.util.concurrent.atomic.AtomicInteger;

public class PrimeCore extends Thread {
    private int[] numbers;
    private boolean notPrimeFound=false;
    private AtomicInteger atomicIndex;
    private int size;
    PrimeCore(int[] numbers, AtomicInteger index, int arraySize){
        this.numbers=numbers;
        this.atomicIndex=index;
        this.size=arraySize;
    }
    public void run(){
        while(true){
            int number;
            int currIndex = atomicIndex.getAndIncrement();
            if(currIndex>=size){
                return;
            }
            number=numbers[currIndex];
            if(PrimeOperations.isNotPrime(number)){
                notPrimeFound=true;
            }
        }
    }

    public boolean notPrimeFoundGetter() {
        return this.notPrimeFound;
    }
}
