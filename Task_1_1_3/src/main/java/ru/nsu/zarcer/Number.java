package ru.nsu.zarcer;

public class Number extends Expression {

    int value;
    Number(int value) {
        this.value = value;
    }
    @Override
    public void print() {
        System.out.print(value);
    }
    @Override
    public Expression derivate(String variable) {
        return new Number(0);
    }
    @Override
    public int eval(String variables) {
        return this.value;
    }
}
