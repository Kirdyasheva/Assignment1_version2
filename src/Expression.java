abstract class Expression {

    protected Expression left, right;

    abstract long calculate();

    abstract String toJSON();
}
