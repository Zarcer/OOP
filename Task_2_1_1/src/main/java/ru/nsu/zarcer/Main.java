package ru.nsu.zarcer;

public class Main {
    public static void main(String[] args) {
        int[] workingArray = PrimeOperations.primeGenerator(5000000);
        long start = System.currentTimeMillis();
        System.out.println(new NotPrimeFinderParallelStream().checkNonPrime(workingArray));
        System.out.println("ParallelsSteam " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println(new NotPrimeFinderConsistent().checkNonPrime(workingArray));
        System.out.println("Ordinary " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println(new NotPrimeFinderThreads(4).checkNonPrime(workingArray));
        System.out.println("Multi-Thread " + (System.currentTimeMillis() - start));
    }
}





