package ru.nsu.zarcer;

public class NotPrimeFinderConsistent implements PrimeFinderInterface {
    public boolean checkNonPrime(int[] numbers) {
        for(int number : numbers){
            if(PrimeOperations.isNotPrime(number)){
                return true;
            }
        }
        return false;
    }
}
