package ru.nsu.zarcer;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.concurrent.atomic.AtomicInteger;


public class NotPrimeFinder {
    public static void main(String[] args) {
        int[] workingArray=PrimeOperations.primeGenerator(5000000);
        long start = System.currentTimeMillis();
        System.out.println(parallelsStreamPrime(workingArray));
        long end = System.currentTimeMillis();
        System.out.println("ParallelsSteam " + (end-start));
        start = System.currentTimeMillis();
        System.out.println(consistent(workingArray));
        end = System.currentTimeMillis();
        System.out.println("Ordinary " + (end-start));
        try{
            start = System.currentTimeMillis();
            System.out.println(consistentThreads(workingArray, 4));
            end = System.currentTimeMillis();
            System.out.println("Multi-Thread " + (end-start));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean consistent(int[] numbers) {
        for(int number : numbers){
            if(PrimeOperations.isNotPrime(number)){
                return true;
            }
        }
        return false;
    }

    public static boolean consistentThreads(int[] numbersArray, int neededCores) throws InterruptedException {
        ArrayDeque<Thread> stack = new ArrayDeque<>();
        ArrayDeque<PrimeCore> cores = new ArrayDeque<>();
        AtomicInteger index = new AtomicInteger(0);
        int size = numbersArray.length;
        while(stack.size()<neededCores){
            cores.push(new PrimeCore(numbersArray, index, size));
            stack.push(new Thread(cores.getFirst()));;
            stack.getFirst().start();
        }
        for(int i = 0;i<stack.size();i++){
            stack.pop().join();
            if(cores.pop().notPrimeFoundGetter()){
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



