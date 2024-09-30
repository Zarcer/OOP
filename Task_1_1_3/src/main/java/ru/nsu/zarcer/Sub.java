package ru.nsu.zarcer;

import java.util.HashMap;

public class Sub extends Expression {
    private Expression First;
    private Expression Second;
    Sub(Expression first, Expression second) {
        this.First = first;
        this.Second = second;
    }

    @Override
    public void print() {
        System.out.print("(");
        this.First.print();
        System.out.print("-");
        this.Second.print();
        System.out.print(")");
    }

    @Override
    public Expression derivate(String variable) {
        return new Sub(this.First.derivate(variable), this.Second.derivate(variable));
    }

    @Override
    public int evaluate(HashMap<String, Integer> dict) {
        return First.evaluate(dict)-Second.evaluate(dict);
    }

    @Override
    public boolean equals(Object obj) {
        Sub sub = (Sub)obj;
        return First.equals(sub.First) && Second.equals(sub.Second);
    }
}
