package ru.nsu.zarcer;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        ArrayDeque<Integer> workingList=Main.primeGenerator(5000000);
        long start = System.currentTimeMillis();
        System.out.println(parallelsStreamPrime(workingList));
        long end = System.currentTimeMillis();
        System.out.println("ParallelsSteam " + (end-start));
        start = System.currentTimeMillis();
        System.out.println(consistent(workingList));
        end = System.currentTimeMillis();
        System.out.println("Ordinary " + (end-start));
        try{
            start = System.currentTimeMillis();
            System.out.println(consistentThreads(workingList, 4));
            end = System.currentTimeMillis();
            System.out.println("Multi-Thread " + (end-start));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean consistent(ArrayDeque<Integer> numbers) {
        for(int number : numbers){
            if(Main.isNotPrime(number)){
                return true;
            }
        }
        return false;
    }

    public static boolean consistentThreads(ArrayDeque<Integer> numbers, int neededCores) throws InterruptedException {
        ArrayDeque<PrimeCore> stack = new ArrayDeque<>();
        while(stack.size()<neededCores){
            stack.push(new PrimeCore(numbers));
            stack.getFirst().start();
        }
        for(PrimeCore thread : stack){
            thread.join();
            if(thread.notPrimeFound){
                return true;
            }
        }
        return false;
    }

    public static boolean parallelsStreamPrime(ArrayDeque<Integer> numbers){
        for(Object item : numbers.parallelStream().map(Main::isNotPrime).toArray()){
            if((Boolean)item){
                return true;
            }
        }
        return false;
    }

    public static boolean isNotPrime(int number){
        for(int i = 2;i<=(int)Math.sqrt(number);i++){
            if((number%i)==0){
                return true;
            }
        }
        return false;
    }

    public static ArrayDeque<Integer> primeGenerator(int N){
        int x;
        ArrayDeque<Integer> list = new ArrayDeque<>();
        for(x=2;x<=N;x++){
            if(!isNotPrime(x)){
                list.push(x);
            }
        }
        return list;
    }
}

class PrimeCore extends Thread {
    ArrayDeque<Integer> numbers;
    boolean notPrimeFound=false;
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
            if(Main.isNotPrime(number)){
                notPrimeFound=true;
                return;
            }
        }
    }
}