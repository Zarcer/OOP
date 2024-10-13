package ru.nsu.zarcer;

import java.util.HashMap;
import java.util.Objects;

/**
 * Just Mul class.
 */
public class Mul extends Expression {
    private Expression first;
    private Expression second;

    Mul(Expression first, Expression second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Just derivation.
     *
     * @param variable if there is no correct variable, all variables will just go to zero
     *
     * @return recursive call
     */
    @Override
    public Expression derivate(String variable) {
        return new Add(new Mul(this.first.derivate(variable), this.second),
                new Mul(this.first, this.second.derivate(variable)));
    }

    /**
     * Calculation of expression.
     *
     * @param dict dictionary with pairs variable name value
     *
     * @return recursive call
     */
    @Override
    public int evaluate(HashMap<String, Integer> dict) {
        return first.evaluate(dict) * second.evaluate(dict);
    }

    @Override
    public Expression cut() {
        if(!first.checkVariable()&&!second.checkVariable()){
            int result = this.eval("x = 666");
            return new Number(result);
        }
        if(first.equals(new Number(0))||second.equals(new Number(0))){
            return new Number(0);
        }
        if(first.equals(new Number(1))){
            return second.cut();
        }
        if(second.equals(new Number(1))){
            return first.cut();
        }
        return new Mul(first.cut(), second.cut());
    }

    @Override
    public boolean checkVariable() {
        return (first.checkVariable() || second.checkVariable());
    }

    /**
     * Override for equals method.
     *
     * @param obj with what compare
     *
     * @return recursive call
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Mul)){
            return false;
        }
        Mul mul = (Mul) obj;
        return first.equals(mul.first) && second.equals(mul.second);
    }

    /**
     * Override for toString method.
     *
     * @return recursive call
     */
    @Override
    public String toString() {
        return "(" + first.toString() + "*" + second.toString() + ")";
    }

    /**
     * Override for hash method.
     *
     * @return hash for multiple objects
     */
    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
