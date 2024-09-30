package ru.nsu.zarcer;

import java.util.HashMap;

public class Mul extends Expression {
    private Expression First;
    private Expression Second;
    Mul(Expression first, Expression second) {
        this.First = first;
        this.Second = second;
    }


    @Override
    public void print() {
        System.out.print("(");
        this.First.print();
        System.out.print("*");
        this.Second.print();
        System.out.print(")");
    }

    @Override
    public Expression derivate(String variable) {
        return new Add(new Mul(this.First.derivate(variable), this.Second), new Mul(this.First, this.Second.derivate(variable)));
    }

    @Override
    public int evaluate(HashMap<String, Integer> dict) {
        return First.evaluate(dict)*Second.evaluate(dict);
    }

    @Override
    public boolean equals(Object obj) {
        Mul mul = (Mul)obj;
        return First.equals(mul.First) && Second.equals(mul.Second);
    }
}
