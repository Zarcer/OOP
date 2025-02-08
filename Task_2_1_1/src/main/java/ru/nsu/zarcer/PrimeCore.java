package ru.nsu.zarcer;

import java.util.ArrayDeque;

public class PrimeCore extends Thread {
    private ArrayDeque<Integer> numbers;
    private boolean notPrimeFound=false;
    PrimeCore(ArrayDeque<Integer> numbers){
        this.numbers=numbers;
    }
    public void run(){
        while(true){
            int number;
            synchronized (numbers) {
                if(numbers.isEmpty()){
                    return;
                }
                number = numbers.pop();
            }
            if(PrimeOperations.isNotPrime(number)){
                notPrimeFound=true;
            }
        }
    }

    public boolean notPrimeFoundGetter() {
        return this.notPrimeFound;
    }
}
