package ru.nsu.zarcer;

import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * Class for computing non-prime numbers using threads.
 */
public class NotPrimeFinderThreads implements PrimeFinderInterface {
    private int numberWorkingCores;

    /**Constructor for this class.
     *
     * @param cores how many cores should be used for calculation
     */
    NotPrimeFinderThreads(int cores) {
        this.numberWorkingCores = cores;
    }
    /** Method for finding non-prime number.
     *
     * @param numbersArray int array
     *
     * @return boolean, true if array has non-prime number, false otherwise
     */
    @Override
    public boolean checkNonPrime(int[] numbersArray) {
        ArrayDeque<Thread> stack = new ArrayDeque<>();
        ArrayDeque<PrimeCore> cores = new ArrayDeque<>();
        AtomicInteger index = new AtomicInteger(0);
        int size = numbersArray.length;
        while (stack.size() < numberWorkingCores) {
            cores.push(new PrimeCore(numbersArray, index, size));
            stack.push(new Thread(cores.getFirst()));
            stack.getFirst().start();
        }
        for (Thread core : stack) {
            try {
                core.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                core.interrupt();
            }
            if (cores.pop().notPrimeFoundGetter()) {
                try {
                    for (Thread thread : stack) {
                        thread.interrupt();
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
