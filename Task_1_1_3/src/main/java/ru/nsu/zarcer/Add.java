package ru.nsu.zarcer;

public class Add extends Expression {
    Expression First;
    Expression Second;
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
    public int eval(String variables) {
        return (this.First.eval(variables)+this.Second.eval(variables));
    }
}
