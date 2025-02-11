package ru.nsu.zarcer;

public class Main {
    public static void main(String[] args) {
        int[] workingArray = PrimeOperations.primeGenerator(5000000);
        System.out.println("ParallelsSteam " + PrimeOperations.findNonPrimeCountSpeed(new NotPrimeFinderParallelStream(), workingArray));
        System.out.println("Ordinary " + PrimeOperations.findNonPrimeCountSpeed(new NotPrimeFinderConsistent(), workingArray));
        System.out.println("Multi-Thread " + PrimeOperations.findNonPrimeCountSpeed(new NotPrimeFinderThreads(4), workingArray));
    }
}





