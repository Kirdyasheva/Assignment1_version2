/**
 * Created by Anastasia on 10.10.2017.
 */
public class Factor extends Expression {

    enum Opcode {
        multiplication, division
    }

    Opcode op;

    Factor(String operation, Expression left, Expression right) {
        this.left = left;
        this.right = right;
        switch (operation) {
            case "*":
                op = Opcode.multiplication;
                break;
            case "/":
                op = Opcode.division;
                break;
        }
    }

    public long calculate() {
        long r1 = left.calculate();
        long r2 = right.calculate();
        switch (op) {
            case multiplication:
                return r1 * r2;
            case division:
                return (long) (r1 / r2);
        }
        return 0;
    }

    public String toJSON() {
        String left = "{" + "\"left\":" + this.left.toJSON();
        String right = "\"right\":" + this.right.toJSON() + "}";
        return left + "," + "\"operator\":" + "\"" + op + "\"" + "," + right;
    }
}
