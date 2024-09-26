package ru.nsu.zarcer;

public class Div extends Expression {
    Expression First;
    Expression Second;
    Div(Expression first, Expression second) {
        this.First = first;
        this.Second = second;
    }


    @Override
    public void print() {
        System.out.print("(");
        this.First.print();
        System.out.print("/");
        this.Second.print();
        System.out.print(")");
    }

    @Override
    public Expression derivate(String variable) {
        return new Div(new Sub(new Mul(this.First.derivate(variable), this.Second), new Mul(this.First, this.Second.derivate(variable))), new Mul(this.Second, this.Second));
    }

    @Override
    public int eval(String variables) {
        return (this.First.eval(variables)/this.Second.eval(variables));
    }
}
