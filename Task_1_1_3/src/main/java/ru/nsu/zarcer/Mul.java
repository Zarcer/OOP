package ru.nsu.zarcer;

public class Mul extends Expression {
    Expression First;
    Expression Second;
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
    public int eval(String variables) {
        return (this.First.eval(variables)*this.Second.eval(variables));
    }
}
