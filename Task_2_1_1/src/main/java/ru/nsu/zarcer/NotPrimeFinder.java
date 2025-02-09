package ru.nsu.zarcer;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.concurrent.atomic.AtomicInteger;


public class NotPrimeFinder {
    public static boolean consistent(int[] numbers) {
        for(int number : numbers){
            if(PrimeOperations.isNotPrime(number)){
                return true;
            }
        }
        return false;
    }

    public static boolean consistentThreads(int[] numbersArray, int neededCores) throws InterruptedException {
        ArrayDeque<PrimeCore> stack = new ArrayDeque<>();
        AtomicInteger index = new AtomicInteger(0);
        int size = numbersArray.length;
        while(stack.size()<neededCores){
            stack.push(new PrimeCore(numbersArray, index, size));
            stack.getFirst().start();
        }
        for(PrimeCore thread : stack){
            thread.join();
            if(thread.notPrimeFoundGetter()){
                return true;
            }
        }
        return false;
    }

    public static boolean parallelsStreamPrime(int[] numbersArray){
        ArrayDeque<Integer> numbers = Arrays.stream(numbersArray).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        for(Object item : numbers.parallelStream().map(PrimeOperations::isNotPrime).toArray()){
            if((Boolean)item){
                return true;
            }
        }
        return false;
    }
}



