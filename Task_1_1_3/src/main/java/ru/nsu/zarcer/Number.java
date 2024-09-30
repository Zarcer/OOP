package ru.nsu.zarcer;

import java.util.HashMap;

public class Number extends Expression {

    private int value;
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
    public int evaluate(HashMap<String, Integer> dict) {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        Number numb = (Number)obj;
        return value == numb.value;
    }
}
