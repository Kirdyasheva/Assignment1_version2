/**
 * Created by Anastasia on 12.10.2017.
 */
public class Term extends Expression {
    enum Opcode {
        plus, minus
    }

    Opcode op;

    Term(String operation, Expression left, Expression right) {
        this.left = left;
        this.right = right;
        switch (operation) {
            case "+":
                op = Opcode.plus;
                break;
            case "-":
                op = Opcode.minus;
                break;
        }
    }

    public long calculate() {
        long r1 = left.calculate();
        long r2 = right.calculate();
        switch (op) {
            case plus:
                return r1 + r2;
            case minus:
                return r1 - r2;
            default:
                return 0;

        }
    }

    public String toJSON() {
        String left = "{" + "\"left\":" + this.left.toJSON();
        String right = "\"right\":" + this.right.toJSON() + "}";
        return left + "," + "\"operator\":" + "\"" + op + "\"" + "," + right;
    }
}
