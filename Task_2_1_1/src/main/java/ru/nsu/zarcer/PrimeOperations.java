package ru.nsu.zarcer;

import java.util.ArrayDeque;

public class PrimeOperations {
    public static boolean isNotPrime(int number){
        if((number==1 || number==0)){
            return true;
        }
        for(int i = 2;i<=(int)Math.sqrt(number);i++){
            if((number%i)==0){
                return true;
            }
        }
        return false;
    }

    public static int[] primeGenerator(int N){
        if((N==1 || N==0)){
            return new int[0];
        }
        int x;
        ArrayDeque<Integer> list = new ArrayDeque<>();
        for(x=2;x<=N;x++){
            if(!isNotPrime(x)){
                list.push(x);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static String findNonPrimeCountSpeed(PrimeFinderInterface operation, int[] workingArray){
        long start = System.currentTimeMillis();
        return (operation.checkNonPrime(workingArray))+" "+(System.currentTimeMillis() - start);
    }
}