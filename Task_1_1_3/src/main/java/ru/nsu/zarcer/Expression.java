package ru.nsu.zarcer;

public abstract class Expression {
    public abstract void print();
    public abstract Expression derivate(String variable);
    public abstract int eval(String variables);
}
