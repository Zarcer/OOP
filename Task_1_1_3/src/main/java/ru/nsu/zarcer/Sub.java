package ru.nsu.zarcer;

public class Sub extends Expression {
    Expression First;
    Expression Second;
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
    public int eval(String variables) {
        return (this.First.eval(variables)-this.Second.eval(variables));
    }
}
