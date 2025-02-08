package ru.nsu.zarcer;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;


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
        ArrayDeque<Integer> numbers = Arrays.stream(numbersArray).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        while(stack.size()<neededCores){
            stack.push(new PrimeCore(numbers));
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



