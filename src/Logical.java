import static java.lang.Math.abs;

public class Logical extends Expression {
    enum Opcode {
        and, or, xor, none
    }

    Opcode op;

    Logical(String operation, Expression left, Expression right) {
        this.left = left;
        this.right = right;
        switch (operation) {
            case "and":
                op = Opcode.and;
                break;
            case "xor":
                op = Opcode.xor;
                break;
            case "or":
                op = Opcode.or;
                break;
        }
    }

    public long calculate() {
        long r1 = left.calculate();
        long r2 = right.calculate();
        switch (op) {
            case and:
                return abs(r1) & abs(r2);
            case or:
                return abs(r1) | abs(r2);
            case xor:
                return abs(r1) ^ abs(r2);
            case none:
                return 0;
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
