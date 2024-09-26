package ru.nsu.zarcer;

public class Main {
    public static void main(String[] args) {
        Expression e = new Add(new Number(3), new Mul(new Number(2), new Variable("x")));
        e.print();
        System.out.print("\n");
        Expression de = e.derivate("x");
        de.print();
        System.out.print("\n");
        int result = e.eval("x = 10; y = 13");
        System.out.println(result);
    }
}