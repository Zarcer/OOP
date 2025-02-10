package ru.nsu.zarcer;

import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class NotPrimeFinderThreads implements PrimeFinderInterface {
    private int neededCores;
    NotPrimeFinderThreads(int cores){
        this.neededCores = cores;
    }
    public boolean checkNonPrime(int[] numbersArray) {
        ArrayDeque<PrimeCore> stack = new ArrayDeque<>();
        AtomicInteger index = new AtomicInteger(0);
        int size = numbersArray.length;
        while(stack.size()<neededCores){
            stack.push(new PrimeCore(numbersArray, index, size));
            stack.getFirst().start();
        }
        for(PrimeCore thread : stack){
            try{
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(thread.notPrimeFoundGetter()){
                return true;
            }
        }
        return false;
    }

}
