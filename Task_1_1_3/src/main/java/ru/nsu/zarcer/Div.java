package ru.nsu.zarcer;

import java.util.HashMap;
import java.util.Objects;

public class Div extends Expression {
    private Expression First;
    private Expression Second;

    Div(Expression first, Expression second) {
        this.First = first;
        this.Second = second;
    }

    /**Just derivation.
     *
     * @param variable if there is no correct variable, all variables will just go to zero
     *
     * @return recursive call
     */
    @Override
    public Expression derivate(String variable) {
        return new Div(new Sub(new Mul(this.First.derivate(variable), this.Second), new Mul(this.First, this.Second.derivate(variable))), new Mul(this.Second, this.Second));
    }

    /**Calculation of expression.
     *
     * @param dict dictionary with pairs variable name-> value
     *
     * @return recursive call
     */
    @Override
    public int evaluate(HashMap<String, Integer> dict) {
        return First.evaluate(dict)/Second.evaluate(dict);
    }

    /**Override for equals method.
     *
     * @param obj with what compare
     *
     * @return recursive call
     */
    @Override
    public boolean equals(Object obj) {
        Div div = (Div)obj;
        return First.equals(div.First) && Second.equals(div.Second);
    }

    /**Override for toString method.
     *
     * @return recursive call
     */
    @Override
    public String toString() {
        return "("+First.toString()+"/"+Second.toString()+")";
    }

    /**Override for hash method.
     *
     * @return hash for multiple objects
     */
    @Override
    public int hashCode() {
        return Objects.hash(First, Second);
    }
}
