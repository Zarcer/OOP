package ru.nsu.zarcer;

import java.util.HashMap;

public class Add extends Expression {
    private Expression First;
    private Expression Second;
    Add(Expression first, Expression second) {
        this.First = first;
        this.Second = second;
    }

    @Override
    public void print() {
        System.out.print("(");
        this.First.print();
        System.out.print("+");
        this.Second.print();
        System.out.print(")");
    }

    @Override
    public Expression derivate(String variable) {
        return new Add(this.First.derivate(variable), this.Second.derivate(variable));
    }

    @Override
    public int evaluate(HashMap<String, Integer> dict) {
        return First.evaluate(dict)+Second.evaluate(dict);
    }

    @Override
    public boolean equals(Object obj) {
        Add add = (Add)obj;
        return First.equals(add.First) && Second.equals(add.Second);
    }

}
