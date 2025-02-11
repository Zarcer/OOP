package ru.nsu.zarcer;

import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class NotPrimeFinderThreads implements PrimeFinderInterface {
    private int numberWorkingCores;
    NotPrimeFinderThreads(int cores){
        this.numberWorkingCores = cores;
    }

    @Override
    public boolean checkNonPrime(int[] numbersArray) {
        ArrayDeque<Thread> stack = new ArrayDeque<>();
        ArrayDeque<PrimeCore> cores = new ArrayDeque<>();
        AtomicInteger index = new AtomicInteger(0);
        int size = numbersArray.length;
        while(stack.size()<numberWorkingCores){
            cores.push(new PrimeCore(numbersArray, index, size));
            stack.push(new Thread(cores.getFirst()));
            stack.getFirst().start();
        }
        size = stack.size();
        for(int i = 0;i<size;i++){
            try{
                stack.pop().join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            if(cores.pop().notPrimeFoundGetter()){
                try{
                    for(Thread thread : stack){
                        thread.join();
                    }
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                return true;
            }
        }
        return false;
    }
}
