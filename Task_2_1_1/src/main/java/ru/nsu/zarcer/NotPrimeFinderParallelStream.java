package ru.nsu.zarcer;

import java.util.Arrays;


public class NotPrimeFinderParallelStream implements PrimeFinderInterface{
    @Override
    public boolean checkNonPrime(int[] numbersArray){
        return Arrays.stream(numbersArray).parallel().anyMatch(PrimeOperations::isNotPrime);
    }
}
